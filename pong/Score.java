package pong;

// score keeping class
public class Score 
{
    private int score1 = 0;
    private int score2 = 0;

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