import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Bat: A bat that flys and attacks.
 * Note to self To-do get direction of facing most likely in world
 * and overload contructor and set more booleans
 * call to death animation
 * @author Philip Jepkes initializeImages by Ed Parrish
 * 
 * @version (V1.0)
 */
public class Bat extends Enemy
{   
    private boolean facingLeft;
    private boolean facingRight;
    private double changeDirection=1;
    private double count=0;
    private int frameCount=0; 
    private int imageUpTick=0;
    private int healthSlot=0;
    private int damageSlot=1;
    private int randomDeathImage=Greenfoot.getRandomNumber(3);
    private static final int IMAGE_AMOUNT = 4;
    private static final int FRAMES_TILL_CHANGE = 10;
    private static GreenfootImage[] faceLeftImages;
    private static GreenfootImage[] faceRightImages;
    public Bat(boolean setDirectionLeft)
    {
        intializeImages();
        if(setDirectionLeft)
        {
            facingLeft=true;
            changeDirection =1;
            //setImage(faceLeftImages[0]);
        }
        if(!setDirectionLeft)
        {
            facingRight=true;
            changeDirection = -1;
            //setImage(faceRightImages[0]);
        }

        faceLeftorRight();
    }

    public Bat(){
        this(true);
    }

    /**
     * Act - do whatever the Bat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        alterCount();
        animation();
        movement();
        removeThis();
    }    

    private void movement(){
        double amp = 3.0;
        double time = Math.toRadians(getCount());
        double shift = 0.0;
        double offset = 0.0;
        double frequency =.5;
        double aF = 2 * Math.PI * frequency;
        double push = Math.PI;
        //Math.abs(amp * Math.sin( aF * time +shift) + offset) if want to alter X so its triangle esque
        setLocation( getExactX()-push*changeDirection,getExactY() + amp * Math.sin( aF * time +shift) + offset);

    }

    public double getCount(){
        return count;
    }

    public void alterCount(){
        count++;
    }

    private void removeThis()
    { 
        if (getExactX() <=0 || getExactX()>=800)
        {
            getWorld().removeObject(this); 
            return;
        }
        if(isTouching(Witch.class) && this !=null)
        {
           dealDmg(damageSlot);
        }
        removeFromDmg(healthSlot);
    }

    private static void intializeImages()
    {
        if(faceLeftImages == null || faceRightImages==null)
        {
            faceLeftImages = new GreenfootImage [IMAGE_AMOUNT];
            faceRightImages = new GreenfootImage [IMAGE_AMOUNT];
            for(int i=0; i<faceRightImages.length;i++)
            {
                String fileName= "Bat" + (i+1) + ".png";
                faceLeftImages[i] = new GreenfootImage(fileName);
                faceRightImages[i]= new GreenfootImage(faceLeftImages[i]);
                faceRightImages[i].mirrorHorizontally();
            }
        }
    }

    private void faceLeftorRight()
    {
        if (facingLeft)
        {
            setImage(faceLeftImages[0]);
        }
        else if (facingRight)
        {
            setImage(faceRightImages[0]);
        }
    }

    private void animation()
    {
        frameCount++;
        if (frameCount == FRAMES_TILL_CHANGE && changeDirection >0 ){
            imageUpTick++;
            if(imageUpTick>=faceLeftImages.length)
            {
                imageUpTick=0;
            }
            setImage(faceLeftImages[imageUpTick]);
            frameCount =0;
        }
        else  if (frameCount == FRAMES_TILL_CHANGE && changeDirection <0 ){
            imageUpTick++;
            if(imageUpTick>=faceLeftImages.length)
            {
                imageUpTick=0;
            }
            setImage(faceRightImages[imageUpTick]);
            frameCount =0;
        }
    }
    private void damage()
    {
        
    }
   
}
