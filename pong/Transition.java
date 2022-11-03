package pong;

import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

public class Transition extends Rectangle{

    private Boundary boundary;
    
    public Transition(Boundary boundary)
	{
		super(-1-boundary.getMaxWindowX(), 0, boundary.getMaxWindowX(), boundary.getMaxWindowY());
        this.boundary = boundary;
	}

    public boolean update(boolean signal)
    {
        if (signal)
        {
            if (getX() <= boundary.getMaxWindowX()*2)
            {
                System.out.println(getX());
                setLocation((int)getX()+50, (int)getY());
            } 
            else if (getX() >= boundary.getMaxWindowX()*2)
            {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics2D win)
    {
        win.setColor(Color.white);
        win.fill(this);
        win.draw(this);
    }

}
