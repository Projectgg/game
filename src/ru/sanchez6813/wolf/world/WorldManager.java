package ru.sanchez6813.wolf.world;

import ru.sanchez6813.wolf.MainWindow;
import ru.sanchez6813.wolf.core.GameManager;
import ru.sanchez6813.wolf.core.models.BaseManager;
import ru.sanchez6813.wolf.world.models.Player;
import ru.sanchez6813.wolf.world.models.PlayerState;
import ru.sanchez6813.wolf.world.models.Rock;
import ru.sanchez6813.wolf.world.models.Stars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static ru.sanchez6813.wolf.world.models.PlayerState.LIVE;

public class WorldManager extends BaseManager {
    // =============================================================================================
    // FIELDS
    // =============================================================================================
    private boolean[] keys;
    private Player player;
    private Rock rock;
    private Stars stars;

    // =============================================================================================
    // CONSTRUCTOR
    // =============================================================================================
    public WorldManager() {
        keys = new boolean[65536];
        player = new Player();
        rock = new Rock();
        stars = new Stars();
        player.state = LIVE;
    }

    // =============================================================================================
    // UPDATE
    // =============================================================================================
    @Override
    public void init() {
        initPlayer();
        initRock();
        initStars();
    }

    @Override
    public void update() {
            processInput();
            updateRock();
            updateStars();
            updatePlayer();
    }

    @Override
    public void render(Graphics g) {

            player.draw(g);

        rock.draw(g);
        stars.draw(g);
    }

    // =============================================================================================
    // PLAYER, ROCK, STARS
    // =============================================================================================
    private void initPlayer() {
        player.x = 0;
        player.y = height - player.height;
    }
    private void initRock(){
        rock.x = rock.Position;
        rock.y = 390;
    }
    private void initStars(){
        stars.x = stars.PositionX;
        stars.y = 300;
    }

    private void updatePlayer() {
        player.move();
        if (player.yVelocity > 0) {
            player.yVelocity--;
        }
        if (player.yVelocity <= 0){
            player.yVelocity += 5;
        }
        if (player.y + player.height == height) {
            player.yVelocity = 0;
        }
        if (player.x < 0) {
            player.x = 0;
        } else if (player.x + player.width > width) {
            player.x = width - player.width;
        }
        if(player.isCollision(rock)){
            player.state = PlayerState.DEAD;
            JOptionPane.showMessageDialog(null, "Вы проиграли", "Проигрыш", JOptionPane.DEFAULT_OPTION);
            System.exit(0);
        }
    }
    private void updateRock(){
    rock.move();
        if (rock.x > 0){
    rock.xVelocity = Rock.DEFAULT_X_VELOCITY;
        }
        if (rock.x < -200)
        {
            initRock();
        }
    }
    private void updateStars(){
        stars.move();
        if (stars.x > 0) {
            stars.xVelocity = Stars.DEFAULT_X_VELOCITY;
        }
        if (stars.x < -200)
        {
            initStars();
        }
    }
    // =============================================================================================
    // KEYBOARD EVENT HANDLERS
    // =============================================================================================
    private void processInput() {
        if (keys[KeyEvent.VK_LEFT] && !keys[KeyEvent.VK_RIGHT]) {
            player.xVelocity = -Player.DEFAULT_X_VELOCITY;
        }
        if (!keys[KeyEvent.VK_LEFT] && keys[KeyEvent.VK_RIGHT]) {
            player.xVelocity = Player.DEFAULT_X_VELOCITY;
        }
        if (keys[KeyEvent.VK_UP]) {
            if (player.y + player.height == height) {
                {
                    player.yVelocity = -Player.DEFAULT_Y_VELOCITY;;
                }
            }
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


