import greenfoot.*;
/**
 * class Light: for LIT objects
 * 
 * @author Tyler Bakeman
 * @version 1.02 11/28/18
 **/
public class Light extends Objex{
    public Light(int size){
        GreenfootImage img = new GreenfootImage(size,size);
        img.setColor(new Color(255,255,0,100));
        img.fillOval(0,0,size-1,size-1);
        setImage(img);
    }
}
