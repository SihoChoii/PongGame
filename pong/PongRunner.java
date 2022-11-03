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

    // Scenes
    private Boundary boundary = new Boundary(getMaxWindowX(), getMaxWindowY());
    private StartingScreen startingScreen = new StartingScreen(fps, boundary);
    private Menu menu = new Menu(boundary);

    // Game Elements
    private Ball ball1 = new Ball(45, boundary);
    private Wall wall1 = new Wall(12, 0 + 45, boundary);
    private Wall wall2 = new Wall(12, boundary.getMaxWindowX() - 45, boundary);

    // Game Screens
    // 0 = Menu
    // 1 = Starting Screen
    // 2 = Game Instance 1 Running
    // 3 = Game Instance 2 Running
    // 4 = Game Winner Screen
    // 5 = Game Selection Screen
    // 6 = Pause Screen
    // 7 = How To Play Screen
    // 8 = Settings Screen
    private int gameState = 0;

    // Create these in menu screen
    private GameRunning gameInstance1 = new GameRunning(ball1, wall1, wall2, boundary);
    private GameRunning gameInstance2 = new GameRunning(ball1, wall1, wall2, boundary);
    //KeysPressed[KeyEvent.VK_DOWN]

    public static void main(String[] args)
    {
        PongRunner runner = new PongRunner(); // the parameter is the fps
		runner.start();
    }

    @Override
	public void update() 
	{   
        switch (gameState)
        {
            case 0:
                // Menu
                gameState = menu.update(KeysPressed[KeyEvent.VK_UP], KeysPressed[KeyEvent.VK_DOWN],  KeysPressed[KeyEvent.VK_SPACE]);
                break;
            case 1:
                // Starting Screen
                startingScreen.timerUpdate();
                break;
            case 2:
                // Game Instance 1 Running
                gameInstance1.update(
                    KeysPressed[KeyEvent.VK_W], KeysPressed[KeyEvent.VK_S], // Player 1 Controls
                    KeysPressed[KeyEvent.VK_UP], KeysPressed[KeyEvent.VK_DOWN]); // Player 2 Controls
                break;
            case 3:
                // Game Instance 2 Running
                gameInstance2.update(
                    KeysPressed[KeyEvent.VK_W], KeysPressed[KeyEvent.VK_S]); // Player 1 Controls
            case 4:
                // Winner Screen
                break;
            default:
                // System.out.println("Default case reached");
                break;
        }
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
                // Starting Screen
                if(startingScreen.drawCountDown(win)) gameState = 3;
                break;
            case 2:
                // Game Instance 1 Running
                gameInstance1.draw(win);
                break;
            case 3:
                // Game Instance 2 Running
                gameInstance2.draw(win);
                break;
            case 4:
                // Winner Screen
                break;
        }
        // win.setColor(Color.white);
        // win.drawOval((int)ball1.getX(), (int)ball1.getY(), (int)ball1.getWidth(), (int)ball1.getHeight());
        // win.draw(ball1);
        // win.draw(wall1);
        // win.draw(wall2);
    }
}