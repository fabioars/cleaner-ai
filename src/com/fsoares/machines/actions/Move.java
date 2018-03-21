package com.fsoares.machines.actions;

import com.fsoares.env.Position;
import com.fsoares.machines.actions.abstractions.ActionInterface;
import com.fsoares.machines.actions.abstractions.MovableInterface;
import com.fsoares.machines.actions.abstractions.Movement;

public class Move implements ActionInterface {

    MovableInterface movable = null;

    public Move() {}

    public Move(MovableInterface movable) {
        setContext(movable);
    }

    public MovableInterface getContext() {
        return movable;
    }

    public Move setContext(MovableInterface context) {
        this.movable = context;

        return this;
    }

    public Position move(Movement movement) {
        Position nextPosition = this.movable.position;
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

            case STAY:
                return nextPosition;

        }

        return nextPosition;
    }

    @Override
    public void act() {
        this.move(Movement.random());
    }
}
