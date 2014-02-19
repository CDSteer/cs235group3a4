import Entity.AbstractMovableEntity;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.lwjgl.opengl.GL11.*;

/**
 * @file 	Counter.java
 * @author 	Cameron Steer
 * @date	January 28, 2014
 * @see     http://www.codeproject.com/Questions/64657/how-to-draw-a-filled-circle-in-opengl
 * @brief	Counter holds data and methods fo the game counters
 * @details
 *
 */
public class C4Counter extends AbstractCounter {

    public C4Counter() {
        super(X, Y, WIDTH, HIGHT, RADIUS, PLAYER);
    }

    private static final int PLAYER = 1;
    private static final float RADIUS = 10;
    private static final double X = 115;
    private static final double Y = 20;
    private static final double WIDTH = 10;
    private static final double HIGHT = 10;
}