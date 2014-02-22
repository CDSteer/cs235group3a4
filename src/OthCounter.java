import static org.lwjgl.opengl.GL11.glColor3d;

/**
 * @file 	Counter.java
 * @author 	Cameron Steer
 * @date	January 28, 2014
 * @brief	Counter holds data and methods for the othello counters
 * @details
 */
public class OthCounter extends AbstractCounter {

    public OthCounter() {
        super(X, Y, WIDTH, HIGHT, RADIUS, PLAYER);
    }

    @Override
    public void setColor() {
        if (getPlayer() == 1) {
            glColor3d(0, 0, 0);
        } else if (getPlayer() == 2) {
            glColor3d(1, 1, 1);
        }
    }

    private static final int PLAYER = 1;
    private static final float RADIUS = 10;
    private static final double X = 115;
    private static final double Y = 20;
    private static final double WIDTH = 10;
    private static final double HIGHT = 10;


}
