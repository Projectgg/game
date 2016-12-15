package ru.sanchez6813.wolf.world.models;

import ru.sanchez6813.wolf.core.models.DrawableObject;
import ru.sanchez6813.wolf.utils.RandomUtils;

import java.awt.*;
import java.applet.Applet;

/**
 * Created by user142 on 07.12.2016.
 */
public class Rock extends DrawableObject{
    public static final int DEFAULT_X_VELOCITY = -10;
    public static final int Position = RandomUtils.nextInt(801, 1200);
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.drawArc(x, y, 150, 113, 0, 180);
    }
}
