import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platforms extends Sprite
{
    /**
     * Witch will land on different types of platforms
     */
    public void act() 
    {
        checkVertical();
    } 
    public void checkVertical()
    {
        Actor witch = getOneObjectAtOffset(0,11, Witch.class);
        if (witch == null)
        {
            //
        }
        else
        {
            setYVelocity(0.0);
        }
    }
    public void moveToContactVertical(Actor target)
    {   
        int h2 = (target.getImage().getHeight() + target.getImage().getHeight()) / 2;
        int newY = 0;
            if (target.getY() > getY()) // test up or down
            {
                newY = target.getY() - h2; // up
        }
        else
        {
            newY = target.getY() + h2; // down
        }
        setLocation(getX(), newY);
    }
}
