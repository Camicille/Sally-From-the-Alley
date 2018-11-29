import greenfoot.*;
/**
 * class Lantern: LIT object, random chance to do something
 * 
 * @author Tyler Bakeman
 * @version 1.02 11/28/18
 **/
public class Lantern extends Objex{
    //object personal
    private int floatHeight;
    private static final String[] anime = {"Lantern.png","Lantern2.png"};
    private static pivot floatRange = new pivot(-10,10);
    private static IncQuo floatSpeed = new IncQuo(1,20);
    //object dynamix
    private int TIME = 0;
    private double gravity = 0;
    private static final int ADF = 16; //anime delay factor
    //
    private boolean setup = true;
    Light light = new Light(150);
    public Lantern(){
        setImage(anime[0]);
    }
    public void act(){
        if(setup){
            floatHeight = getY();
            setup = false;
            World world = getWorld();
            world.addObject(light,getX(),getY());
        }
        Anime();
        TIME = (TIME + 1) % (ADF * anime.length);
        Physics();
    }
    
    
    private void Physics(){
        if(isTouching(Witch.class)){
            Greenfoot.playSound("42.wav");
            World world = getWorld();
            int x = Greenfoot.getRandomNumber(1);
            if(x == 0) world.addObject(new Gem(),getX(),getY());
            else world.addObject(new Potion(),getX(),getY());
            world.removeObject(light);
            world.removeObject(this);
        }
    }
    
    
    private void Anime(){
        setImage(anime[TIME/ADF]);
        Float();
        light.setLocation(getX(),getY());
    }
    private void Float(){
        if(floatSpeed.poll() == 1)
            setLocation(getX(),floatHeight + floatRange.poll());
    }
}
