package com.agillic.rover;

import java.util.Objects;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public class Point {

    private int value;
    private int maxValue;
    private int minValue;

    public Point(final int value, final int maxValue) {
        setMaxValue(maxValue);
        setMinValue(0);
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setValue(final int value) {
        if (isHigherThanMaxValue(value) || isLowerThanMinValue(value)) {
            throw new RuntimeException("Value needs to be > " + minValue + " and < " + maxValue);
        }
        this.value = value;
    }

    public void setMaxValue(final int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(final int minValue) {
        this.minValue = minValue;
    }

    private boolean isHigherThanMaxValue(int value) {
        return value > maxValue;
    }

    private boolean isLowerThanMinValue(int value) {
        return value < minValue;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return value == point.value && maxValue == point.maxValue && minValue == point.minValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, maxValue, minValue);
    }
}
