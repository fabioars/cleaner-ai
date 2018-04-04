package com.fsoares.machines.actions;

import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.machines.abstractions.Movement;

public class Stay extends Move implements ActionInterface {

    public void act() {
        this.move(Movement.STAY);
    }
}
