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

    protected double x, y, height, width;
    protected Rectangle hitbox = new Rectangle();

    public AbstractEntity(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    /**
     * set entity x value.
     *
     * @return void
     */
    @Override
    public void setX(double x) {
        this.x = x;
    }
    /**
     * set entity y value.
     *
     * @return void
     */
    @Override
    public void setY(double y) {
        this.y = y;
    }
    /**
     * set entity width value.
     *
     * @return void
     */
    @Override
    public void setWidth(double width) {
        this.width = width;
    }
    /**
     * set entity height value.
     *
     * @return void
     */
    @Override
    public void setHeight(double height) {
        this.height = height;
    }
    /**
     * return entity x value.
     *
     * @return x
     */
    @Override
    public double getX() {
        return x;
    }
    /**
     * return entity y value.
     *
     * @return y
     */
    @Override
    public double getY() {
        return y;
    }
    /**
     * return entity height value.
     *
     * @return x
     */
    @Override
    public double getHeight() {
        return height;
    }
    /**
     * return entity width value.
     *
     * @return width
     */
    @Override
    public double getWidth() {
        return width;
    }

    /**
     * checks is entity intersects another entity
     *
     * @return boolean result
     */
    @Override
    public boolean intersects(Entity other) {
        hitbox.setBounds((int) x, (int) y, (int) width, (int) height);
        return hitbox.intersects(other.getX(), other.getY(), other.getWidth(), other.getHeight());
    }

    /**
     * checks is the coordinates of the mouse is in the boundaries of the entity
     *
     * @return boolean result
     */
    public boolean inBounds(int mouseX, int mouseY) {
        return mouseX > this.x && mouseX < this.x + this.width && mouseY > this.y && mouseY < this.y + this.height;
    }
}
