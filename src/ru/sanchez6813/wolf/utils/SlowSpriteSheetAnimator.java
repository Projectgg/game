package ru.sanchez6813.wolf.utils;

import java.awt.*;

/**
 * Created by Alex on 17.10.2016.
 */
public class SlowSpriteSheetAnimator extends SpriteSheetAnimator {
    private static final int FRAME_INTERVAL_MILLIS = 30;

    private final int minSkipFrames;
    private final int maxSkipFrames;
    private int counter;

    public SlowSpriteSheetAnimator(SpriteSheet spriteSheet, EventsListener listener, int minSkipFrames, int maxSkipFrames) {
        super(spriteSheet, listener);
        this.minSkipFrames = minSkipFrames;
        this.maxSkipFrames = maxSkipFrames;
        updateCounter();
    }

    private void updateCounter() {
        counter = RandomUtils.nextInt(minSkipFrames, maxSkipFrames);
    }

    @Override
    public void drawNextFrame(Graphics g, int x, int y) {
        if (counter-- == 0) {
            updateCounter();
            super.drawNextFrame(g, x, y);
        } else {
            drawCurrentFrame(g, x, y);
        }
    }
}
