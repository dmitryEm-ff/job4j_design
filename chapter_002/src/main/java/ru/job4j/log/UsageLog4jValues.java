package ru.job4j.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4jValues {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte by = 127;
        short sh = 32767;
        int in = 2147483647;
        long lo = 922;
        float fl = 3.4f;
        double du = 1.7d;
        char ch = 'A';
        boolean bo = true;

        LOG.debug("Variables : byte - {}; short - {}; int - {}; long - {};"
                + "float - {}; double - {}; char - {}; boolean - {}", by, sh, in, lo, fl, du, ch, bo);
    }
}