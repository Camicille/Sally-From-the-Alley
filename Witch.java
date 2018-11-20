import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main character
 * 
 * @author Marlene Inoue & Ed Parrish
 * @version 1.1 19 November 2018
 */
public class Witch extends Sprite {
    private static final double MOVE_SPEED = 1.6;
    
    private static final double GRAVITY = 0.8;
    
    /**
     * Checks and responds to certain key presses
     */
    private void keyPress() {
        if (Greenfoot.isKeyDown("d")) {
            setXVelocity(MOVE_SPEED);
            //move(3);
        } else if (Greenfoot.isKeyDown("a")) {
            setXVelocity(-MOVE_SPEED);
            //move(-3);
        } else {
            setXVelocity(0.0);
        }
        
        if (Greenfoot.isKeyDown("space")) {
            //jump();
        }
    }
    
    /**
     * Makes character jump
     */
    private void jump() {
        //code to make jump
    }
    
    /**
     * Apply gravity when the Witch is jumping or falling
     */
    public void applyGravity() {
        double yVelocity = getYVelocity() + GRAVITY;
        
        setYVelocity(yVelocity);
    }
    
    /**
     * Reducing Witch's hp when touching an enemy
     */
    private void touchEnemies() {
        // if (isTouching(Werewolf.class)) {
           // //reduce hp value
        // }
        
        // if (isTouching(Bat.class)) {
            // //reduce hp value
        // }
        
        // if (isTouching(Spider.class)) {
            // //reduce hp value
        // }
        
        // if (isTouching(Boss.class)) {
            // //reduce hp value
        // }
    }
    
    /**
     * At end game, when the cat walks to the witch
     */
    private void touchCat() {
        if (isTouching(Cat.class)) {
            setLocation(getX(), getY() - 5);
        }
    }
    
    /**
     * Act - do whatever the Witch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        keyPress();
        
        touchEnemies();
        touchCat();
        
        move();
        
    }
}