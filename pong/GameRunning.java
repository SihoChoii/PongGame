package pong;

import java.awt.Color;
import java.awt.Graphics2D;

public class GameRunning
{

    private Ball ball1;
    private Wall wall1, wall2;

    public GameRunning(Ball ball1, Wall wall1, Wall wall2)
    {
        // game running
        this.ball1 = ball1;
        this.wall1 = wall1;
        this.wall2 = wall2;
    }

    public void update(boolean isPlayer1Up, boolean isPlayer1Down, boolean isPlayer2Up, boolean isPlayer2Down)
    {
        // update game
        ball1.move(wall1, wall2);
        wall1.move(isPlayer1Up, isPlayer1Down);
        wall2.move(isPlayer2Up, isPlayer2Down);
    }

    public void update(boolean isPlayer1Up, boolean isPlayer1Down)
    {
        // update game
        ball1.move(wall1, wall2);
        wall1.move(isPlayer1Up, isPlayer1Down);
        wall2.moveNPC();
    }

    // Draw game
    public void draw(Graphics2D win)
    {
        win.setColor(Color.white);
        // Ball
        win.drawOval((int)ball1.getX(), (int)ball1.getY(), (int)ball1.getWidth(), (int)ball1.getHeight());
        win.draw(ball1);
        // Walls
        win.draw(wall1);
        win.draw(wall2);
    }
}
