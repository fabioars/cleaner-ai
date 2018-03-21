package com.fsoares.machines;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.actions.abstractions.ActionInterface;
import com.fsoares.machines.actions.abstractions.MovableInterface;
import com.fsoares.util.Fifo;

public abstract class Machine extends Thread implements MovableInterface {

    private Environment env = null;
    private Fifo<ActionInterface> actions = null;

    public Machine(Environment env, Position position) {
        this.env = env;
        this.position.set(position);
        this.actions = new Fifo<>();
    }

    public Environment getEnv() {
        return env;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public Machine addAction(ActionInterface action) {
        this.actions.add(action);

        return this;
    }

    public Machine act() {
        ActionInterface action = this.actions.next();

        action.act();

        return this;
    }

    protected void waiting(long time) {
        try {
            this.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
