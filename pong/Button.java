package pong;

import java.awt.Color;

import java.awt.Rectangle;

public class Button extends Rectangle 
{

    private Boundary boundary;
    private boolean state = false;
    private Color color = Color.white;

    public Button(int x, int y, int width, int height)
	{
		super(x, y, width, height);
	}

    public void buttonPress()
    {
        state = true;
    }
}
