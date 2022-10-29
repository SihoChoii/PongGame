package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.Date;


import utilities.GDV5;

public class PongRunner extends GDV5
{
    Boundary boundary = new Boundary(getMaxWindowX(), getMaxWindowY());

    // Game Elements
    Ball ball1 = new Ball(45, boundary);
    Wall wall1 = new Wall(12, 0 + 45, boundary);
    Wall wall2 = new Wall(12, boundary.getMaxWindowX() - 45, boundary);

    public static void main(String[] args)
    {
        PongRunner runner = new PongRunner(); // the parameter is the fps
		runner.start();
    }

    @Override
	public void update() 
	{ 
        ball1.move();
        wall1.move(KeysPressed[KeyEvent.VK_W], KeysPressed[KeyEvent.VK_S]);
        wall2.move(KeysPressed[KeyEvent.VK_UP], KeysPressed[KeyEvent.VK_DOWN]);
    }

    @Override
	public void draw(Graphics2D win) 
	{
        win.setColor(Color.white);
        win.drawOval((int)ball1.getX(), (int)ball1.getY(), (int)ball1.getWidth(), (int)ball1.getHeight());
        win.draw(ball1);
        win.draw(wall1);
        win.draw(wall2);
    }
}