package com.agillic.rover;

import java.util.Objects;

import static com.agillic.rover.Direction.getDirectionFromNameAbbreviation;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public class Position {

    private final Point x;
    private final Point y;
    private Direction direction;

    public Position(final Point x, final Point y, final Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public void move() {
        this.x.setValue(x.getValue() + direction.getNextX());
        this.y.setValue(y.getValue() + direction.getNextY());
    }

    public void changeDirectionLeft() {
        final String leftAbbrNameOfCurrentDirection = this.direction.getLeft();
        setDirection(getDirectionFromNameAbbreviation(leftAbbrNameOfCurrentDirection));
    }

    public void changeDirectionRight() {
        final String rightAbbrNameOfCurrentDirection = this.direction.getRight();
        setDirection(getDirectionFromNameAbbreviation(rightAbbrNameOfCurrentDirection));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return Objects.equals(x, position.x) && Objects.equals(y, position.y) && direction == position.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }

    @Override
    public String toString() {
        return x.getValue() + " " + y.getValue() + " " + direction.getNameAbbreviation();
    }
}
