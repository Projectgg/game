package ru.sanchez6813.wolf.world;

import ru.sanchez6813.wolf.core.models.BaseManager;
import ru.sanchez6813.wolf.world.models.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Alex on 17.10.2016.
 */
public class WorldManager extends BaseManager {


    // =============================================================================================
    // FIELDS
    // =============================================================================================
    private boolean[] keys;
    private Player player;
    // =============================================================================================
    // CONSTRUCTOR
    // =============================================================================================
    public WorldManager() {
        keys = new boolean[65536];
        player = new Player();
    }

    // =============================================================================================
    // UPDATE
    // =============================================================================================
    @Override
    public void init() {
        initPlayer();
    }

    @Override
    public void update() {
        processInput();
        updatePlayer();
    }

    @Override
    public void render(Graphics g) {
        player.draw(g);
    }

    // =============================================================================================
    // PLAYER
    // =============================================================================================
    private void initPlayer() {
        player.x = width / 2 - player.width / 2;
        player.y = height - player.height;
    }

    private void updatePlayer() {
        player.move();
        if (player.x < 0) {
            player.x = 0;
        } else if (player.x + player.width > width) {
            player.x = width - player.width;
        }
    }

    // =============================================================================================
    // KEYBOARD EVENT HANDLERS
    // =============================================================================================
    private void processInput() {
        player.xVelocity = 0;
        if (keys[KeyEvent.VK_LEFT] && !keys[KeyEvent.VK_RIGHT]) {
            player.xVelocity = -Player.DEFAULT_X_VELOCITY;
        }
        if (!keys[KeyEvent.VK_LEFT] && keys[KeyEvent.VK_RIGHT]) {
            player.xVelocity = Player.DEFAULT_X_VELOCITY;
        }
        if (keys[KeyEvent.VK_UP]){
                player.y -= 10;

        }
        if (!keys[KeyEvent.VK_UP]){
            player.y = height - player.height;
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        if (code >= 0 && code < keys.length) {
            keys[code] = true;
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        if (code >= 0 && code < keys.length) {
            keys[code] = false;
        }
    }
}


