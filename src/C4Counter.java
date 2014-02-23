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
 * @date	January 28, 2014
 * @brief	Counter holds data and methods for the connect 4 counters
 * @details
 */
public class C4Counter extends AbstractCounter {

    private Audio wavEffect;
    private Audio m_NegSound;

    public C4Counter() {
        super(X, Y, WIDTH, HEIGHT, RADIUS, PLAYER);
        setSoundFiles();
    }

    private void setSoundFiles(){
        try {
            wavEffect = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/coin-drop-4.wav"));
            m_NegSound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/negative.wav"));
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

    public void playNegSound(){
        m_NegSound.playAsSoundEffect(1.0f, 1.0f, false);
        SoundStore.get().poll(0);
    }

    @Override
    public void setColor() {
        if (getPlayer() == PLAYER_1) {
            glColor3d(1, 0, 0);
        } else if (getPlayer() == PLAYER_2) {
            glColor3d(0, PLAYER2_COLOR, 0);
        }
    }

    /**
     * Up date the counters delta to move it on the screen.
     *
     * @param delta
     * @return void
     */
    public void dropCounter(int delta){
        update(delta);
    }

    public void playSound(){
        wavEffect.playAsSoundEffect(1.0f, 1.0f, false);
        SoundStore.get().poll(0);
    }

    private static final int PLAYER = 1;
    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;
    private static final float RADIUS = 10;
    private static final double X = 115;
    private static final double PLAYER2_COLOR = 1.5;
    private static final double Y = 20;
    private static final double WIDTH = 10;
    private static final double HEIGHT = 10;
}