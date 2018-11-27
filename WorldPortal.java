import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * A portal that changes the current world on intersect with player class.
 * 
 * @author Chandler Clarke (original by Ed Parrish)
 * @version 1.01 11/27/18
 */
public class WorldPortal extends Sprite
{
    private String world;

    public WorldPortal(String map){
        world = map;
    }

    /**
     * Act - do whatever the WorldPortal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(Witch.class))
        {
            GameWorld w = (GameWorld)getWorld();
            w.readMap(world);
        }
    }
}
