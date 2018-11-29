import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object that displays an image representing the player's score.
 * 
 * @author Chandler Clarke
 * @version Alpha 1.0
 */
public class ScoreCounter extends GameMaster
{
    private int score;
    /**
     * Act - do whatever the ScoreCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateScore();
        showScore();
    }    
    
    private void updateScore(){
        GameWorld world = (GameWorld) getWorld();
        score = world.getScore();
    }
    private void showScore(){
        GameWorld world = (GameWorld) getWorld();
        world.showText("Score" + score, world.player.getX()- 200, 20);
    }
}
