import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WereWolf:A wolf that wil walk back and forth or howl
 * To-do multiple constructors and attacks
 * @author (Philip Jepkes) 
 * @version (V1.0)
 */
public class WereWolf extends Enemy
{ private boolean turn;

    /**
     * Act - do whatever the WereWolf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turn();
    }   

    /**
     * this will be altered and turn postion will change 
     */
    private void turn(){
        if (getX() <=0){
            turn = true;
        }

        if (getX() >=300){
            turn = false;
        } 
        if (!turn)
        {
            setLocation(getX()-1,getY());
        }
        if(turn){        setLocation(getX()+1,getY());}
    }

    private void attack(){// if player is within radius attack 
    }
}
