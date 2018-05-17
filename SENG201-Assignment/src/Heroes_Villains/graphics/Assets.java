package Heroes_Villains.graphics;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage black, purple, playerUp, playerDown, playerLeft, playerRight, villain, innkeep, inn, innFloor, inventory;
    public static Font titleFont, invFont;
    private static int widthSheet1 = 16;
    private static int heightSheet1 = 16;
    private static int widthPlayerSheet = 32;
    private static int heightPlayerSheet = 32;
    public static int batDim = 32;
    public static int buttonHeight, buttonWidth;

    //Buffered image arrays for animations
    public static BufferedImage[] walkingUp, startButton, menuButton, backButton, batUp, batDown, batLeft, batRight, battleButton;

    public static void init() {
        SpriteSheet sheet1 = new SpriteSheet("/textures/sheets/tiles.png");
        SpriteSheet playerSheet = new SpriteSheet("/textures/sheets/PlayerSheet.png");
        SpriteSheet batSheet = new SpriteSheet("/textures/sheets/32x32-bat-sprite.png");
        SpriteSheet villainSheet = new SpriteSheet("/textures/sheets/4.png");
        walkingUp = new BufferedImage[3];
        startButton = new BufferedImage[2];
        menuButton = new BufferedImage[2];
        backButton = new BufferedImage[2];
        battleButton = new BufferedImage[2];
        batDown = new BufferedImage[3];
        batUp = new BufferedImage[3];
        batLeft = new BufferedImage[3];
        batRight = new BufferedImage[3];

        //Setting default button width and height
        buttonHeight = 256;
        buttonWidth = 1024;

        //Button Frames
        startButton[1] = ImageHandler.loadImage("/textures/StartButton1.png");
        startButton[0] = ImageHandler.loadImage("/textures/StartButton2.png");

        menuButton[1] = ImageHandler.loadImage("/textures/MenuButton1.png");
        menuButton[0] = ImageHandler.loadImage("/textures/MenuButton2.png");

        backButton[1] = ImageHandler.loadImage("/textures/BackButton1.png");
        backButton[0] = ImageHandler.loadImage("/textures/BackButton2.png");

        battleButton[1] = ImageHandler.loadImage("/textures/BattleButton1.png");
        battleButton[0] = ImageHandler.loadImage("/textures/BattleButton2.png");

        //Player animation frame to crop
        walkingUp[0] = playerSheet.getImage(0, 0, widthPlayerSheet, heightPlayerSheet);
        walkingUp[1] = playerSheet.getImage(widthPlayerSheet, 0, widthPlayerSheet, heightPlayerSheet);
        walkingUp[2] = playerSheet.getImage(widthPlayerSheet * 2, 0, widthPlayerSheet, heightPlayerSheet);

        //batDown[0] = batSheet.getImage(0, 0, batDim, batDim);
        batDown[0] = batSheet.getImage(batDim, 0, batDim, batDim);
        batDown[1] = batSheet.getImage(batDim * 2, 0, batDim, batDim);
        batDown[2] = batSheet.getImage(batDim * 3, 0, batDim, batDim);

        //batUp[0] = batSheet.getImage(0, batDim * 2, batDim, batDim);
        batUp[0] = batSheet.getImage(batDim, batDim * 2, batDim, batDim);
        batUp[1] = batSheet.getImage(batDim * 2, batDim * 2, batDim, batDim);
        batUp[2] = batSheet.getImage(batDim * 3, batDim * 2, batDim, batDim);

        //batRight[0] = batSheet.getImage(0, batDim, batDim, batDim);
        batRight[0] = batSheet.getImage(batDim, batDim, batDim, batDim);
        batRight[1] = batSheet.getImage(batDim * 2, batDim, batDim, batDim);
        batRight[2] = batSheet.getImage(batDim * 3, batDim, batDim, batDim);

        //batLeft[0] = batSheet.getImage(0, batDim * 3, batDim, batDim);
        batLeft[0] = batSheet.getImage(batDim, batDim * 3, batDim, batDim);
        batLeft[1] = batSheet.getImage(batDim * 2, batDim * 3, batDim, batDim);
        batLeft[2] = batSheet.getImage(batDim * 3, batDim * 3, batDim, batDim);

        //NPCs
        villain = villainSheet.getImage(0, 0, 64, 64);
        innkeep = ImageHandler.loadImage("/textures/15.png");

        //Inventory
        inventory = ImageHandler.loadImage("/textures/InventoryScreen.png");

        //Buildings
        inn = ImageHandler.loadImage("/textures/Inn.png");
        innFloor = ImageHandler.loadImage("/textures/InnFloor.png");

        black = sheet1.getImage(0,0, widthSheet1, heightSheet1);
        purple = sheet1.getImage(widthSheet1, 0, widthSheet1, heightSheet1);
        playerUp = ImageHandler.loadImage("/textures/PlayerUp.png");
        playerDown = ImageHandler.loadImage("/textures/PlayerDown.png");
        playerLeft = ImageHandler.loadImage("/textures/PlayerLeft.png");
        playerRight = ImageHandler.loadImage("/textures/PlayerRight.png");

        //Fonts
        titleFont = FontLoader.load("SENG201-Assignment/res/fonts/Symtext.ttf", 70);
        invFont = FontLoader.load("SENG201-Assignment/res/fonts/Symtext.ttf", 36);

    }


}
