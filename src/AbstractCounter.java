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
public class AbstractCounter extends AbstractMovableEntity {

    private int m_Player;
    private float m_Radius;


    public AbstractCounter(double x, double y, double width, double height, float radius, int player) {
        super(x, y, width, height);
        this.m_Player = player;
        this.m_Radius = radius;
    }

    public int getPlayer(){
        return m_Player;
    }

    public void setPlayer(int m_Player) {
        this.m_Player = m_Player;
    }

    public float getRadius() {
        return m_Radius;
    }

    public void setRadius(float m_Radius) {
        this.m_Radius = m_Radius;
    }

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

    public void center(AbstractSquare square){
        x = square.getX() + square.getWidth() / 2 - 2.5 / 2;
        y = square.getY() + square.getHeight() / 2 - 2.5 / 2;
    }

    public void dropCounter(int delta){
        update(delta);
    }

    public void reset(AbstractSquare square) {
        x = square.getX() + square.getWidth() / 2;
        y = 20;
        this.setDY(0);
    }

    public void toSting(){
        System.out.println("x: " + x + "y: " + y);
    }
}