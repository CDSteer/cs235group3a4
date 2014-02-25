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

    private Audio m_wavEffect;
    private Audio m_NegSound;

    /**
     * constructor for a othello counter, this calls the super constructor
     * with the coordinates, size and details of the counter. It also calls the method
     * to set up the sounds.
     */
    public OthCounter(int player) {
        super(X, Y, WIDTH, HEIGHT, RADIUS, player);
        setSoundFiles();
    }

    /**
     * This loads the sound files for counters
     *
     * @return void
     */
    private void setSoundFiles(){
        try {
            m_wavEffect = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/placeOthCounter.wav"));
            m_NegSound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/negative.wav"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Sound files not found, Exiting......");
            Display.destroy();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
            Display.destroy();
            System.exit(1);
        }
    }
    /**
     * sets colour buffer corresponding objects player to draw the correct colour
     *
     * @return void
     */
    @Override
    public void setColor() {
        if (getPlayer() == PLAYER_1) {
            glColor3d(0, 0, 0);
        } else if (getPlayer() == PLAYER_2) {
            glColor3d(1, 1, 1);
        }
    }
    /**
     * plays sound of counter for being able to placing counter
     *
     * @return void
     */
    @Override
    public void playSound() {
        m_wavEffect.playAsSoundEffect(1.0f, 1.0f, false);
        SoundStore.get().poll(0);
    }
    /**
     * plays sound of counter for being able to drop counter
     *
     * @return void
     */
    @Override
    public void playNegSound() {
        m_NegSound.playAsSoundEffect(1.0f, 1.0f, false);
        SoundStore.get().poll(0);
    }
    /**
     * not sure if needed yet
     *
     * @return void
     */
    @Override
    public void dropSound() {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    private static final float RADIUS = 10;
    private static final double X = 115;
    private static final double Y = 20;
    private static final double WIDTH = 10;
    private static final double HEIGHT = 10;
    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;


}
