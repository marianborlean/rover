package com.agillic.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public class RoverTest {

    private Rover rover;
    private Position position;
    private final Direction direction = Direction.NORTH;
    private Point x;
    private Point y;

    @BeforeEach
    public void before() {
        x = new Point(1, 9);
        y = new Point(2, 9);
        position = new Position(x, y, direction);
        rover = new Rover(position);
    }


    @Test
    public void testReceiveMoveCommandShouldMoveOnePosition() {
        rover.receiveCommands("M");
        assertEquals(rover.toString(), "1 3 N");
    }


    @Test
    public void testReceiveCommandShouldTurnLeftWhenCommandIsL() {
        rover.receiveCommands("L");
        assertEquals(rover.toString(), "1 2 W");
    }

    @Test
    public void testReceiveCommandShouldTurnRightWhenCommandIsR() {
        rover.receiveCommands("R");
        assertEquals(rover.toString(), "1 2 E");
    }


    @Test()
    public void testReceiveCommandShouldThrowExceptionWhenCommandIsUnknown()  {
        assertThrows(RuntimeException.class, () -> {
            rover.receiveCommands("H");
        });

    }

    @Test
    public void testReceiveCommandsShouldBeAbleToHandleMultipleCommands()  {
        rover.receiveCommands("LMLMLMLMM");
        assertEquals(rover.toString(), "1 3 N");
    }

}
