package ru.sanchez6813.wolf.utils;

import java.util.Random;

/**
 * Created by Alex on 17.10.2016.
 */
public final class RandomUtils {
    private RandomUtils() {
        // don't instantiate
    }

    private static final Random RAND = new Random();

    public static boolean nextBoolean() {
        return RAND.nextBoolean();
    }

    public static int nextInt(int bound) {
        return RAND.nextInt(bound);
    }

    public static int nextInt(int min, int max) {
        return RAND.nextInt(max - min) + min;
    }

    public static float nextFloat() {
        return RAND.nextFloat();
    }
}
