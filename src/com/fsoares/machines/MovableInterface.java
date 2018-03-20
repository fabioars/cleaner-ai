package com.fsoares.machines;

public interface MovableInterface {

    public final int MOVE_UP = 0;
    public final int MOVE_DOWN = 1;
    public final int MOVE_LEFT = 2;
    public final int MOVE_RIGHT = 0;

    public MovableInterface move(Movement movement);

}
