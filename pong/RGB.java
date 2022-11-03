package pong;

import java.awt.Color;

public class RGB
{
    // generating a number sweep betwen 0 and 255
    private int r = 255;
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

    public void rgbSweepUpdate()
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

    public void rgbPairsUpdate()
    {
        if (r > 0 && b == 0)
        {
            r--;
            g++;
        }
        if (g > 0 && r == 0)
        {
            g--;
            b++;
        }
        if (b > 0 && g == 0)
        {
            b--;
            r++;
        }
    }


    // Getters
    public int getSweep()
    {
        return sweep;
    }

    public int getR()
    {
        return r;
    }

    public int getG()
    {
        return g;
    }

    public int getB()
    {
        return b;
    }

    // Setters
    public void setSweep(int sweep)
    {
        this.sweep = sweep;
    }

    public void setR(int r)
    {
        this.r = r;
    }

    public void setG(int g)
    {
        this.g = g;
    }

    public void setB(int b)
    {
        this.b = b;
    }
}