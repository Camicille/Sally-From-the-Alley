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
    private counter lifetime = new counter(100,0);
    
    /**
     * Constructor for Fireball
     * 
     * @param speed  the spped the fireball will fire at
     */
    public Fireball(int speed){
        this.speed = speed;
        getImage().scale(16, 16);
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
    }
    
    public void act(){
        move();
        collision();
        if(lifetime.poll() == 0){
            World world = getWorld();
            world.removeObject(this);
        }
    }
}