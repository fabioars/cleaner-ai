package com.fsoares;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.Cleaner;
import com.fsoares.util.NumberUtil;

public class Main {

    public static void main(String[] args) {
        Environment env = new Environment(1, 5);
        env.dirty(0, 0);

        Cleaner cleaner = new Cleaner(env, new Position(0, 4));
        cleaner.run();

    }
}
