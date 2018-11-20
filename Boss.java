import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A boss that moves in a set pattern
 * To-do more intricate pattern  
 * @author (Philip Jepkes) 
 * @version (V1.0)
 */
public class Boss extends Enemy
{
  private int timecount=0; // timer for first stages
   private int othertimer;// timer for last stages
    private boolean blah = false; //switchs values at edge
    private int life =900; //starting life
    private boolean canDmg =false; //check at health points so doesnt deal damage when teleporting
    //private GreenfootImage 
    public Boss()
    {
        setImage("tux.png");
        //MyWorld w =(MyWorld)getWorld();
        //w.Boss = true
    }
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        alterTime();
        canIdmg();
        pattern();
        //animation();
        //dealDmg();
        //takeDmg();
    }  
    private void alterTime(){
        timecount++; 
        if (timecount > 300){timecount=0;}
        othertimer++;
        if(othertimer >200){othertimer =0;}
        
}
   private void canIdmg()
   {
       if (life<=3000 && life>2500|| life <2000 && life > 1500 || life<1000 && life>500)
       {
           canDmg= false;
       }
       else if (life <2500 &&life >2000 ||life <1500 && life >1000 || life <500 && life >0 )
       {
           canDmg =true;
       }
    }
    private void pattern(){ 
       if (blah == false && life <2500 &&life >2000 && getY()==186)
    {
        setLocation(getX()-5,getY());
    }
    if (blah == false && life <1500 && life >1000 && getY()==186){
        setLocation(getX()-7,getY());
    }
    if (blah == false && life <500 && life >0 && getY()==186){
        setLocation(getX()-12,getY());
    }
    if (blah == true && life <2500 &&life >2000 && getY()==186)
    {
      setLocation(getX()+5,getY());
    }  
    if (blah == true && life <1500 && life >1000 && getY()==186){
        setLocation(getX()+7,getY());
    }
    if (blah == true && life <500 && life >0 && getY()==186){
        setLocation(getX()+12,getY());
    }
       if (getX() <=0){
           blah = true;
        }
        
       if (getX() >=599){
           blah = false;
        } 
        
     
     if (life<=3000 && life>2500 && timecount >0 && timecount <100 || life <2000 && life > 1500 && timecount >0 && timecount <100  ) {
         setLocation(54,186);
        }
     else if (life<=3000 && life>2500 &&  timecount >=100 && timecount <200 || life <2000 && life > 1500 &&  timecount >=100 && timecount <200 ){
         setLocation(544,186);
        }
     else if (life<=3000 && life>2500  && timecount >=200 && timecount <300 || life <2000 && life > 1500  && timecount >=200 &&timecount <300 ){
         setLocation(300,120);
        }
     if (life<=1000 && life>500 && othertimer >0 && othertimer <50  ) {
         setLocation(54,186);
        }
     else if (life<=1000 && life>500 &&  othertimer >50 && othertimer <100 ){
         setLocation(544,186);
        }
     else if (life<=1000 && life>500  && othertimer >100 && othertimer <150 ){
         setLocation(300,120);
        }
     else if (life<=1000 && life>500  && othertimer>150 ){
         setLocation(300,275);
        }
         }
}
