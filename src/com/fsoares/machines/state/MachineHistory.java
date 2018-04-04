package com.fsoares.machines.state;

import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.util.Fifo;

public class MachineHistory {

    private boolean isRunning = false;
    private Fifo<ActionInterface> actions = null;

    public MachineHistory() {
        this.actions = new Fifo<>();
    }

    public MachineHistory addAction(ActionInterface action) {
        this.actions.add(action);

        return this;
    }

    public Fifo<ActionInterface> getActions() {
        return actions;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void run() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }

    public int count() {
        return this.actions.size();
    }
}
