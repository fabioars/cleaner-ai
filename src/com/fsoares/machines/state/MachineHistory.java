package com.fsoares.machines.state;

import com.fsoares.machines.Machine;
import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.util.Fifo;
import com.fsoares.util.StringUtil;

import java.util.Date;

public class MachineHistory {

    private Machine machine;
    private boolean isRunning = false;
    private Fifo<ActionInterface> actions;
    private Date startTime;
    private Date endTime;

    public MachineHistory(Machine machine) {
        this.actions = new Fifo<>();
        this.setMachine(machine);
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
        this.startTime = new Date();
        this.endTime = null;

        this.isRunning = true;
    }

    public void stop() {
        this.endTime = new Date();

        this.isRunning = false;
    }

    public int count() {
        return this.actions.size();
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
