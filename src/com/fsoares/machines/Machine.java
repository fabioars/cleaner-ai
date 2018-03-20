package com.fsoares.machines;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;

public abstract class Machine {

    private Position position = null;
    private Environment env = null;



    public final int MOVE_UP = 0;
    public final int MOVE_DOWN = 1;
    public final int MOVE_LEFT = 2;
    public final int MOVE_RIGHT = 0;

    public Machine(Environment env, Position position) {
        this.env = env;
        this.position = position;
    }

    public abstract Machine act();

//    public
}
