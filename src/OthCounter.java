import org.lwjgl.opengl.Display;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.ResourceLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.glColor3d;

/**
 * @file 	Counter.java
 * @author 	Cameron Steer
 * @date	January 28, 2014, Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @brief	Counter holds data and methods for the othello counters
 * @details
 */
public class OthCounter extends AbstractCounter {

    private Audio wavEffect;

    public OthCounter(int player) {
        super(X, Y, WIDTH, HEIGHT, RADIUS, player);
        setSoundFiles();
    }

    private void setSoundFiles(){
        try {
            wavEffect = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/placeOthCounter.wav"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
            Display.destroy();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
            Display.destroy();
            System.exit(1);
        }
    }

    @Override
    public void setColor() {
        if (getPlayer() == PLAYER_1) {
            glColor3d(0, 0, 0);
        } else if (getPlayer() == PLAYER_2) {
            glColor3d(1, 1, 1);
        }
    }

    @Override
    public void playSound() {
        wavEffect.playAsSoundEffect(1.0f, 1.0f, false);
        SoundStore.get().poll(0);
    }


    private static final float RADIUS = 10;
    private static final double X = 115;
    private static final double Y = 20;
    private static final double WIDTH = 10;
    private static final double HEIGHT = 10;
    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;


}
