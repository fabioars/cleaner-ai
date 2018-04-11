package com.fsoares.machines.actions;

import com.fsoares.env.Position;
import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.machines.abstractions.MovableInterface;
import com.fsoares.machines.abstractions.Movement;

public class Move implements ActionInterface {

    private Movement next;
    private MovableInterface context;

    public Move() {
        next = Movement.random();
    }

    public MovableInterface getContext() {
        return context;
    }

    public Move setContext(MovableInterface context) {
        this.context = context;

        return this;
    }

    public Movement getNext() {
        return next;
    }

    public Position move(Movement movement) {
        Position next = this.getContext().position;

        switch (movement) {
            case UP:
                next.setY(next.getY() - 1);
                break;

            case DOWN:
                next.setY(next.getY() + 1);
                break;

            case LEFT:
                next.setX(next.getX() - 1);
                break;

            case RIGHT:
                next.setX(next.getX() + 1);
                break;

            case STAY:
                return next;

        }

        return next;
    }

    @Override
    public void act() {
        this.move(this.next);
    }
}
