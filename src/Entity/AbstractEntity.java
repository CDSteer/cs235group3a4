package Entity;

import java.awt.*;

/**
 * @file 	AbstractEntity.java
 * @author 	Cameron Steer
 * @date	January 28, 2014
 * @see     http://www.youtube.com/user/TheCodingUniverse
 * @brief	Abstract class any entity within the program.
 * @details Contains general graphics details like coordinates and size
 */
public abstract class AbstractEntity implements Entity {

    protected double m_x, m_y, m_height, m_width;
    private Rectangle m_hitbox = new Rectangle();

    public AbstractEntity(double x, double y, double width, double height) {
        this.m_x = x;
        this.m_y = y;
        this.m_width = width;
        this.m_height = height;
    }
    /**
     * set entity x value.
     *
     * @return void
     */
    @Override
    public void setX(double x) {
        this.m_x = x;
    }
    /**
     * set entity y value.
     *
     * @return void
     */
    @Override
    public void setY(double y) {
        this.m_y = y;
    }
    /**
     * set entity width value.
     *
     * @return void
     */
    @Override
    public void setWidth(double width) {
        this.m_width = width;
    }
    /**
     * set entity height value.
     *
     * @return void
     */
    @Override
    public void setHeight(double height) {
        this.m_height = height;
    }
    /**
     * return entity x value.
     *
     * @return x
     */
    @Override
    public double getX() {
        return m_x;
    }
    /**
     * return entity y value.
     *
     * @return y
     */
    @Override
    public double getY() {
        return m_y;
    }
    /**
     * return entity height value.
     *
     * @return x
     */
    @Override
    public double getHeight() {
        return m_height;
    }
    /**
     * return entity width value.
     *
     * @return width
     */
    @Override
    public double getWidth() {
        return m_width;
    }

    /**
     * checks is entity intersects another entity
     *
     * @return boolean result
     */
    @Override
    public boolean intersects(Entity other) {
        m_hitbox.setBounds((int) m_x, (int) m_y, (int) m_width, (int) m_height);
        return m_hitbox.intersects(other.getX(), other.getY(), other.getWidth(), other.getHeight());
    }

    /**
     * checks is the coordinates of the mouse is in the boundaries of the entity
     *
     * @return boolean result
     */
    public boolean inBounds(int mouseX, int mouseY) {
        return mouseX > this.m_x && mouseX < this.m_x + this.m_width && mouseY > this.m_y && mouseY < this.m_y + this.m_height;
    }
}
