import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Super class of how the character's move
 * 
 * @author Marlene Inoue & Ed Parrish
 * @version 1.1 19 November 2018
 */
public abstract class Sprite extends SmoothMover {
    private double x = 0, y = 0; //the x and y coordinates
    private double xVel;
    private double yVel; //pixels per act() call
    
    /**
     * Default constructor
     */
    public Sprite() {
        this(0.0, 0.0);
    }
    
    /**
     * Constructor setting velocity of the sprite
     * 
     * @param xVel  x component of the velocity
     * @param yVel  y component of the velocity
     */
    public Sprite(double xVel, double yVel) {
        this.xVel = xVel;
        this.yVel = yVel;
    }
    
    /**
     * Initialize the x and y coordinates when added to the world.
     *
     * @param world The game world.
     */
    protected void addedInWorld(World world) {
        x = getX();
        y = getY();
    }
    
    /**
     * Move based on velocity.
     */
    public void move() {
        setLocation(x + xVel, y + yVel);
    }
    
    /**
     * Allows precise tracking of the location and eventually calls
     * the built-in 'setLocation' method of Actor.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
        super.setLocation((int) x, (int) y);
    }
    
    /**
     * Override the default 'setLocation' method to keep our coordinates
     * up-to-date.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    @Override
    public void setLocation(int x, int y) {
        setLocation((double) x, (double) y);
    }
    
    /**
     * Returns the currect horizontal velocity
     * 
     * @return  the current horizontal velocity
     */
    public double getXVelocity() {
        return xVel;
    }
    
    /**
     * Sets the horizontal velocity to a new velocity
     * 
     * @param newXVel  the new horizontal velocity
     */
    public void setXVelocity(double newXVel) {
        xVel = newXVel;
    }
    
    /**
     * Returns the currect vertical velocity
     * 
     * @return  the current vetical velocity
     */
    public double getYVelocity() {
        return yVel;
    }
    
    /**
     * Sets the vertical velocity to a new velocity
     * 
     * @param newXVel  the new vertical velocity
     */
    public void setYVelocity(double newYVel) {
        yVel = newYVel;
    }
}
