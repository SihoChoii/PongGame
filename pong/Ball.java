package pong;

import java.awt.Rectangle;
import pong.Boundary;

public class Ball extends Rectangle 
{
    private int xVelocity, yVelocity;
    private Boundary boundary;

	public Ball(int size, Boundary boundary)
	{
		super(boundary.getxCenter(), boundary.getyCenter(), size, size);
        this.boundary = boundary;
	}

    public void move()
    {
        if (boundary.isOutOfBoundX(this)) {
            xVelocity *= -1;
        }
        if (boundary.isOutOfBoundY(this))
        {
            yVelocity *= -1;
        }
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
