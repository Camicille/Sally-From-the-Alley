import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main game world.
 * 
 * @author Chandler Clarke
 * @version Alpha 1.0
 */
public class GameWorld extends World
{
    public static final int WORLD_WIDTH = 600;
    public static final int WORLD_HEIGHT = 400;
    public Witch player;
    /**
     * Constructor for objects of class GameWorld.
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1, false); 
    }
}
