package ru.sanchez6813.wolf.world.models;

import ru.sanchez6813.wolf.core.models.DrawableObject;
import ru.sanchez6813.wolf.utils.RandomUtils;

import java.awt.*;

/**
 * Created by Alex on 15.12.2016.
 */
public class Stars extends DrawableObject{
    public static final int DEFAULT_X_VELOCITY = -10;
    public static final int PositionX = RandomUtils.nextInt(801, 1200);
    public void draw(Graphics g) {
        g.setColor(Color.red);
    g.drawRect(x,y,50, 50);
    }
}
