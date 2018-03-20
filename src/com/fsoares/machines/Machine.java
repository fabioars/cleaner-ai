package com.fsoares.machines;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;

public abstract class Machine implements ActionInterface, MovableInterface {

    private Position position = null;
    private Environment env = null;

    public Machine(Environment env, Position position) {
        this.env = env;
        this.position = position;
    }

    @Override
    public ActionInterface act() {
        return null;
    }

    @Override
    public MovableInterface move(Movement movement) {
        Position nextPosition = this.position.clone();
        switch (movement) {
            case UP:
                nextPosition.setY(position.getY() - 1);
                break;

            case DOWN:
                nextPosition.setY(position.getY() + 1);
                break;

            case LEFT:
                nextPosition.setX(position.getX() - 1);
                break;

            case RIGHT:
                nextPosition.setX(position.getX() + 1);
                break;
        }

        if(this.env.getBounds().isInBounds(nextPosition)) {
            this.position.set(nextPosition);
        }

        return this;
    }
}
