package pong;

import java.awt.Color;
import java.awt.Graphics2D;

public class GameRunning
{

    private Ball ball1;
    private Wall wall1, wall2;
    private Boundary boundary;
    private Score score;

    public GameRunning(int ballSize, int wallSize, int wallPosition, int wall1Speed, int wall2Speed, Boundary boundary)
    {
        // game running

        this.boundary = boundary;
        this.ball1 = new Ball(ballSize, boundary.getxCenter(), boundary.getyCenter(), boundary);
        this.wall1 = new Wall(wallSize, wallPosition, wall1Speed, boundary);
        this.wall2 = new Wall(wallSize, boundary.getMaxWindowX()-wallPosition, wall2Speed, boundary);
        this.score = new Score(boundary);
    }

    public void update(boolean isPlayer1Up, boolean isPlayer1Down, boolean isPlayer2Up, boolean isPlayer2Down)
    {
        // update game
        ball1.move(wall1, wall2);
        wall1.move(isPlayer1Up, isPlayer1Down);
        wall2.move(isPlayer2Up, isPlayer2Down);

        smashBall(isPlayer1Up, isPlayer1Down, wall1);
        smashBall(isPlayer1Up, isPlayer1Down, wall2);

        if (boundary.isOutOfBoundX(ball1)==4) 
        {
            score.addScore1();
            ball1.reset();
        }
        else if (boundary.isOutOfBoundX(ball1)==2) 
        {
            score.addScore2();
            ball1.reset();
        }
    }

    public boolean update(boolean isPlayer1Up, boolean isPlayer1Down)
    {
        // update game
        ball1.move(wall1, wall2);
        wall1.move(isPlayer1Up, isPlayer1Down);
        wall2.moveNPC(ball1);

        smashBall(isPlayer1Up, isPlayer1Down, wall1);

        if (boundary.isOutOfBoundX(ball1)==2) 
        {
            score.addScore1();
            ball1.reset();
            return true;
        }
        else if (boundary.isOutOfBoundX(ball1)==4) 
        {
            score.addScore2();
            ball1.reset();
            return true;
        }
        return false;
    }

    public void smashBall(boolean isPlayerUp, boolean isPlayerDown, Wall wall)
    {
        if (boundary.isTouchingWall(ball1, wall))
        {
            if (isPlayerUp && ball1.getSpeed() < 0)
            {
                ball1.changeSpeed(ball1.getSpeed()-1);
            }
            if (isPlayerDown && ball1.getSpeed() > 0)
            {
                ball1.changeSpeed(ball1.getSpeed()+1);
            }
        }
    }

    // Draw game
    public void draw(Graphics2D win)
    {
        win.setColor(Color.white);
        // Ball
        win.drawOval((int)ball1.getX(), (int)ball1.getY(), (int)ball1.getWidth(), (int)ball1.getHeight());
        // win.draw(ball1);
        // Walls
        win.draw(wall1);
        win.draw(wall2);
        // Score
        score.drawScore(win);
    }
}
