import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * WereWolf:A wolf that wil walk back and forth or howl
 * To-do multiple constructors and attacks
 * @author Philip Jepkes initializeImages by Ed Parrish
 * @version (V1.0)
 */
public class WereWolf extends Enemy
{   private boolean turn;
    private boolean facingLeft;
    private boolean facingRight;
    private boolean isAttacking;
    private boolean howling;
    private int howlTimer=120;
    private int healthSlot=0;
    private int damageSlot=2;
    private int fireDirection=1;
    private int attackCount=0;
    private int frameCount=0;
    private int imageUpTick=0;
    private int attackImageUpTick=0;
    private int maxDistance=0;
    private int spawnPosition=0;
    private int randomDeathImage=Greenfoot.getRandomNumber(3);
    private static final int IMAGE_AMOUNT = 6;
    private static final int ATTACK_IMAGE_AMOUNT =7;
    private static final int FRAMES_TILL_CHANGE = 10;
    private static final int ATTACK_FRAMES_TILL_CHANGE = 30;
    private static GreenfootImage[] faceLeftImages;
    private static GreenfootImage[] faceRightImages;
    private static GreenfootImage[] attackLeftImages;
    private static GreenfootImage[] attackRightImages;
    private static GreenfootImage[] howlLeftImages;
    private static GreenfootImage[] howlRightImages;
    public WereWolf(boolean howler,boolean setDirectionLeft,int spawnLocationX,int travelDistance)
    {
        howling =howler;
        spawnPosition=Math.abs(spawnLocationX);
        maxDistance=Math.abs(travelDistance);
        intializeImages();
        if(setDirectionLeft && howler)
        {
            facingLeft=true;
            //isAttacking=true;
            setImage(attackLeftImages[0]);
        }
        if(setDirectionLeft && !howler)
        {
            facingLeft=true;
            setImage(faceLeftImages[0]);
        }
        if(!setDirectionLeft && howler)
        {
            facingRight=true;
            //isAttacking=true;
            setImage(attackRightImages[0]);
        }
        if(!setDirectionLeft && !howler)
        {
            facingRight=true;
            setImage(faceRightImages[0]);
        }
        //add variable int spawnLocation and int max distance
    }
    public WereWolf()
    {
        this(false,true,300,75);
    }
    /**
     * Act - do whatever the WereWolf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!howling)
        {
            walk();
            animate();
            //turnAround();
            //attack();
        }
        if(howling)
        {
            attackAnimation();
            howl();
            
            //turnAround();
        }
        if(isTouching(Witch.class) && this !=null)
        {
           dealDmg(damageSlot);
        }
        removeFromDmg(healthSlot);
    }   

    /**
     * this will be altered and turn postion will change 
     */
    private void walk(){
        if (getX() <= (spawnPosition -maxDistance)){
            turn = true;
            facingLeft=false;
            facingRight=true;
            //add || facingLeft
        }

        if (getX() >=(spawnPosition+maxDistance)){
            turn = false;
            facingRight=false;
            facingLeft=true;
            //add || facingRight
        } 
        if (!turn)
        {
            setLocation(getX()-1,getY());
        }
        if(turn){        
            setLocation(getX()+1,getY());
        }
    }
    private void howl()
    {
           
            howlTimer++;
            
            if(howlTimer>=120)
            {
                howlTimer=120;
                
            }
            
            if(isAttacking && howlTimer ==120 )
            {
            GameWorld world =(GameWorld) getWorld();
            GreenfootImage current= getImage();
            if (facingLeft)
            {
                fireDirection=-1;
            }
            else if (facingRight)
            {
                fireDirection=1;
            }
            //add GreenfootImage getWidth()/2 to getX
            
            Howl howl =new Howl(new Vector(2.0*fireDirection,0.0));
            world.addObject(howl,getX()+ current.getWidth()*fireDirection/2,getY());
            howl.move(2*fireDirection);
            howlTimer=0;
            isAttacking=false;
            }
        
     }
    private void attack(){// if player is within radius attack 
    }
    private void turnAround()
    {
        //if (getX()>=  && !facing that direction) {
        //flip horizontal set boolean to false  true }
    }
    private static void intializeImages()
    {
         if(faceLeftImages == null || faceRightImages==null)
         {
            faceLeftImages = new GreenfootImage [IMAGE_AMOUNT];
            faceRightImages = new GreenfootImage [IMAGE_AMOUNT];
            for(int i=0; i<faceRightImages.length;i++)
            {
                String fileName= "werewolfrun" + (i+1) + ".png";
                faceLeftImages[i] = new GreenfootImage(fileName);
                faceRightImages[i]= new GreenfootImage(faceLeftImages[i]);
                faceRightImages[i].mirrorHorizontally();
            }
        }
           if(attackLeftImages == null || attackRightImages==null)
         {
            attackLeftImages = new GreenfootImage [IMAGE_AMOUNT];
            attackRightImages = new GreenfootImage [IMAGE_AMOUNT];
            for(int i=0; i<faceRightImages.length;i++)
            {
                String fileName= "werewolfattack" + (i+1) + ".png";
                attackLeftImages[i] = new GreenfootImage(fileName);
                attackRightImages[i]= new GreenfootImage(attackLeftImages[i]);
                attackRightImages[i].mirrorHorizontally();
            }
        }
    }
    
    private void animate()
    {
        frameCount++;
        if(!howling)
        {
            if (frameCount == FRAMES_TILL_CHANGE && facingLeft  )
            {
            imageUpTick++;
            if(imageUpTick>=faceLeftImages.length)
               {
                imageUpTick=0;
               }
            setImage(faceLeftImages[imageUpTick]);
            frameCount =0;
            }
           else  if (frameCount == FRAMES_TILL_CHANGE && facingRight )
           {
            imageUpTick++;
            if(imageUpTick>=faceLeftImages.length)
              {
                imageUpTick=0;
              }
            setImage(faceRightImages[imageUpTick]);
            frameCount =0;
           }
        }
             
    }
    private void attackAnimation(){
        
        attackCount++;
        if (attackCount >= ATTACK_FRAMES_TILL_CHANGE && facingLeft)
        {
            imageUpTick++;
            if (imageUpTick==4){
                isAttacking=true;
            }
            if(imageUpTick>=attackLeftImages.length)
               {
                imageUpTick=0;
               }
            setImage(attackLeftImages[imageUpTick]);
            attackCount =0;
            
            }
        else  if (attackCount >= ATTACK_FRAMES_TILL_CHANGE && facingRight )
           {
            imageUpTick++;
            if (imageUpTick==4)
            {
                isAttacking=true;
            }
            if(imageUpTick>=attackRightImages.length)
              {
                imageUpTick=0;
              }
            setImage(attackRightImages[imageUpTick]);
            attackCount =0;
            
           }  
        }
}
