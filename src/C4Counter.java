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
        super(X, Y, WIDTH, HEIGHT, RADIUS, PLAYER_1);
    }

    @Override
    public void setColor() {
        if (getPlayer() == PLAYER_1) {
            glColor3d(1, 0, 0);
        } else if (getPlayer() == PLAYER_2) {
            glColor3d(0, PLAYER2_COLOR, 0);
        }
    }

    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;
    private static final float RADIUS = 10;
    private static final double X = 115;
    private static final double PLAYER2_COLOR = 1.5;
    private static final double Y = 20;
    private static final double WIDTH = 10;
    private static final double HEIGHT = 10;
}