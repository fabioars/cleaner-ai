package com.fsoares;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.Cleaner;
import com.fsoares.util.Number;

public class Main {

    public static void main(String[] args) {
        Environment env = new Environment(5, 5);

        env.dirty(4, 1)
            .dirty(1, 1)
            .dirty(2, 3);

        Cleaner cleaner = new Cleaner(env, new Position(Number.randomInt(0, 5), Number.randomInt(0, 5)));
        cleaner.run();
    }
}
