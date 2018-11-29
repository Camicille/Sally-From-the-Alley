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
    private static GreenfootImage[] heartImages;
    private GreenfootImage img1;
    private GreenfootImage img2;
    private int health = 7; //7 out of 10
    private int i = 0;
    
    public HealthCounter(){
        initializeImages();
        img1 = heartImages[0];
        img2 = heartImages[1];
    }

    /**
     * Act - do whatever the HealthCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        easterEgg();
        drawImages();
    }    

    public void drawImages(){
        if (i <= 50){
            setImage(img1);
        }
        if (i > 50){
            setImage(img2);
        }
        if (i > 100)
            i = 0;
        i++;
    }

    public void initializeImages(){
        if (heartImages == null){
            heartImages = new GreenfootImage[2];
            heartImages[0] = new GreenfootImage("heart1.png");
            heartImages[1] = new GreenfootImage("heart2.png");
        }
    }

    private void easterEgg(){
        if (isTouching(Fireball.class) == true){
            while (timer < 100){
                GameWorld world = (GameWorld) getWorld();
                world.addObject(easterEgg, world.getWidth()/2, world.getHeight()/2);
                timer++;
            }
            if (timer > 100){
                GameWorld world = (GameWorld) getWorld();
                world.removeObject(this);
            }
        }
        else if (easterEgg != null){
            GameWorld world = (GameWorld) getWorld();
            world.removeObject(easterEgg);
        }
    }
}