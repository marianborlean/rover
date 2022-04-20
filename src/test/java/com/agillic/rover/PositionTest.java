package com.agillic.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public class PositionTest {

    private Position actual;
    private Point x;
    private Point y;
    private final Direction direction = Direction.NORTH;

    @BeforeEach
    public void before() {
        x = new Point(4, 5);
        y = new Point(4, 5);
        actual = new Position(x, y, direction);
    }

    @Test
    public void testMoveShouldIncreaseYWhenDirectionIsNorth() {
        Position expected = new Position(x, new Point(y.getValue() + 1, y.getMaxValue()), direction);
        actual.move();
        assertEquals(actual, expected);
    }

    @Test
    public void testMoveShouldIncreaseXWhenDirectionIsEast() {
        actual.setDirection(Direction.EAST);
        Position expected = new Position(new Point(x.getValue() + 1, x.getMaxValue()), y, Direction.EAST);
        actual.move();
        assertEquals(actual, expected);
    }

    @Test
    public void testMoveShouldDecreaseYWhenDirectionIsSouth() {
        actual.setDirection(Direction.SOUTH);
        Position expected = new Position(x, new Point(y.getValue() - 1, y.getMaxValue()), Direction.SOUTH);
        actual.move();
        assertEquals(actual, expected);
    }

    @Test
    public void testMoveShouldDecreaseXWhenDirectionIsWest() {
        actual.setDirection(Direction.WEST);
        Position expected = new Position(new Point(x.getValue() - 1, x.getMaxValue()), y, Direction.WEST);
        actual.move();
        assertEquals(actual, expected);
    }

    @Test
    public void testMoveTwiceInNorthDirectionShouldThrowErrorBecauseYExceedsMaxValue() {
        assertThrows(RuntimeException.class, () -> {
            actual.move();
            actual.move();
        });
    }

    @Test
    public void testMoveTwiceInEastDirectionShouldThrowErrorBecauseXExceedsMaxValue() {
        actual.setDirection(Direction.EAST);
        assertThrows(RuntimeException.class, () -> {
            actual.move();
            actual.move();
        });
    }

    @Test
    public void testChangeDirectionToRightFromNorthShouldResultInEast() {
        Position expected = new Position(x, y, Direction.EAST);
        actual.changeDirectionRight();
        assertEquals(actual, expected);
    }

    @Test
    public void testChangeDirectionToLeftFromNorthShouldResultInWest() {
        Position expected = new Position(x, y, Direction.WEST);
        actual.changeDirectionLeft();
        assertEquals(actual, expected);
    }

    @Test
    public void testChangeDirectionToRightFromEastShouldResultInSouth() {
        actual.setDirection(Direction.EAST);
        Position expected = new Position(x, y, Direction.SOUTH);
        actual.changeDirectionRight();
        assertEquals(actual, expected);
    }

    @Test
    public void testChangeDirectionToLeftFromEastShouldResultInNorth() {
        actual.setDirection(Direction.EAST);
        Position expected = new Position(x, y, Direction.NORTH);
        actual.changeDirectionLeft();
        assertEquals(actual, expected);
    }

    @Test
    public void testChangeDirectionToRightFromSouthShouldResultInWest() {
        actual.setDirection(Direction.SOUTH);
        Position expected = new Position(x, y, Direction.WEST);
        actual.changeDirectionRight();
        assertEquals(actual, expected);
    }

    @Test
    public void testChangeDirectionToLeftFromSouthShouldResultInEast() {
        actual.setDirection(Direction.SOUTH);
        Position expected = new Position(x, y, Direction.EAST);
        actual.changeDirectionLeft();
        assertEquals(actual, expected);
    }

    @Test
    public void testChangeDirectionToRightFromWestShouldResultInNorth() {
        actual.setDirection(Direction.WEST);
        Position expected = new Position(x, y, Direction.NORTH);
        actual.changeDirectionRight();
        assertEquals(actual, expected);
    }

    @Test
    public void testChangeDirectionToLeftFromWestShouldResultInSouth() {
        actual.setDirection(Direction.WEST);
        Position expected = new Position(x, y, Direction.SOUTH);
        actual.changeDirectionLeft();
        assertEquals(actual, expected);
    }


}
