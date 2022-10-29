package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.Date;


import utilities.GDV5;

public class PongRunner extends GDV5
{
    public static void main(String[] args)
    {
        PongRunner runner = new PongRunner(); // the parameter is the fps
		runner.start();
    }

    @Override
	public void update() 
	{ 
        GDV5.getMaxWindowX();
        GDV5.getMaxWindowY();
    }

    @Override
	public void draw(Graphics2D win) 
	{
    }
}