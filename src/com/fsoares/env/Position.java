package com.fsoares.env;

import java.util.Objects;

public class Position {

    private int x = 0;
    private int y = 0;

    public Position(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public static Position getInstance(int x, int y) {
        return new Position(x, y);
    }

    public Position set(Position position) {
        this.setX(position.getX());
        this.setY(position.getY());

        return this;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int diffY(int y) {
        return y - this.y;
    }

    public int diffX(int x) {
        return x;
    }

    public int distance(int x, int y) {
        int xDiff = Math.abs(this.diffX(x));
        int yDiff = Math.abs(this.diffY(y));

        return xDiff + yDiff;
    }

    public int distance(Position position) {
        return this.distance(position.getX(), position.getY());
    }

    @Override
    public Position clone() {
        return Position.getInstance(this.getX(), this.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }
}
