package pong;

import java.awt.Rectangle;

import javax.lang.model.util.ElementScanner14;

public class Wall extends Rectangle 
{
    private int yVelocity = 8;
    private int npcYVelocity = 6;
    private Boundary boundary;
    private Ball ball1;

	public Wall(int size, int x, Boundary boundary)
	{
		super(x, boundary.getyCenter(), size, size*9);
        this.boundary = boundary;
	}

    public Wall(int size, int x, Boundary boundary, Ball ball1)
	{
		super(x, boundary.getyCenter(), size, size*9);
        this.boundary = boundary;
        this.ball1 = ball1;
	}

    public void move(boolean keyUp, boolean keyDown)
    {
        if (keyUp && boundary.isOutOfBoundsY(this) != -1) {
            setLocation((int)getX(), (int)getY() - yVelocity);
        } else if (keyUp && boundary.isOutOfBoundsY(this) != 1) {
            setLocation((int)getX(), (int)getY() + yVelocity);
        }
        if (keyDown && boundary.isOutOfBoundsY(this) != 1) {
            setLocation((int)getX(), (int)getY() + yVelocity);
        } else if (keyDown && boundary.isOutOfBoundsY(this) != -1) {
            setLocation((int)getX(), (int)getY() - yVelocity);
        }
    }

    public void moveNPC()
    {
        if (boundary.isHigher(ball1, this))
        {
            setLocation((int)getX(), (int)getY() - npcYVelocity);
        } else setLocation((int)getX(), (int)getY() + npcYVelocity);
    }
}
