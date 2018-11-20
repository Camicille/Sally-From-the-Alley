import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sebastian the cat 
 * 
 * @author Marlene Inoue
 * @version 1.1 19 November 2018
 */
public class Cat extends Sprite {
    private static final int WALK = 1, END_GAME = 5;
    
    /**
     * When the cat comes in contact to witch (end game)
     */
    private void touchWitch() {
        //if touching the witch
        if (isTouching(Witch.class)) {
            setLocation(getX(), getY() - END_GAME);
            
            //so the cat stops moving once the witch reaches the Y axis of 0
            // if (!getWorld().getObjects(Witch.class).isEmpty()) {//witch.getX() == 0) {
                // Actor witch = getWorld().getObjects(Witch.class).get(0);
                
                // if (witch.getY() == 0) {
                    // setLocation(getX(), getY());
                // }
            // }
            
        //if not touching the witch
        } else if (!isTouching(Witch.class)) {
            setLocation(getX() - WALK, getY());
        }
    }
    
    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        touchWitch();
    }
}
