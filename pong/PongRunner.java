package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.Date;


import utilities.GDV5;

public class PongRunner extends GDV5
{
    private static int fps = 60;
    private boolean signalSwitch = false;

    // Scenes
    private Boundary boundary = new Boundary(getMaxWindowX(), getMaxWindowY());
    private StartingScreen startingScreen = new StartingScreen(fps, boundary);
    private Menu menu = new Menu(boundary);
    private Transition transition = new Transition(boundary);

    // Game Screens
    // 0 = Menu
    // 1 = Game Instance 1 Starting Screen
    // 2 = Game Instance 2 Running Startinc Screen
    // 3 = Game Instance 1
    // 4 = Game Instance 2
    // 5 = Game Selection Screen
    // 6 = Pause Screen
    // 7 = How To Play Screen
    // 8 = Settings Screen
    private int gameState = 0;

    // Create these in menu screen
    private GameRunning gameInstance1 = new GameRunning(45, 12, 45, 8, 8, boundary);
    private GameRunning gameInstance2 = new GameRunning(45, 12, 45, 8, 6, boundary);
    //KeysPressed[KeyEvent.VK_DOWN]

    void updateMethod()
    {
        switch (gameState)
        {
            case 0:
                // Menu
                gameState = menu.update(KeysPressed[KeyEvent.VK_UP], KeysPressed[KeyEvent.VK_DOWN],  KeysPressed[KeyEvent.VK_SPACE]);
                break;
            case 1:
                // Starting Screen Game Instance 1
                if (startingScreen.timerUpdate() || signalSwitch)
                {
                    signalSwitch = true;
                    if (transition.update(signalSwitch))
                    {
                        signalSwitch = false;
                        gameState = 3;
                    }
                }
                break;
            case 2:
                // Starting Screen Game Instance 2
                if (startingScreen.timerUpdate() || signalSwitch)
                {
                    signalSwitch = true;
                    if (transition.update(signalSwitch))
                    {
                        signalSwitch = false;
                        gameState = 4;
                    }
                }
                break;
            case 3:
                // Game Instance 1 Running
                gameInstance1.update(
                    KeysPressed[KeyEvent.VK_W], KeysPressed[KeyEvent.VK_S], // Player 1 Controls
                    KeysPressed[KeyEvent.VK_UP], KeysPressed[KeyEvent.VK_DOWN]); // Player 2 Controls
                break;
            case 4:
                // Game Instance 2 Running
                transition.update(gameInstance2.update(
                    KeysPressed[KeyEvent.VK_W], KeysPressed[KeyEvent.VK_S])); // Player 1 Controls
            default:
                // System.out.println("Default case reached");
                break;
        }
    }

    public static void main(String[] args)
    {
        PongRunner runner = new PongRunner(); // the parameter is the fps
		runner.start();
    }

    @Override
	public void update() 
	{   
        updateMethod();
    }

    @Override
	public void draw(Graphics2D win) 
	{
        switch (gameState)
        {
            case 0:
                // Menu
                menu.draw(win);
                break;
            case 1:
                // Starting Screen Game Instance 1
                startingScreen.drawCountDown(win);
                // gameState = 3;
                break;
            case 2:
                // Starting SCreen Game Instance 2
                startingScreen.drawCountDown(win);
                break;
            case 3:
                // Game Instance 1 Running
                gameInstance1.draw(win);
                break;
            case 4:
                // Game Instance 2 Running
                gameInstance2.draw(win);
                break;
        }
        transition.draw(win);
        // win.setColor(Color.white);
        // win.drawOval((int)ball1.getX(), (int)ball1.getY(), (int)ball1.getWidth(), (int)ball1.getHeight());
        // win.draw(ball1);
        // win.draw(wall1);
        // win.draw(wall2);
    }
}