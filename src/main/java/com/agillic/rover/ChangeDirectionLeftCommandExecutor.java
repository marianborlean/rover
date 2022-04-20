package com.agillic.rover;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public class ChangeDirectionLeftCommandExecutor implements CommandExecutor {

    private static final char ROTATE_LEFT = 'L';

    @Override
    public boolean shouldExecute(final char command) {
        return ROTATE_LEFT == command;
    }

    @Override
    public void executeSpecificCommand(final Position position) {
        position.changeDirectionLeft();
    }
}
