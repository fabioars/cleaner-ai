package com.fsoares.machines.abstractions;

import com.fsoares.env.Position;

public interface MovableInterface {

    Position position = new Position(0, 0);

    Position getPosition();

}
