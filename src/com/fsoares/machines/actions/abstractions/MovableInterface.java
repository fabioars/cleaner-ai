package com.fsoares.machines.actions.abstractions;

import com.fsoares.env.Position;

public interface MovableInterface {

    final Position position = new Position(0, 0);

    public Position getPosition();

}
