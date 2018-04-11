package com.fsoares.machines;

import com.fsoares.env.Bounds;
import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.machines.abstractions.AgentInterface;
import com.fsoares.machines.actions.*;
import com.fsoares.util.NumberUtil;
import com.fsoares.util.StringUtil;
import com.fsoares.util.TimeUtil;

public class Dirter extends Machine implements Runnable, AgentInterface {

    public Dirter(Environment env, Position position) {
        super(env, position);
    }

    private boolean testMoviment(Move movement) {
        Bounds bounds = this.getEnv().getBounds();
        int currentX = this.getPosition().getX();
        int currentY = this.getPosition().getY();

        switch (movement.getNext()) {
            case UP:
                return bounds.isInBounds(currentX, currentY - 1);

            case DOWN:
                return bounds.isInBounds(currentX, currentY + 1);

            case LEFT:
                return bounds.isInBounds(currentX - 1, currentY);

            case RIGHT:
                return bounds.isInBounds(currentX + 1, currentY);

            case STAY:
                return true;

            default:
                return false;
        }

    }

    public ActionInterface decide() {
        Environment env = this.getEnv();

        boolean isAllClear = env.isAllClean();
        if(isAllClear) {
            history.stop();

            return new Stay().setContext(this);
        }

        while(true) {
            int actionRandomDecider = NumberUtil.randomInt(0, 100);
            Position currentPosition = this.getPosition();

            if(!env.isDirty(currentPosition) && actionRandomDecider >= 50) {
                return new Dirty().setContext(this);
            } else {
                Move move = new Move();
                boolean isValidMovement = testMoviment(move);

                if(isValidMovement) {
                    return move;
                }
            }
        }
    }

    public void run() {
        this.history.run();

        while (history.isRunning()) {
            ActionInterface nextAction = this.decide();
            this.addAction(nextAction);
            this.act();

            System.out.println("Sujador: " + this.getPosition());
            System.out.println("Sujador: " + StringUtil.packageToClass(nextAction.getClass().toString()));

            this.waiting(TimeUtil.seconds(8));
        }

        System.out.println("Ações Sujador: " + history.count());
    }

    @Override
    protected Object clone() {
        return new Dirter(this.getEnv(), Position.getInstance(this.getPosition().getX(), this.getPosition().getX()));
    }
}
