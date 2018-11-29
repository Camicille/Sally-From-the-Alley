import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Howl projectile that will grow in size
 * created upon howl attack will move in direction and grow in size over few act cycles
 * @author (Philip Jepkes) 
 * @version (v0)
 */
public class Howl extends SmoothMover
{   
    private int animationTimer=0;
    private  int cylceImage=0;
    private int damageAmount=3;
    private boolean hasmoved;
    private static final int IMAGE_AMOUNT=32;
    private static GreenfootImage[] images;
    public Howl()
    {
        this(new Vector(30,0));

    }

    public Howl(Vector velocity)
    {
        super(velocity);
        initializeImages();
    }

    /**
     * Act - do whatever the Howl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        travel();
        if (hasmoved)
        {
            getWorld().removeObject(this);
            return;
        }
        if (isAtEdge()&& this !=null)
        {
            getWorld().removeObject(this);
            return;
        }
    } 

    private void travel()
    {
        move();
        grow();
        damage();
    }

    private void damage()
    {
      if(isTouching(Fireball.class))
      {
      removeTouching(Fireball.class);
      }
      GameWorld world =(GameWorld) getWorld(); 
        if(isTouching(Witch.class))
        {
            world.changeHealth(-damageAmount);
        }
    }

    private static void initializeImages()
    {
        if (images ==null )
        {
            GreenfootImage startingImage = new GreenfootImage("blue-draught.png");
            images = new GreenfootImage[IMAGE_AMOUNT];
            for (int i=0; i<IMAGE_AMOUNT;i++)
            {
                int size = (i+1) *  ( startingImage.getWidth()*2 / IMAGE_AMOUNT );
                images[i] = new GreenfootImage(startingImage);
                images[i].scale(size, size);
            }
        }
    }

    private void grow()
    {
        setImage(images[cylceImage]);
        animationTimer++;
        if(animationTimer==4)
        {
            cylceImage++;
            animationTimer=0;
        }
        if (cylceImage==IMAGE_AMOUNT){
            hasmoved=true;
        }
    }  
}
