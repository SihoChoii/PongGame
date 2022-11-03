package pong;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

// score keeping class
public class Score 
{
    private int score1 = 0;
    private int score2 = 0;
    private Boundary boundary;

    public Score(Boundary boundary)
    {
        this.boundary = boundary;
    }

    // Score drawer
    public void drawScore(Graphics2D paintbrush)
    {
        paintbrush.setColor(Color.white);
        paintbrush.setFont(new Font("Arial", Font.BOLD, 50));
        paintbrush.drawString("Player 1: " + score1, 100, 40);
        paintbrush.drawString("Player 2: " + score2, boundary.getxCenter()-150, 40);
    }

    public void addScore1()
    {
        score1++;
    }

    public void addScore2()
    {
        score2++;
    }

    public int getScore1()
    {
        return score1;
    }

    public int getScore2()
    {
        return score2;
    }

    public void resetScores()
    {
        score1 = 0;
        score2 = 0;
    }
}