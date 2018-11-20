import greenfoot.*;
/**
 * class Potion: Affects Player on Touch
 * 
 * @author Tyler Bakeman
 * @version 1.01 11/20/18
 **/
public class Potion extends Objex{
    //object personal
    private static final String[] anime = {"Potion.png","Potion2.png"};
    //object dynamix
    private int TIME = 0;
    private double gravity = 0;
    private static final int ADF = 4; //anime delay factor
    public Potion(){
       setImage(anime[0]); 
    }
    public void act(){
        Physics();
        Anime();
        TIME = (TIME + 1) % (ADF * anime.length);
    }
    
    
    private void Physics(){
        int dy = 0;
        Platform floor = (Platform)getOneObjectAtOffset(0,getImage().getHeight(),Platform.class);
        if(floor == null)
            gravity++;
        else
            gravity = 0;
        dy = (int)Math.pow(gravity,2);
        setLocation(getX(),getY() + dy);
    }
    
    
    private void Anime(){
        setImage(anime[TIME/ADF]);
    }
}
