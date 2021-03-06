package com.fsoares.env;

import com.fsoares.util.BooleanUtil;

public class Environment {

    private int env[][] = null;
    private Bounds bounds = null;

    private static final int CLEAR = 0;
    private static final int DIRTY = 1;

    public Environment(int width, int height) {
        this.env = new int[width][height];
        this.bounds = new Bounds(width - 1, height - 1);

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
        for (int x = 0; x <= this.bounds.getPositionFinal().getX(); x++) {
            for (int y = 0; y <= this.bounds.getPositionFinal().getY(); y++) {
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

    public Environment dirty(Position position) {
        this.dirty(position.getX(), position.getY());
        return this;
    }

    public Position closestDirty(Position ref) {
        final Position closest = new Position(-1, -1);
        this.forEach((Position position, boolean isDirty, Environment context) -> {
            if(isDirty && !bounds.isInBounds(closest)) {
                closest.set(position);
            }

            if (isDirty && position.distance(ref) <= closest.distance(ref)) {
                closest.set(position);
            }
        });

        if(!bounds.isInBounds(closest)) {
            return null;
        }

        return closest;
    }

    public Position closestDirty(int x, int y) {
        return this.closestDirty(Position.getInstance(x, y));
    }

    public Bounds getBounds() {
        return this.bounds;
    }

    public boolean isAllClean() {
        final BooleanUtil ref = new BooleanUtil(true);

        this.forEach((Position position, boolean isDirty, Environment context) -> {
            if(isDirty) {
                ref.setRef(false);
            }
        });

        return ref.isRef();
    }

    @Override
    public String toString() {
        StringBuilder partial = new StringBuilder("");

        for(int x = 0; x <= this.bounds.getPositionFinal().getX(); x++) {
            for(int y = 0; y <= this.bounds.getPositionFinal().getY(); y++) {
                partial.append(this.env[x][y] == 1 ? "+" : "0");
            }

            partial.append("\n");
        }

        return partial.toString();
    }
}
