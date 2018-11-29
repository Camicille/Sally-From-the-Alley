import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Death: An removal animation that will exist when enemies are removed
 * 
 * @author Philip Jepkes  Ed Parrish 
 * @version (V0)
 */
public class Death extends Enemy
{   
    private static GreenfootImage[] images;
    private static final int IMAGE_AMOUNT = 3;
    public Death (int imageSelect)
    {
        initializeImages();
        setImage(images[Math.abs(imageSelect)]);
    }
    
    /**
     * Act - do whatever the Death wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        fade();
        // Add your action code here.
    }  
    public void fade()
    {
        int alpha=getImage().getTransparency();
        if (alpha>5 )
        {
            getImage().setTransparency(alpha-5);
        }
        else
        {
            getWorld().removeObject(this);
        }
    }
    private static void initializeImages()
    {
         if(images == null )
        {
            images = new GreenfootImage [IMAGE_AMOUNT];
            
            for(int i=0; i<images .length;i++)
            {
                String fileName= "skull" + (i+1) + ".png";
                images [i] = new GreenfootImage(fileName);
               
            }
        } 
    }
}
