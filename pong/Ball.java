package pong;

import java.awt.Rectangle;

public class Ball extends Rectangle 
{
    private int xVelocity = 5;
    private int yVelocity = 5;
    private Boundary boundary;

	public Ball(int size, Boundary boundary)
	{
		super(boundary.getxCenter(), boundary.getyCenter(), size, size);
        this.boundary = boundary;
	}

    public void move(Wall wall1, Wall wall2)
    {
        if (boundary.isOutOfBoundX(this)) {
            xVelocity *= -1;
        }
        if (boundary.isOutOfBoundY(this))
        {
            yVelocity *= -1;
        }
        if (boundary.isTouchingWall(this, wall1) || boundary.isTouchingWall(this, wall2)) {
            xVelocity *= -1;
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
