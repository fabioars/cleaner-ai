package com.fsoares.machines.actions;

import com.fsoares.machines.actions.abstractions.ActionInterface;
import com.fsoares.machines.actions.abstractions.Movement;

public class MoveRight extends Move implements ActionInterface {

    public void act() {
        this.move(Movement.RIGHT);
    }
}
