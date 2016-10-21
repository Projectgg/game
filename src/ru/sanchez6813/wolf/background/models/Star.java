package ru.sanchez6813.wolf.background.models;

import ru.sanchez6813.wolf.core.models.DrawableObject;
import ru.sanchez6813.wolf.utils.ColorUtils;
import ru.sanchez6813.wolf.utils.RandomUtils;

import java.awt.*;

/**
 * Created by Alex on 17.10.2016.
 */
public class Star extends DrawableObject {
    // =============================================================================================
    // CONSTANTS
    // =============================================================================================
    public static final int SPEED = -10;
    private static final int SIZE = 3;
    private static final int MIN_UPDATE_TO_CHANGE_VISIBILITY = 5;
    private static final int MAX_UPDATE_TO_CHANGE_VISIBILITY = 15;
    private static final float ALPHA = 0.4f;

    // =============================================================================================
    // FIELDS
    // =============================================================================================
    private final Color color;
    private int updatesToChangeVisibility;
    public boolean isVisible;

    // =============================================================================================
    // CONSTRUCTOR
    // =============================================================================================
    public Star() {
        width = SIZE;
        height = SIZE;
        color = ColorUtils.getRandomColor(ALPHA);
        updatesToChangeVisibility = RandomUtils.nextInt(MIN_UPDATE_TO_CHANGE_VISIBILITY, MAX_UPDATE_TO_CHANGE_VISIBILITY);
    }

    // =============================================================================================
    // METHODS
    // =============================================================================================
    public void update() {
        if (updatesToChangeVisibility-- == 0) {
            isVisible = !isVisible;
            updatesToChangeVisibility = RandomUtils.nextInt(MIN_UPDATE_TO_CHANGE_VISIBILITY, MAX_UPDATE_TO_CHANGE_VISIBILITY);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}
