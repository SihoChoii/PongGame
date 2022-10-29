package pong;

import java.awt.Rectangle;

import javax.lang.model.util.ElementScanner14;

import pong.Boundary;

public class Wall extends Rectangle 
{
    private int yVelocity = 5;
    private Boundary boundary;

	public Wall(int size, int x, Boundary boundary)
	{
		super(x, boundary.getyCenter(), size, size*9);
        this.boundary = boundary;
	}

    public void move(boolean keyUp, boolean keyDown)
    {
        if (boundary.isOutOfBoundsY(this) == 0)
        {
            if (keyUp) setLocation((int)getX(), (int)getY() + yVelocity);
            if (keyDown) setLocation((int)getX(), (int)getY() - yVelocity);
        } else if (boundary.isOutOfBoundsY(this) == 1) {
            if (keyDown) setLocation((int)getX(), (int)getY() - yVelocity);
        } else if (boundary.isOutOfBoundsY(this) == 2) {
            if (keyUp) setLocation((int)getX(), (int)getY() + yVelocity);
        }
    }
}
