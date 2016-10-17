package ru.sanchez6813.wolf.utils;

import java.awt.*;

/**
 * Created by Alex on 17.10.2016.
 */
public final class ColorUtils {
    private ColorUtils() {
        // don't instantiate
    }

    public static Color getRandomColor(float alpha) {
        return new Color(RandomUtils.nextFloat(), RandomUtils.nextFloat(), RandomUtils.nextFloat(), alpha);
    }
}