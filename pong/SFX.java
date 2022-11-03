package pong;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SFX {

    public void blip1()
    {
        try 
        {
            File sound = new File("C:\\Users\\sihoc\\Documents\\GitHub\\PongGame\\sfx\\blip1.wav");
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();
        }
        catch (Exception e){}
    }

    public void fill1()
    {
        try 
        {
            File sound = new File("C:\\Users\\sihoc\\Documents\\GitHub\\PongGame\\sfx\\fill1.wav");
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();
        }
        catch (Exception e){}
    }

    public void perc1()
    {
        try 
        {
            File sound = new File("C:\\Users\\sihoc\\Documents\\GitHub\\PongGame\\sfx\\perc1.wav");
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();
        }
        catch (Exception e){}
    }
}
