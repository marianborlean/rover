package com.agillic.rover;

import java.util.Arrays;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public enum Direction {

    NORTH("N", "W", "E", 0, 1),
    EAST("E", "N", "S", 1, 0),
    SOUTH("S", "E", "W", 0, -1),
    WEST("W", "S", "N", -1, 0);

    private final String nameAbbreviation;
    private final String left;
    private final String right;
    private final int nextX;
    private final int nextY;

    Direction(String nameAbbreviation, String left, String right, int nextX, int nextY) {
        this.nameAbbreviation = nameAbbreviation;
        this.left = left;
        this.right = right;
        this.nextX = nextX;
        this.nextY = nextY;
    }

    public String getNameAbbreviation() {
        return nameAbbreviation;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }

    public static Direction getDirectionFromNameAbbreviation(final String nameAbbr) {
        return Arrays.stream(Direction.values())
                .filter(d -> d.nameAbbreviation.equals(nameAbbr))
                .findAny()
                .orElseThrow(() -> new RuntimeException(nameAbbr + " is an invalid nameAbbreviation for direction"));
    }
}
