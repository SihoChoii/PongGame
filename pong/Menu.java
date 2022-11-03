package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.util.concurrent.TimeUnit;

public class Menu {
    // menu screen

    private Boundary boundary;
    private Button playButton, howToButton, settingButton;
    private RGB rgb = new RGB(1, 1);

    // 0 = None
    // 1 = Play
    // 2 = How
    // 3 = Settings
    private int menuSelection = 0;

    private int debounceTime = 35;
    
    public Menu (Boundary boundary)
    {
        this.boundary = boundary;
        playButton = new Button(50, boundary.getyCenter()-40, 1, "PLAY", rgb);
        howToButton = new Button(50, boundary.getyCenter()+40, 1, "HOW", rgb);
        settingButton = new Button(50, boundary.getyCenter()+120, 1, "SETTING", rgb);
    }

    public int update(boolean up, boolean down, boolean space)
    {
        rgb.rgbPairsUpdate();

        if (down && menuSelection <= 3) {
            menuSelection++;
            try { TimeUnit.MILLISECONDS.sleep(debounceTime); } catch (InterruptedException e) { e.printStackTrace();}
        } else if (up && menuSelection >= 1) {
            menuSelection--;
            try { TimeUnit.MILLISECONDS.sleep(debounceTime); } catch (InterruptedException e) { e.printStackTrace();}
        }

        switch (menuSelection)
        {
            case 1:
                // Play
                playButton.buttonSelect();
                howToButton.buttonDeselect();
                settingButton.buttonDeselect();
                break;
            case 2:
                //How
                howToButton.buttonSelect();
                playButton.buttonDeselect();
                settingButton.buttonDeselect();
                break;
            case 3:
                // Setting
                settingButton.buttonSelect();
                howToButton.buttonDeselect();
                playButton.buttonDeselect();
                break;
            default:
                settingButton.buttonDeselect();
                howToButton.buttonDeselect();
                playButton.buttonDeselect();
                break;
        }

        if(space && menuSelection >= 1)
        {
            System.out.println(menuSelection);
            return menuSelection;
        }
        return 0;
    }

    public void draw(Graphics2D win)
    {
        playButton.draw(win);
        howToButton.draw(win);
        settingButton.draw(win);
    }
}
