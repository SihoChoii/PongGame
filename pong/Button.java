package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;

import java.awt.Rectangle;

public class Button extends Rectangle 
{
    // Classes
    private Color buttonColor = Color.white;
    private RGB rgb;

    // Default State
    private int state = 0;
    private String buttonText = "NONE";
    private int buttonX, buttonY;
    private static int buttonWidth = 250;
    private static int buttonHeight = 10;
    private static int fontSize = 40;
    private int sizeMulti = 1;

    // Effected State
    private int buttonWidthM, buttonHeightM;
    private int fontSizeM;

    public Button(int offsetX, int offsetY, int sizeMulti, String buttonText, RGB rgb)
	{
		super(offsetX, offsetY, buttonWidth*sizeMulti, buttonHeight*sizeMulti);
        this.buttonText = buttonText;
        this.rgb = rgb;
        this.buttonX = offsetX;
        this.buttonY = offsetY;
        this.sizeMulti = sizeMulti;

        this.buttonWidthM = buttonWidth*sizeMulti;
        this.buttonHeightM = buttonHeight*sizeMulti;
        this.fontSizeM = fontSize*sizeMulti;
	}

    public void draw(Graphics2D win)
    {
        win.setColor(Color.white);
        win.setFont(new Font("Arial", Font.BOLD, fontSizeM));
        win.drawString(buttonText, buttonX-3, buttonY);

        if (state==0) {
            win.setColor(new Color(rgb.getR(), rgb.getG(), rgb.getB()));
        } else if (state==1) {
            win.setColor(Color.white);
        } else {
            win.setColor(Color.gray);
        }

        win.drawString(buttonText, buttonX, buttonY);
        win.draw(this);
    }

    public void buttonPress()
    {
        state = 2;
    }

    public void buttonSelect()
    {
        state = 1;
    }

    public void buttonDeselect()
    {
        state = 0;
    }
}
