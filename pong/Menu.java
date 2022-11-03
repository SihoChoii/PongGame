package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.util.concurrent.TimeUnit;

public class Menu {
    // menu screen

    // Mini Game
    private Ball ball;
    private Wall wall1, wall2;

    private Boundary boundary;
    private Button playButton, howToButton, settingButton;
    private RGB rgb = new RGB(1, 1);
    private SFX sfx = new SFX();
    private SFX sfx2 = new SFX();

    private boolean sfxTracker = false;
    private int prevNum = 0;

    // 0 = None
    // 1 = MULTI
    // 2 = SINGLE
    // 3 = HOW
    private int menuSelection = 1;

    private int debounceTime = 50;
    
    public Menu (Boundary boundary)
    {
        this.boundary = boundary;
        this.playButton = new Button(50, boundary.getyCenter()-50, 2, "MULTI", rgb);
        this.howToButton = new Button(50, boundary.getyCenter()+30, 2, "SINGLE", rgb);
        this.settingButton = new Button(50, boundary.getyCenter()+110, 2, "HOW", rgb);
        this.ball = new Ball(20, boundary.getMaxWindowX()-50, boundary.getyCenter(), boundary);
        this.wall1 = new Wall(15, 400, 12, boundary);
        this.wall2 = new Wall(15, boundary.getMaxWindowX()-25, 12, boundary);
    }

    public void menuSelector()
    {
        switch (menuSelection)
        {
            case 1:
                // MULTI
                playButton.buttonSelect();
                howToButton.buttonDeselect();
                settingButton.buttonDeselect();
                break;
            case 2:
                // SINGLE
                howToButton.buttonSelect();
                playButton.buttonDeselect();
                settingButton.buttonDeselect();
                break;
            case 3:
                // HOW
                settingButton.buttonSelect();
                howToButton.buttonDeselect();
                playButton.buttonDeselect();
                break;
            case 0:
                settingButton.buttonDeselect();
                howToButton.buttonDeselect();
                playButton.buttonDeselect();
                break;
        }
    }

    // Two autonomous paddles that move on their own
    // A ball object
    public void miniGameUpdate()
    {
        ball.move(wall1, wall2);
        if (ball.getX() > 400 && ball.getX() < boundary.getMaxWindowX()-300)
        {
            wall1.moveNPC(ball);
        }
        if (ball.getX() < boundary.getMaxWindowX() && ball.getX() > boundary.getMaxWindowX()-500)
        {
            wall2.moveNPC(ball);
        }
    }

    public void menuSfx()
    {
        if (!sfxTracker)
        {
            System.out.println("SFX");
            sfxTracker = true;
            prevNum = menuSelection;
        } else if (sfxTracker && menuSelection != prevNum)
        {
            System.out.println("SFX");
            sfxTracker = false;
            prevNum = menuSelection;
        }
    }

    public int update(boolean up, boolean down, boolean space)
    {
        rgb.rgbPairsUpdate();
        miniGameUpdate();
        if (down && menuSelection <= 3) {
            menuSelection++;
            try { TimeUnit.MILLISECONDS.sleep(debounceTime); } catch (InterruptedException e) { e.printStackTrace();}
            menuSfx();
        } else if (up && menuSelection >= 1) {
            menuSelection--;
            menuSfx();
            try { TimeUnit.MILLISECONDS.sleep(debounceTime); } catch (InterruptedException e) { e.printStackTrace();}
        } else if (menuSelection <= 0) {
            menuSelection = 1;
        }

        menuSelector();

        if(space && (menuSelection >= 1 && menuSelection <= 3))
        {
            return menuSelection;
        }
        return 0;
    }

    public void draw(Graphics2D win)
    {
        playButton.draw(win);
        howToButton.draw(win);
        settingButton.draw(win);
        win.setColor(new Color(rgb.getR(), rgb.getG(), rgb.getB()));
        win.drawOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
        win.setColor(Color.white);
        win.draw(wall1);
        win.draw(wall2);
    }
}
