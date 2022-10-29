package pong;

import java.awt.Rectangle;
import pong.Boundary;

public class Wall extends Rectangle 
{
    private int yVelocity;

	public Wall(int size, int x, int y)
	{
		super(x, y, size, size*9);
	}

    public void move()
    {
        setLocation((int)getX(), (int)getY() + yVelocity);
    }

    public void setyVelocity(int yVelocity) 
    {
        this.yVelocity = yVelocity;
    }

    public void bounce() {
        if (Boundary.isOutOfBounds(this)) {
            yVelocity *= -1;
        }
    }

}
