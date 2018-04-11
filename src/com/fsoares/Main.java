package com.fsoares;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.Cleaner;
import com.fsoares.machines.Dirter;
import com.fsoares.util.NumberUtil;

public class Main {

    public static void main(String[] args) {
        Environment env = new Environment(10, 10);
        for(int i = 0; i < 5; i++) {
            int x = NumberUtil.randomInt(0, 9);
            int y = NumberUtil.randomInt(0, 9);

            env.dirty(x, y);
        }

        Thread cleaner = new Thread(new Cleaner(env, new Position(0, 0)));
        cleaner.start();

        Thread dirter = new Thread(new Dirter(env, new Position(9, 9)));
        dirter.start();
    }
}
