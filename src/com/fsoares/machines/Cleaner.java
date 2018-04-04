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
        Position closet = env.closestDirty(this.getPosition());

        boolean isAllClear = env.isAllClean();
        if(isAllClear || closet == null) {
            history.stop();

            return new Stay().setContext(this);
        }

        boolean isInSamePosition = closet.equals(this.getPosition());
        if(isInSamePosition) {
            return new Clear().setContext(this);
        }

        int diffX = this.getPosition().diffX(closet.getX());
        if(diffX > 0) {
            return new MoveLeft().setContext(this);
        } else if(diffX < 0) {
            return new MoveRight().setContext(this);
        }

        int diffY = this.getPosition().diffY(closet.getY());
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

        while (true) {
            ActionInterface nextAction = this.decide();
            this.addAction(nextAction);
            this.act();

            System.out.println(this.getPosition());
            System.out.println(this.getEnv());
            System.out.println(StringUtil.packageToClass(nextAction.getClass().toString()));

            if(!history.isRunning()) {
                System.out.println("Quantidade de ações: " + history.count());
                return;
            }

            this.waiting(TimeUtil.seconds(1));
        }
    }

}
