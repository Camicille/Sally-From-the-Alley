import greenfoot.*;
/**
 * class Potion: Affects Player on Key Press: inventory
 * 
 * @author Tyler Bakeman
 * @version 1.02 11/28/18
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
        collision();
        TIME = (TIME + 1) % (ADF * anime.length);
    }
    
    
    private void Physics(){
        int dy = 0;
        Actor floor = getOneObjectAtOffset(0,getImage().getHeight(),null);
        if(floor == null)
            gravity = 2.5;
        else
            gravity = 0;
        dy = (int)Math.pow(gravity,2);
        setLocation(getX(),getY() + dy);
    }
    
    
    private void Anime(){
        setImage(anime[TIME/ADF]);
    }
    
    
    private void collision(){
        if(isTouching(Sprite.class)){
            int affect = Greenfoot.getRandomNumber(1);
            switch(affect){
                case 0:  restore(); break;
                default: restore(); break;
            }
        }
    }
    private void restore(){
        GameWorld world = (GameWorld)getWorld();
        world.changeHealth(1);
    }
}
