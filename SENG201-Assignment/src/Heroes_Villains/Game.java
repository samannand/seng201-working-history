package Heroes_Villains;

import Heroes_Villains.Listener.KeyboardListener;
import Heroes_Villains.Listener.MouseListener;
import Heroes_Villains.States.*;
import Heroes_Villains.display.Display;
import Heroes_Villains.entities.Player;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.minigames.MiniGameHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{ //Runnable allows the class to use threads

    public Display getDisplay() {
        return display;
    }

    private Display display;
    private Thread gameThread;
    private String title;
    private boolean running = false;

    //State Variables
    public State gameState, menuState, pauseState, battleState, controlsState, setupState, adminState;
    private StateHandler stateHandler = new StateHandler();

    //Keyboard Listener
    private KeyboardListener keyboardListener;
    private MouseListener mouseListener;

    //Mini game handler
    public MiniGameHandler miniGameHandler;

    public int width, height;

    public Player player;

    //Graphics variables
    private BufferStrategy buffer;
    public Graphics graphics;

    //Main Game Settings
    public int noOfCities;
    public int noOfHeros;
    
    public double delta;


    private void update(){
        keyboardListener.update();
        if(stateHandler.state != null) {
            stateHandler.state.update();
        }
        if(keyboardListener.keyJustPressed(KeyEvent.VK_CONTROL)) {
            if(stateHandler.getState() instanceof AdminState) {
                stateHandler.setState(stateHandler.getLastState());
            } else {
                stateHandler.setState(adminState);
            }
        }
    }

    private void render(){
        //Creating the buffer for the output frames
        buffer = display.getCanvas().getBufferStrategy();
        if (buffer == null){ //If not buffer exists create one
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = buffer.getDrawGraphics();
        //Graphics
        graphics.clearRect(0, 0, width, height);
        if(stateHandler.state != null) {
            stateHandler.state.render(graphics);
        }


        //Graphics end
        buffer.show();
        graphics.dispose();

    }

    private void init(){ //Function run by run()
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyboardListener);
        display.getFrame().addMouseListener(mouseListener);
        display.getFrame().addMouseMotionListener(mouseListener);
        display.getCanvas().addMouseListener(mouseListener);
        display.getCanvas().addMouseMotionListener(mouseListener);
        Assets.init();
        miniGameHandler = new MiniGameHandler(this);
        miniGameHandler.init();
        //gameState = new GameState(this);
        //player = ((GameState) gameState).player;
        menuState = new MenuState(this);
        pauseState = new PauseState(this);
        battleState = new BattleState(this);
        controlsState = new ControlsState(this);
        setupState = new SetupState(this);
        adminState = new AdminState(this);
        stateHandler.setState(menuState);
    }


    @Override
    public void run() { //Following function is run when the thread is started
        init();

        long lastTime = System.nanoTime();
        final int  FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / FPS ;
        int lastFpsTime = 0;
        int fps = 0;

        while(running){
            long timeNow = System.nanoTime();
            long updateLength = timeNow - lastTime;
            lastTime = timeNow;
            
            delta = updateLength / ((double)OPTIMAL_TIME);
            
            lastFpsTime += updateLength;
            fps ++;
            
            if (lastFpsTime >= 1000000000) {
            	//System.out.println("(FPS: "+fps+")");
            	//System.out.println(delta);
            	lastFpsTime = 0;
            	fps = 0;
            }
            
            //Running game updates
            update();
            render();
            try {
            	
            	if ((lastTime - System.nanoTime() + OPTIMAL_TIME) >= 0) {

            		Thread.sleep((lastTime - System.nanoTime() + OPTIMAL_TIME)/1000000);
            	
            	}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        stop();

    }

    public synchronized void start(){
        if (running){
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();


    }

    public synchronized void stop(){
        if (!running){
            return;
        }
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyboardListener = new KeyboardListener();
        mouseListener = new MouseListener();
        }

    public MouseListener getMouseListener() {
        return mouseListener;
    }

    public KeyboardListener getKeyboardListener() {
        return keyboardListener;
    }

    public StateHandler getStateHandler() {
        return stateHandler;
    }

    public State getGameState() {
        return gameState;
    }

    public State getMenuState() {
        return menuState;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public State getPauseState() {
        return pauseState;
    }

    public State getBattleState() {
        return battleState;
    }

    public State getControlsState() { return controlsState; }

    public State getSetupState() { return setupState; }

    //Main Game settings Getters and Setters

    public int getNoOfCities() {
        return noOfCities;
    }

    public void setNoOfCities(int noOfCities) {
        this.noOfCities = noOfCities;
    }

    public int getNoOfHeros() {
        return noOfHeros;
    }

    public void setNoOfHeros(int noOfHeros) {
        this.noOfHeros = noOfHeros;
    }

    public Player getPlayer() {
        return player;
    }

}
