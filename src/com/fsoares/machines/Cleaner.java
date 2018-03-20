package com.fsoares.machines;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.util.Time;

public class Cleaner extends Machine implements Runnable {

    public Cleaner(Environment env, Position position) {
        super(env, position);
    }

    public void run() {
        while (true) {
            Environment env = this.getEnv();
            Position closet = env.closestDurty(this.getPosition());

            System.out.println(closet);
            System.out.println(env);

            this.waiting(Time.seconds(1));
        }
    }

}
