import Entity.AbstractMovableEntity;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.lwjgl.opengl.GL11.*;

/**
 * @file 	AbstractCounter.java
 * @author 	Cameron Steer
 * @date	February 1, 2014
 * @see     \http://www.codeproject.com/Questions/64657/how-to-draw-a-filled-circle-in-opengl
 * @brief	Class had common data and methods for both games counters
 * @details This class allows us to create an instant of board before its instantiated as a specific game counter
 */
public class AbstractCounter extends AbstractMovableEntity {

    private int m_Player;
    private float m_Radius;

    /**
     * Constructor for a new counter
     *
     * @param x, y, width, height, radius, player
     */
    public AbstractCounter(double x, double y, double width, double height, float radius, int player) {
        super(x, y, width, height);
        this.m_Player = player;
        this.m_Radius = radius;
    }

    /**
     * return counter player.
     *
     * @return m_Player
     */
    public int getPlayer(){
        return m_Player;
    }
    /**
     * set a new player value.
     *
     * @param m_Player
     * @return void
     */
    public void setPlayer(int m_Player) {
        this.m_Player = m_Player;
    }

    /**
     * return counter radius.
     *
     * @return m_Raduis
     */
    public float getRadius() {
        return m_Radius;
    }

    /**
     * set a new radius value.
     *
     * @param m_Radius
     * @return void
     */
    public void setRadius(float m_Radius) {
        this.m_Radius = m_Radius;
    }

    /**
     * Draw the counter on the screen.
     *
     * @return void
     */
    @Override
    public void draw() {
        float x1 = (float)x;
        float y1 = (float)y;

        //filled circle
        float x2,y2;
        float angle;


        if (m_Player == 1) {
            glColor3d(1, 0, 0);
        } else if (m_Player == 2) {
            glColor3d(0, 1.5, 0);
        }

        glBegin(GL_TRIANGLE_FAN);
        glVertex2f(x1,y1);

        for (angle=1.0f; angle < 10.61E02f; angle+= 2.0E-01f) {

            double foo = x1+sin(angle)*m_Radius;
            double bar = y1+cos(angle)*m_Radius;

            x2 = (float)foo;
            y2 = (float)bar;
            glVertex2f(x2,y2);
        }
        glEnd();
    }

    /**
     * Center the counter to the square
     *
     * @param square
     * @return void
     */
    public void center(AbstractSquare square){
        x = square.getX() + square.getWidth() / 2 - 2.5 / 2;
        y = square.getY() + square.getHeight() / 2 - 2.5 / 2;
        System.out.println(x+","+y);
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

    /**
     * This resets the counter to a the start of a full column
     *
     * @param square
     * @return void
     */
    public void reset(AbstractSquare square) {
        x = square.getX() + square.getWidth() / 2;
        y = 20;
        this.setDY(0);
    }
    /**
     * Print the x and y coordinate of the the counter to the terminal
     *
     * @return void
     */
    public void toSting(){
        System.out.println("x: " + x + "y: " + y);
    }
}