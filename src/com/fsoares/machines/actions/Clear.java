package com.fsoares.machines.actions;

import com.fsoares.env.Environment;
import com.fsoares.machines.Machine;
import com.fsoares.machines.abstractions.ActionInterface;

public class Clear implements ActionInterface {

    private Machine context = null;

    public Machine getContext() {
        return context;
    }

    public Clear setContext(Machine context) {
        this.context = context;

        return this;
    }

    public void act() {
        Machine machine = this.getContext();
        Environment env = machine.getEnv();

        boolean isDirty = env.isDirty(machine.getPosition());

        if(isDirty) {
            env.clear(machine.getPosition());
        }
    }

}
