package com.agillic.rover;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public class ChangeDirectionRightCommandExecutor implements CommandExecutor {

    private static final char ROTATE_RIGHT = 'R';

    @Override
    public boolean shouldExecute(final char command) {
        return ROTATE_RIGHT == command;
    }

    @Override
    public void executeSpecificCommand(final Position position) {
        position.changeDirectionRight();
    }
}
