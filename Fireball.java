import greenfoot.*;
import java.util.List;

/**
 * A fireball that kills enemies
 * 
 * @author Tyler Bakeman, Marlene Inoue
 * @version 1.0 28 November 2018
 */
public class Fireball extends Objex{
    private int speed;
    private counter lifetime = new counter(70,0);
    private Light light  = new Light(28);
    private boolean setup = true;
    /**
     * Constructor for Fireball
     * 
     * @param speed  the spped the fireball will fire at
     */
    public Fireball(int speed){
        this.speed = speed;
        setImage("Fire.png");
        getImage().scale(16, 16);
        if(speed < 0) getImage().mirrorHorizontally();
    }
    
    /**
     * 
     */
    public void collision(){
        List<Enemy> e = getObjectsInRange(getImage().getWidth(), Enemy.class);
        for (Enemy enemy: e) {
            if (e != null) {
                getWorld().removeObject(enemy);
            }
        }
    }
    
    public void move(){
        setLocation(getX()+speed, getY());
        light.setLocation(getX()+speed, getY());
    }
    
    public void act(){
        if(setup){
            World world = getWorld();
            world.addObject(light,getX(),getY());
            setup = false;
        }
        move();
        collision();
        if(lifetime.poll() == 0){
            World world = getWorld();
            world.removeObject(light);
            world.removeObject(this);
        }
    }
}