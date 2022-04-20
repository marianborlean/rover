package com.agillic.rover;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public interface CommandExecutor {

    boolean shouldExecute(char command);

    default boolean execute(char command, Position position) {
        if (!shouldExecute(command)) {
            return false;
        }

        executeSpecificCommand(position);
        return true;
    }

    void executeSpecificCommand(Position position);
}
