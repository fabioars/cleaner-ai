package com.fsoares;

import com.fsoares.env.Environment;
import com.fsoares.env.Position;
import com.fsoares.machines.Cleaner;
import com.fsoares.machines.abstractions.ActionInterface;
import com.fsoares.machines.actions.Clear;
import com.fsoares.util.NumberUtil;
import com.fsoares.util.StringUtil;

public class Main {

    public static void main(String[] args) {
        Environment env = new Environment(10, 10);
        for(int i = 0; i < 50; i++) {
            int x = NumberUtil.randomInt(0, 9);
            int y = NumberUtil.randomInt(0, 9);

            env.dirty(x, y);
        }

        Cleaner cleaner = new Cleaner(env, new Position(0, 0));
        cleaner.run();
    }
}
