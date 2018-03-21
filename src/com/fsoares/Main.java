package com.fsoares;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.Cleaner;
import com.fsoares.util.Number;

public class Main {

    public static void main(String[] args) {
        Environment env = new Environment(10, 10);

        for(int i = 0; i < 10; i ++) {
            env.dirty(Number.randomInt(0, 9), Number.randomInt(0, 9));
        }


        Cleaner cleaner = new Cleaner(env, new Position(0, 0));
        cleaner.run();

    }
}
