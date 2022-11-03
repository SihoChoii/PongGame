package pong;

import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Ball extends Rectangle 
{
    // 9
    private int xVelocity = 9;
    private int yVelocity = 9;
    private int xVelocityO = 9;
    private int yVelocityO = 9;
    private Boundary boundary;
    private SFX sfx = new SFX();
    private int flipperVar = 1;

	public Ball(int size, int xPos, int yPosm, Boundary boundary)
	{
		super(boundary.getxCenter(), boundary.getyCenter(), size, size);
        this.boundary = boundary;
	}

    public void changeSpeed(int xSpeed)
    {
        xVelocity = xSpeed;
    }

    public int getSpeed()
    {
        return xVelocity;
    }

    public boolean bounceLogic(Wall wall1, Wall wall2)
    {
        if (boundary.isOutOfBoundX(this)%2==0) {
            xVelocity *= -1;
            return true;
        }
        if (boundary.isOutOfBoundY(this)) {
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
            sfx.blip1();
        }
        setLocation((int)getX() + xVelocity, (int)getY() + yVelocity);
    }

    // SFX


    // Getters/Setters
    public void setxVelocity(int xVelocity) 
    {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) 
    {
        this.yVelocity = yVelocity;
    }

    public void reset()
    {
        setLocation(boundary.getxCenter(), boundary.getyCenter());
        flipperVar *= -1;
        setxVelocity(xVelocityO*flipperVar);
        setyVelocity(yVelocityO);
    }
}
