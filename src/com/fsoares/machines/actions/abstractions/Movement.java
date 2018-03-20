package com.fsoares.machines.actions.abstractions;

import com.fsoares.util.Number;

public enum Movement {
    UP, DOWN, LEFT, RIGHT, STAY;

    public static Movement random() {
        int number = Number.randomInt(0, 4);

        switch (number) {
            case 0:
                return UP;

            case 1:
                return DOWN;

            case 2:
                return LEFT;

            case 3:
                return RIGHT;

            case 4:
                return STAY;

            default:
                return STAY;
        }
    }
}
