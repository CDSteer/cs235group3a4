import Entity.AbstractMovableEntity;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.lwjgl.opengl.GL11.*;

/**
 * @author Cameron Steer
 * @since 1/02/2014
 * @date Verified and Updated by Design Manager Curtis on 23rd Feb 2014
 * @see http://www.codeproject.com/Questions/64657/how-to-draw-a-filled-circle-in-opengl
 * @brief Class has common data and methods for both games counters
 * @details This class allows us to create an instance of a board before its instantiated as a specific game counter
 */

public abstract class AbstractCounter extends AbstractMovableEntity {

    private int m_Player;
    private float m_Radius;

    /**
     * Constructor for a new counter
     * @param x
     * @param  y
     * @param width
     * @param height
     * @param radius
     * @param player
     */
    public AbstractCounter(double x, double y, double width, double height, float radius, int player) {
        super(x, y, width, height);
        this.m_Player = player;
        this.m_Radius = radius;
    }

    /**
     * return counter player.
     * @return m_Player
     */
    public int getPlayer(){
        return m_Player;
    }
    /**
     * set a new player value.
     * @param m_Player
     * @return void
     */
    public void setPlayer(int m_Player) {
        this.m_Player = m_Player;
    }

    /**
     * return counter radius.
     * @return m_Raduis
     */
    public float getRadius() {
        return m_Radius;
    }

    /**
     * set a new radius value.
     * @param m_Radius
     * @return void
     */
    public void setRadius(float m_Radius) {
        this.m_Radius = m_Radius;
    }

    /**
     * Draw the counter on the screen.
     * @return void
     */
    @Override
    public void draw() {
        //counters with player 0 are not rendered
        if (this.getPlayer() > 0){
            float x1 = (float)m_x;
            float y1 = (float)m_y;

            //filled circle
            float x2,y2;
            float angle;

            this.setColor();
            glBegin(GL_TRIANGLE_FAN);
            glVertex2f(x1,y1);

            for (angle = ANGLE_LOOP_START; angle < ANGLE_LOOP_MAX; angle+= ANGLE_LOOP_PLUS_AND_ASSIGN) {

                double foo = x1+sin(angle)*m_Radius;
                double bar = y1+cos(angle)*m_Radius;

                x2 = (float)foo;
                y2 = (float)bar;
                glVertex2f(x2,y2);
            }
            glEnd();
        }
    }

    /**
     * Center the counter to the square
     * @param square
     * @return void
     */
    public void center(AbstractSquare square){
        m_x = square.getX() + square.getWidth() / DIVIDE_BY_TWO - SUBTRACT_2_AND_A_HALF / DIVIDE_BY_TWO;
        m_y = square.getY() + square.getHeight() / DIVIDE_BY_TWO - SUBTRACT_2_AND_A_HALF / DIVIDE_BY_TWO;
        System.out.println(m_x+","+m_y);
    }

    /**
     * Method to reset the counter to a the start of a full column
     * @param square
     * @return void
     */
    public void reset(AbstractSquare square) {
        m_x = square.getX() + square.getWidth() / DIVIDE_BY_TWO;
        m_y = Y_RESET;
        this.setDY(0);
    }
    /**
     * Print the x and y coordinate of the the counter to the terminal
     * @return void
     */
    public void toSting(){
        System.out.println("x: " + m_x + "y: " + m_y);
    }

    public abstract void setColor();
    public abstract void playPlaceSound();
    public abstract void playNegSound();

    private final float ANGLE_LOOP_START = 1.0f;
    private final float ANGLE_LOOP_MAX = 10.61E02f;
    private final float ANGLE_LOOP_PLUS_AND_ASSIGN = 2.0E-01f;
    private final int Y_RESET = 20;
    private final int DIVIDE_BY_TWO = 2;
    private final double SUBTRACT_2_AND_A_HALF = 2.5;


}