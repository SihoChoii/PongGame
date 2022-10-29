package pong;

import java.awt.Rectangle;

public class Ball extends Rectangle 
{
    private int xVelocity, yVelocity;

	public Ball(int size, int x, int y)
	{
		super(x, y, size, size);
	}

    public void move()
    {
        setLocation((int)getX() + xVelocity, (int)getY() + yVelocity);
    }

    public void setxVelocity(int xVelocity) 
    {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) 
    {
        this.yVelocity = yVelocity;
    }
}
