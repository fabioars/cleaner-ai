package com.fsoares.machines.actions;

import com.fsoares.env.Environment;
import com.fsoares.machines.Machine;
import com.fsoares.machines.actions.abstractions.ActionInterface;

public class Dirty implements ActionInterface {

    private Machine context = null;

    public Machine getContext() {
        return context;
    }

    public Dirty setContext(Machine context) {
        this.context = context;

        return this;
    }

    public void act() {
        Machine machine = this.getContext();
        Environment env = machine.getEnv();

        boolean isDirty = env.isDirty(machine.getPosition());

        if(!isDirty) {
            env.dirty(machine.getPosition());
        }
    }

}
