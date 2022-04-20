package com.agillic.rover;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public class Rover {

    private final Position position;
    private static final List<CommandExecutor> commandExecutors = new ArrayList<>();

    static {
        commandExecutors.add(new MoveCommandExecutor());
        commandExecutors.add(new ChangeDirectionLeftCommandExecutor());
        commandExecutors.add(new ChangeDirectionRightCommandExecutor());
    }


    public Rover(final Position position) {
        this.position = position;
    }

    public void receiveCommands(final String commands) {
        for (char command : commands.toCharArray()) {
            validateCommand(command);
            for (CommandExecutor commandExecutor : commandExecutors) {
                boolean wasCommandExecuted = commandExecutor.execute(command, position);
                if (wasCommandExecuted) {
                    break;
                }
            }
        }
    }

    private void validateCommand(final char command) {
        commandExecutors.stream()
                .filter(ce -> ce.shouldExecute(command))
                .findAny().orElseThrow(() -> new RuntimeException("Invalid command " + command));
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
