package com.fsoares.machines.actions;

import com.fsoares.env.Position;
import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.machines.abstractions.MovableInterface;
import com.fsoares.machines.abstractions.Movement;

public class Move implements ActionInterface {

    MovableInterface movable = null;

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
                nextPosition.setY(nextPosition.getY() - 1);
                break;

            case DOWN:
                nextPosition.setY(nextPosition.getY() + 1);
                break;

            case LEFT:
                nextPosition.setX(nextPosition.getX() - 1);
                break;

            case RIGHT:
                nextPosition.setX(nextPosition.getX() + 1);
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
