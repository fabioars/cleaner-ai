package com.fsoares.machines;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.machines.abstractions.AgentInterface;
import com.fsoares.machines.abstractions.MovableInterface;
import com.fsoares.machines.state.MachineHistory;
import com.fsoares.util.Fifo;

public abstract class Machine extends Thread implements MovableInterface, AgentInterface {

    private Environment env;

    protected MachineHistory history = new MachineHistory();

    public Machine(Environment env, Position position) {
        this.env = env;
        this.position.set(position);
    }

    public Environment getEnv() {
        return env;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void addAction(ActionInterface action) {
        actions.add(action);
    }

    public void act() {
        ActionInterface action = this.actions.next();
        history.addAction(action);

        action.act();
    }

    protected void waiting(long time) {
        try {
            this.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
