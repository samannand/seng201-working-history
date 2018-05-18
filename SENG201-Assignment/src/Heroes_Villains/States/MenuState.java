package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class MenuState extends State {

    private UIElement startButton;
    private UIElement exitButton;
    private UIElement controlsButton;

    public MenuState(Game game) {
        super(game);
        startButton = new UIButton(540, 343, game, Assets.startButton, 200, 35);
        controlsButton = new UIButton(540, 413, game, Assets.controlsButton, 200, 35);
        exitButton = new UIButton(540, 483, game, Assets.exitButton, 200, 35);
    }

    @Override
    public void update() {
        startButton.update();
        controlsButton.update();
        exitButton.update();
        if(game.getMouseListener().isLeftClicked() && startButton.click()){
            game.getStateHandler().setState(game.getGameState());
        }

    }

    @Override
    public void render(Graphics graphics) {
        startButton.render(graphics);
        exitButton.render(graphics);
        controlsButton.render(graphics);
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Heroes And Villains" , 200, 200);
    }
}
