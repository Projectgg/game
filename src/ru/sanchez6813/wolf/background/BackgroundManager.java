package ru.sanchez6813.wolf.background;

import ru.sanchez6813.wolf.background.models.Star;
import ru.sanchez6813.wolf.core.models.BaseManager;
import ru.sanchez6813.wolf.utils.RandomUtils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alex on 17.10.2016.
 */
public class BackgroundManager extends BaseManager {
    // =============================================================================================
    // CONSTANTS
    // =============================================================================================
    private static final int STAR_COUNT = 100;

    // =============================================================================================
    // FIELDS
    // =============================================================================================
    private ArrayList<Star> stars;

    // =============================================================================================
    // CONSTRUCTOR
    // =============================================================================================
    public BackgroundManager() {
        stars = new ArrayList<Star>();

    }

    // =============================================================================================
    // METHODS
    // =============================================================================================
    @Override
    public void init() {
        for (int i = 0; i < STAR_COUNT; i++) {
            Star star = new Star();
            star.x = RandomUtils.nextInt(width);
            star.y = RandomUtils.nextInt(height);
            star.isVisible = RandomUtils.nextBoolean();
            stars.add(star);
        }
    }

    @Override
    public void update() {
        for (Star star : stars) {
            star.update();
            star.x += Star.SPEED;
            if (star.x < 0) {
                star.x = width;
                star.y = RandomUtils.nextInt(height);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (stars != null) {
            for (Star star : stars) {
                if (star.isVisible) {
                    star.draw(g);
                }
            }
        }
    }
}
