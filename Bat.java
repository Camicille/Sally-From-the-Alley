import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bat: A bat that flys and attacks.
 * Note to self To-do get direction of facing most likely in world
 * and overload contructor and set more booleans
 * call to death animation
 * @author (Philip Jepkes) 
 * @version (V1.0)
 */
public class Bat extends Enemy
{ public double count=0;
    public Bat(){}
    /**
     * Act - do whatever the Bat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        alterCount();
        movement();
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
     setLocation( getExactX()- push,getExactY() + amp * Math.sin( aF * time +shift) + offset);
     if (getExactX() <=0){getWorld().removeObject(this);}
     }
     public double getCount(){return count;}
    public void alterCount(){count++;}
    private void removeThis(){ 
        if(isTouching(Witch.class) && this !=null){
        getWorld().removeObject(this);
    
    }
    }

}
