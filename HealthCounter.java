import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object that displays an image representing the player's health.
 * 
 * @author Chandler Clarke
 * @version Alpha 1.0
 */
public class HealthCounter extends GameMaster
{
    private EasterEgg easterEgg;
    private int timer;
    /**
     * Act - do whatever the HealthCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        easterEgg();
    }    

    private void easterEgg(){
        if (isTouching(Witch.class) == true){
            while (timer < 100){
                GameWorld world = (GameWorld) getWorld();
                world.addObject(easterEgg, world.getWidth()/2, world.getHeight()/2);
                timer++;
            }
        }
        else if (easterEgg != null){
            GameWorld world = (GameWorld) getWorld();
            world.removeObject(easterEgg);
        }
    }
}