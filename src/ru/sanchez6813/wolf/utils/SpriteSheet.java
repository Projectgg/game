package ru.sanchez6813.wolf.utils;

import java.awt.*;

/**
 * Created by Alex on 17.10.2016.
 */
public final class SpriteSheet {
    final Image sprite;
    final int frameWidth;
    final int frameHeight;
    final int framesPerRow;
    final int framesTotal;

    public SpriteSheet(String spriteName, int frameWidth, int frameHeight) {
        sprite = ResourcesLoader.loadDrawableIgnoreErrors(spriteName);
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        framesPerRow = sprite.getWidth(null) / frameWidth;
        int framesPerCol = sprite.getHeight(null) / frameHeight;
        framesTotal = framesPerRow * framesPerCol;
    }
}
