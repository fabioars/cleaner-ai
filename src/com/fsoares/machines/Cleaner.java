package com.fsoares.machines;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.actions.*;
import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.machines.abstractions.AgentInterface;
import com.fsoares.util.StringUtil;
import com.fsoares.util.TimeUtil;

public class Cleaner extends Machine implements Runnable, AgentInterface {

    public Cleaner(Environment env, Position position) {
        super(env, position);
    }

    public ActionInterface decide() {
        Environment env = this.getEnv();
        Position closest = env.closestDirty(this.getPosition());

        boolean isAllClear = env.isAllClean();
        if(isAllClear || closest == null) {
            history.stop();

            return new Stay().setContext(this);
        }

        boolean isInSamePosition = closest.equals(this.getPosition());
        if(isInSamePosition) {
            return new Clear().setContext(this);
        }

        int diffX = this.getPosition().diffX(closest.getX());
        if(diffX > 0) {
            return new MoveLeft().setContext(this);
        } else if(diffX < 0) {
            return new MoveRight().setContext(this);
        }

        int diffY = this.getPosition().diffY(closest.getY());
        if(diffY > 0) {
            return new MoveUp().setContext(this);
        } else if(diffY < 0) {
            return new MoveDown().setContext(this);
        }

        // Stay
        return new Stay().setContext(this);
    }

    public void run() {
        this.history.run();

        while (history.isRunning()) {
            ActionInterface nextAction = this.decide();
            this.addAction(nextAction);
            this.act();

            System.out.println("Limpador: " + this.getPosition());
            System.out.println("Limpador: " + StringUtil.packageToClass(nextAction.getClass().toString()));

            System.out.println(this.getEnv());

            this.waiting(TimeUtil.seconds(1));
        }

        System.out.println("Ações Limpador: " + history.count());
    }

}
