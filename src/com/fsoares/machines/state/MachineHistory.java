package com.fsoares.machines.state;

import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.util.Fifo;

import java.util.Date;

public class MachineHistory {

    private boolean isRunning = false;
    private Fifo<ActionInterface> actions;
    private Date startTime;
    private Date endTime;

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
        startTime = new Date();
        endTime = null;

        isRunning = true;
    }

    public void stop() {
        endTime = new Date();

        isRunning = false;
    }

    public int count() {
        return this.actions.size();
    }
}
