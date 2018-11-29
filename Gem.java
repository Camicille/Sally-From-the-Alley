import greenfoot.*;
/**
 * class Gem: Adds to Score on Touch
 * 
 * @author Tyler Bakeman
 * @version 1.01 11/20/18
 **/
public class Gem extends Objex{
    //object personal
    private static final String[] anime = {"Gem.png","Gem2.png"};
    private static final int floatHeight = 20;
    //private static pivot floatRange = new pivot(-5,5);
    private static IncQuo floatSpeed = new IncQuo(1,12);
    //object dynamix
    private int TIME = 0;
    private double gravity = 0;
    private static final int ADF = 4; //anime delay factor
    public Gem(){
        setImage(anime[0]);
    }
    public void act(){
        Physics();
        Anime();
        TIME = (TIME + 1) % (ADF * anime.length);
    }
    
    
    private void Physics(){
        int dy = 0;
        Platform floor = (Platform)getOneObjectAtOffset(0,getImage().getHeight() + floatHeight,Platform.class);
        if(floor == null)
            gravity++;
        else
            gravity = 0;
        dy = (int)Math.pow(gravity,2);
        setLocation(getX(),getY() + dy);
    }
    
    
    private void Anime(){
        setImage(anime[TIME/ADF]);
        Float();
    }
    private void Float(){
        // if(floatSpeed.poll() == 1)
            // setLocation(getX(),getY() + floatRange.poll());
    }
}
