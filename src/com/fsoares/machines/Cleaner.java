package com.fsoares.machines;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.actions.*;
import com.fsoares.machines.actions.abstractions.ActionInterface;
import com.fsoares.util.Number;
import com.fsoares.util.Time;

public class Cleaner extends Machine implements Runnable {

    public Cleaner(Environment env, Position position) {
        super(env, position);
    }

    private ActionInterface decide() {
        Environment env = this.getEnv();
        Position closet = env.closestDurty(this.getPosition());

        if(closet == null) {
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
        while (true) {
            System.out.println(this.getPosition());
            System.out.println(this.getEnv());

            this.addAction(this.decide());
            this.act();
            this.waiting(Time.seconds(1));
        }
    }

}
