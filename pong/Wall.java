package pong;

import java.awt.Color;

import java.awt.Rectangle;

import javax.lang.model.util.ElementScanner14;

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
        if (keyUp && boundary.isOutOfBoundsY(this) != 1) {
            setLocation((int)getX(), (int)getY() - yVelocity);
        } else if (keyUp && boundary.isOutOfBoundsY(this) != -1) {
            setLocation((int)getX(), (int)getY() + yVelocity);
        }
        if (keyDown && boundary.isOutOfBoundsY(this) != -1) {
            setLocation((int)getX(), (int)getY() + yVelocity);
        } else if (keyDown && boundary.isOutOfBoundsY(this) != 1) {
            setLocation((int)getX(), (int)getY() - yVelocity);
        }
    }
}
