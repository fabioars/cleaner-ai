package com.fsoares.env;

public class Bounds {

    private Position positionInitial = new Position(0, 0);
    private Position positionFinal = null;

    public Bounds(int x, int y) {
        this.positionFinal = new Position(x, y);
    }

    public Bounds(Position finalPosition) {
        this.positionFinal = finalPosition;
    }

    public boolean isInBounds(int x, int y) {
        boolean isInX = x >= positionInitial.getX() && x <= positionFinal.getX();
        boolean isInY = y >= positionInitial.getY() && y <= positionFinal.getY();

        return isInX && isInY;
    }

    public boolean isInBounds(Position position) {
        return this.isInBounds(position.getX(), position.getY());
    }

    public Position getPositionInitial() {
        return positionInitial;
    }

    public void setPositionInitial(Position positionInitial) {
        this.positionInitial = positionInitial;
    }

    public Position getPositionFinal() {
        return positionFinal;
    }

    public void setPositionFinal(Position positionFinal) {
        this.positionFinal = positionFinal;
    }

    @Override
    public String toString() {
        return String.format("Bounds: [x: %s y:%s] [x: %s y: %s]", positionInitial.getX(), positionInitial.getY(), getPositionFinal().getX(), getPositionFinal().getY());
    }
}
