package ru.sanchez6813.wolf.world.models;

import ru.sanchez6813.wolf.core.models.DrawableObject;
import ru.sanchez6813.wolf.utils.ResourcesLoader;

import java.awt.*;

/**
 * Created by Alex on 17.10.2016.
 */
public class Player extends DrawableObject {
    public static final int DEFAULT_X_VELOCITY = 10;


    private Image sprite;


    public Player() {
        sprite = ResourcesLoader.loadDrawableIgnoreErrors("player_ship.png");
        width = sprite.getWidth(null);
        height = sprite.getHeight(null);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, null);
    }

}
