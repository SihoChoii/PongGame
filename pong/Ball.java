package pong;

import java.awt.Rectangle;

public class Ball extends Rectangle 
{
    private int xVelocity = 6;
    private int yVelocity = 6;
    private Boundary boundary;

	public Ball(int size, Boundary boundary)
	{
		super(boundary.getxCenter(), boundary.getyCenter(), size, size);
        this.boundary = boundary;
	}

    public boolean bounceLogic(Wall wall1, Wall wall2)
    {
        if (boundary.isOutOfBoundX(this)) {
            xVelocity *= -1;
            return true;
        }
        if (boundary.isOutOfBoundY(this))
        {
            yVelocity *= -1;
            return true;
        }
        if (boundary.isTouchingWall(this, wall1) || boundary.isTouchingWall(this, wall2)) {
            xVelocity *= -1;
            return true;
        }
        return false;
    }
  
    public void move(Wall wall1, Wall wall2)
    {
        if (bounceLogic(wall1, wall2)) 
        {
            // try {AudioPlayer soundFx = new AudioPlayer("blip1.wav"); soundFx.playFor(1);} catch (Exception ex){ex.printStackTrace();}
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
