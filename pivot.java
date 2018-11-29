/**
 * class pivot:
 * - counts on an interval [a,b], tracks a value c, with an increment i,
 *   then does it backwards... then does it forewards... then backwards... etc
 *   
 * @author Tyler Bakeman
 * @version 1.02 11/28/18
 **/
public class pivot extends counter {
    public pivot(){
        super();
        increment = -increment;
    }
    public pivot(int end){
        super(end);
        increment = -increment;
    }
    public pivot(int start,int end){
        super(start,end);
        increment = -increment;
    }
    public pivot(int start,int end,int increment){
        super(start,end,increment);
        increment = -increment;
        if(end % increment != 0){
            System.err.println("polar.end not congruent to polar.increment: Exit(1)");
            System.exit(1);
        }
    }
    
    
    @Override public int size(){
        return super.size() + 1;}
    @Override public boolean empty(){
        return value == end;}
    @Override public boolean full(){
        return value == start;}
        
    
    @Override public int peak(){
        return value + increment;
    }
    public int fetch(){
        int _value = value;
        if(value == start || value == end) increment = -increment;
        value = peak();
        return _value;
    }
    public int poll(){
        if(value == start || value == end) increment = -increment;
        value = peak();
        return value;
    }
}
