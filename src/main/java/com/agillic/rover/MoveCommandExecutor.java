package com.agillic.rover;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public class MoveCommandExecutor implements CommandExecutor {

    private static final char MOVE_COMMAND = 'M';

    @Override
    public boolean shouldExecute(final char command) {
        return MOVE_COMMAND == command;
    }

    @Override
    public void executeSpecificCommand(final Position position) {
        position.move();
    }
}
