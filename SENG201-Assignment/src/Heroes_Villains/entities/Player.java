package Heroes_Villains.entities;

import Heroes_Villains.Game;
import Heroes_Villains.graphics.Animation;
import Heroes_Villains.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Living {


    public String name;
    public BufferedImage up, down, left, right;
    public Game game;
    public Animation anim;


    @Override
    public void update() {
        //anim.update();
        if(game.getKeyboardListener().up || game.getKeyboardListener().arrowUp) {
            y-=1;
        }
        if(game.getKeyboardListener().left || game.getKeyboardListener().arrowLeft) {
            x-=1;
        }
        if(game.getKeyboardListener().down || game.getKeyboardListener().arrowDown) {
            y+=1;
        }
        if(game.getKeyboardListener().right || game.getKeyboardListener().arrowRight) {
            x+=1;
        }

    }

    @Override
    public void render(Graphics graphics) {
        //graphics.drawImage(getCurrentImage(anim), (int) x, (int) y, null);

        graphics.drawImage(Assets.playerDown, (int) x, (int) y, null);

        if(game.getKeyboardListener().up || game.getKeyboardListener().arrowUp) {
            graphics.drawImage(up, (int) x, (int) y, null);
        }
        if(game.getKeyboardListener().left || game.getKeyboardListener().arrowLeft) {
            graphics.drawImage(left, (int) x, (int) y, null);
        }
        if(game.getKeyboardListener().down || game.getKeyboardListener().arrowDown) {
            graphics.drawImage(down, (int) x, (int) y, null);
        }
        if(game.getKeyboardListener().right || game.getKeyboardListener().arrowRight) {
            graphics.drawImage(right, (int) x, (int) y, null);
        }

    }

    public Player(float x, float y, String name, BufferedImage image, Game game) {
        super(x, y);
        this.name = name;
        anim = new Animation(Assets.walkingUp, 500);
        up = Assets.playerUp;
        down = Assets.playerDown;
        left = Assets.playerLeft;
        right = Assets.playerRight;
        this.game = game;
    }

    private BufferedImage getCurrentImage(Animation tempAnim) {
        return tempAnim.getCurrentImage();
    }
}
