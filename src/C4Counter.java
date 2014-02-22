import static org.lwjgl.opengl.GL11.glColor3d;

/**
 * @file 	Counter.java
 * @author 	Cameron Steer
 * @date	January 28, 2014
 * @brief	Counter holds data and methods for the connect 4 counters
 * @details
 */
public class C4Counter extends AbstractCounter {

    public C4Counter() {
        super(X, Y, WIDTH, HEIGHT, RADIUS, PLAYER);
    }

    @Override
    public void setColor() {
        if (getPlayer() == 1) {
            glColor3d(1, 0, 0);
        } else if (getPlayer() == 2) {
            glColor3d(0, 1.5, 0);
        }
    }

    private static final int PLAYER = 1;
    private static final float RADIUS = 10;
    private static final double X = 115;
    private static final double Y = 20;
    private static final double WIDTH = 10;
    private static final double HEIGHT = 10;
}