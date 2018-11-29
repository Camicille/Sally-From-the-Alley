import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Spider: That will drop and wiggle 
 * To do fall from branch quickly then ascend slowly creating a string
 * @author Philip Jepkes
 * @version (V0)
 */
public class Spider extends Enemy
{   private int frameCount=0;
    private int imageUpTick=0;
    private int maxDistance=0;
    private int spawnPosition=0;
    private int healthSlot=0;
    private int damageSlot=0;
    private int randomDeathImage=Greenfoot.getRandomNumber(3);
    private boolean inRange;
    private boolean goDown;
    private static GreenfootImage[] images;
    private counter weblength;
    public Spider(int spawnLocationY,int travelDistance)
    {
     //intializeImages();
     spawnPosition=Math.abs(spawnLocationY);
     maxDistance=Math.abs(travelDistance);
     //weblength = new counter(0,maxDistance);
     
    }
    public Spider()
    {
        this(48,128);
    }
    /**
     * Act - do whatever the Spider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // 
        movement();
        if(isTouching(Witch.class) && this !=null)
        {
           dealDmg(damageSlot);
        }
        removeFromDmg(healthSlot);
    }  

    private void movement()
    {
        if (getY() <= (spawnPosition)){
            goDown = true;
            //add || facingLeft
        }

        if (getY() >=(spawnPosition+maxDistance)){
            goDown = false;
           
            //add || facingRight
        } 
        if (goDown)
        {
            setLocation(getX(),getY()+2);
        }
        if(!goDown)
        {        
            
            setLocation(getX(),getExactY()-.5);
            
            
        }
        
        
        
        //GameWorld world =(GameWorld) getWorld();
        //int sallyPosX =
        //if(getY()<=spawnPostion &&){}
        //drop pattern if player is in range and or timer conditional
    }
    private static void intializeImages()
    {
        
    }
    private void checkForSally(){
    }
}
