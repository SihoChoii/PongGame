package pong;

import java.util.concurrent.TimeUnit;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;


public class StartingScreen 
{

    private int timer = 0;
    private Boundary boundary;
    private int fps;
    private boolean signal = false;
    private boolean selfDesotry = false;
    private boolean sfxTracker = false;
    private SFX sfx = new SFX();

    public StartingScreen(int fps, Boundary boundary)
    {
        // starting screen
        this.boundary = boundary;
        this.fps = fps;
    }

    public boolean timerUpdate()
    {
        timer++;
        return signal;
    }

    public boolean drawCountDown(Graphics2D paintbrush)
    {
        if (!selfDesotry)
        {
            paintbrush.setColor(Color.white);
            paintbrush.setFont(new Font("Arial", Font.BOLD, 50));
            paintbrush.drawString("Starting in", boundary.getxCenter()-100, boundary.getyCenter() - 50);

            // Uninterupted Count Down
            if (timer < fps) {
                paintbrush.drawString("3", boundary.getxCenter(), boundary.getyCenter() + 50);
            } else if (timer>=fps && timer<fps*2) { 
                paintbrush.drawString("2", boundary.getxCenter(), boundary.getyCenter() + 50);
            } else if (timer>=fps*2 && timer<fps*3) {
                paintbrush.drawString("1", boundary.getxCenter(), boundary.getyCenter() + 50);
            } else if (timer>=fps*3 && timer<fps*4) {
                paintbrush.drawString("GO!", boundary.getxCenter()-25, boundary.getyCenter() + 50);
                if (!sfxTracker)
                {
                    sfx.fill1();
                    sfxTracker = true;
                }
            } else if (timer>=fps*4) {
                resetTimer();
                signal = true;
                selfDesotry = true;
            }
        }
        return false;
    }

    public void resetTimer()
    {
        timer = 0;
        signal = false;
    }
}
