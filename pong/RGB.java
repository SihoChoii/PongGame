package pong;

import java.awt.Color;

public class RGB
{
    // generating a number sweep betwen 0 and 255
    private int r = 0;
    private int g = 0;
    private int b = 0;
    private int sweep = 0;
    private int sweepDirection = 1;
    private int sweepSpeed = 1;
    private int sweepMax = 255;
    private int sweepMin = 0;

    public RGB(int sweepSpeed, int sweepDirection)
    {
        this.sweepSpeed = sweepSpeed;
        this.sweepDirection = sweepDirection;
    }

    public void update()
    {
        sweep += sweepDirection * sweepSpeed;
        if (sweep > sweepMax) {
            sweep = sweepMax;
            sweepDirection *= -1;
        } else if (sweep < sweepMin) {
            sweep = sweepMin;
            sweepDirection *= -1;
        }
    }

    public int getSweep()
    {
        return sweep;
    }

}