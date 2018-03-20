package com.fsoares.machines.actions;

import com.fsoares.env.Position;
import com.fsoares.machines.actions.abstractions.MovableInterface;
import com.fsoares.machines.actions.abstractions.Movement;

public class Move {

    MovableInterface movable = null;

    public MovableInterface getContext() {
        return movable;
    }

    public Move setContext(MovableInterface context) {
        this.movable = context;

        return this;
    }

    public Position move(Movement movement) {
        Position nextPosition = this.movable.position.clone();
        switch (movement) {
            case UP:
                nextPosition.setY(movable.position.getY() - 1);
                break;

            case DOWN:
                nextPosition.setY(movable.position.getY() + 1);
                break;

            case LEFT:
                nextPosition.setX(movable.position.getX() - 1);
                break;

            case RIGHT:
                nextPosition.setX(movable.position.getX() + 1);
                break;

        }

        return nextPosition;
    }
}
