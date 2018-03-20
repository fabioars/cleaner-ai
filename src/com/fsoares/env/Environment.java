package com.fsoares.env;

public class Environment {

    private int env[][] = null;
    private int width = 0;
    private int height = 0;

    public static final int CLEAR = 1;
    public static final int DIRTY = 1;

    public Environment(int width, int height) {
        this.env = new int[width][height];
        this.width = width;
        this.height = height;

        this.clear();
    }

    public Environment clear(int x, int y) {
        this.env[x][y] = Environment.CLEAR;
        return this;
    }

    public Environment clear(Position position) {
        this.clear(position.getX(), position.getY());
        return this;
    }

    public Environment clear() {
        return this.forEach((Position position, boolean isDuty, Environment context) -> {
            context.clear(position.getX(), position.getY());
        });
    }

    public Environment forEach(EnvironmentIterable interable) {
        for(int x = 0; x <= width; x++) {
            for(int y = 0; y <= height; y++) {
                interable.each(Position.getInstance(x, y), this.isDirty(x, y), this);
            }
        }

        return this;
    }

    public boolean isDirty(int x, int y) {
        return this.env[x][y] == Environment.DIRTY;
    }

    public boolean isDirty(Position position) {
        return this.isDirty(position.getX(), position.getY());
    }

    public boolean isClean(int x, int y) {
        return this.env[x][y] == Environment.CLEAR;
    }

    public boolean isClean(Position position) {
        return this.isClean(position.getX(), position.getY());
    }

    public Environment dirty(int x, int y) {
        this.env[x][y] = Environment.DIRTY;
        return this;
    }

    public Environment dirty(Position position){
        this.dirty(position.getX(), position.getY());
        return this;
    }

    public Position closestDurty(Position pos) {
        final Position closest = new Position(-1, -1);
        this.forEach((Position position, boolean isDuty, Environment context) -> {
            if(isDuty && position.distance(pos) >= closest.distance(pos)) {
                closest.set(position);
            }
        });

        return closest;
    }
}
