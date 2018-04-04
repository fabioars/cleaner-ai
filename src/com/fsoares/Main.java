package com.fsoares;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.Cleaner;
import com.fsoares.util.NumberUtil;

public class Main {

    public static void main(String[] args) {
        Environment env = new Environment(5, 5);
        for(int i = 0; i < 10; i++) {
            int x = NumberUtil.randomInt(0, 4);
            int y = NumberUtil.randomInt(0, 4);

            env.dirty(x, y);
        }
        
        Cleaner cleaner = new Cleaner(env, new Position(0, 4));
        cleaner.run();
    }
}
