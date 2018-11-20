import greenfoot.*;
/**
 * class Lantern: LIT object, random chance to do something
 * 
 * @author Tyler Bakeman
 * @version 1.01 11/20/18
 **/
public class Lantern extends Objex{
    //object personal
    private static final String[] anime = {"Lantern.png","Lantern2.png"};
    private int floatHeight = 50;
    private static polar floatRange = new polar(-10,10);
    private static IncQuo floatSpeed = new IncQuo(1,24);
    //object dynamix
    private int TIME = 0;
    private double gravity = 0;
    private static final int ADF = 4; //anime delay factor
    public Lantern(){
        setImage(anime[0]);
    }
    public void act(){
        Physics();
        Anime();
        TIME = (TIME + 1) % (ADF * anime.length);
    }
    
    
    private void Physics(){
        /** GRAVITY DISABLED
        int dy = 0;
        Platform floor = (Platform)getOneObjectAtOffset(0,getImage().getHeight() + floatHeight,Platform.class);
        if(floor == null)
            gravity++;
        else
            gravity = 0;
        dy = (int)Math.pow(gravity,2);
        setLocation(getX(),getY() + dy);**/
    }
    
    
    private void Anime(){
        setImage(anime[TIME/ADF]);
        Float();
    }
    private void Float(){
        if(floatSpeed.poll() == 1)
            setLocation(getX(),getY() + floatRange.poll());
    }
}
