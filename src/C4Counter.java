import org.lwjgl.opengl.Display;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.ResourceLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.glColor3d;

/**
 * @author Cameron Steer
 * @since January 28, 2014
 * @brief Holds data and methods for the connect 4 counters
 * @details
 */

public class C4Counter extends AbstractCounter {

    private Audio m_PlaceSound;
    private Audio m_NegSound;
    private Audio m_DropSound;


    /**
     * constructor for a connect four counter, this uses this calls the super constructor
     * with the coordinates, size and details of the counter. It also calls the method
     * to set up the sounds.
     */
    public C4Counter() {
        super(X, Y, WIDTH, HEIGHT, RADIUS, PLAYER);
        setSoundFiles();
    }
    /**
     * This loads the sound files for counters
     * @return void
     */
    private void setSoundFiles(){
        try {
            m_PlaceSound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/coin-drop-4.wav"));
            m_NegSound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/negative.wav"));
            m_DropSound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/drop.wav"));
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
     * @return void
     */
    @Override
    public void setColor() {
        if (getPlayer() == PLAYER_1) {
            glColor3d(1, 0, 0);
        } else if (getPlayer() == PLAYER_2) {
            glColor3d(1, PLAYER2_COLOR, 0);
        }
    }

    /**
     * plays sound of counter dropping into grid
     * @return void
     */
    public void playPlaceSound(){
        m_PlaceSound.playAsSoundEffect(1.0f, 1.0f, false);
        SoundStore.get().poll(0);
    }
    /**
     * plays sound of counter for being able to drop counter
     * @return void
     */
    public void playNegSound(){
        m_NegSound.playAsSoundEffect(1.0f, 1.0f, false);
        SoundStore.get().poll(0);
    }
    /**
     * plays sound of counter falling through grid
     * @return void
     */
    public void playDropSound(){
        m_DropSound.playAsSoundEffect(1.0f, 1.0f, false);
        SoundStore.get().poll(0);
    }

    /**
     * Up date the counters delta to move it on the screen.
     * @param delta
     */
    public void dropCounter(int delta){
        update(delta);
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