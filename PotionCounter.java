import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object that displays an image representing what potions are currently in inventory.
 * 
 * @author Chandler Clarke
 * @version Alpha 1.0
 */
public class PotionCounter extends GameMaster
{
    private GreenfootImage img1, img2;
    private int i;
    public PotionCounter(int potionType){
        if (potionType == 1){
            img1 = new GreenfootImage("Potion.png");
            img2 = new GreenfootImage("Potion2.png");
        } 
        else 
            System.out.println("Invalid potion type");
    }

    /**
     * Act - do whatever the PotionCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drawImages();
    }

    public void drawImages(){
        if (i <= 60){
            setImage(img1);
        }
        if (i > 60){
            setImage(img2);
        }
        if (i > 120)
            i = 0;
        i++;
    }
}