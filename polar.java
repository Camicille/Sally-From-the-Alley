/**
 * class counter:
 * - counts on an interval [a,b], tracks a value c, with an increment i
 *   then repeats. Similar to counting on the cercumference of a circle
 * 
 * @author Tyler Bakeman
 * @version 1.02 11/28/18
 **/
public class polar extends counter {
    public polar(){
        super();
    }
    public polar(int end){
        super(end);
    }
    public polar(int start,int end){
        super(start,end);
    }
    public polar(int start,int end,int increment){
        super(start,end,increment);
        if(end % increment != 0){
            System.err.println("polar.end not congruent to polar.increment: Exit(1)");
            System.exit(1);
        }
    }
    
    
    @Override public int size(){
        return super.size() + 1;}
    @Override public boolean empty(){
        return ((value == start)&&(0<increment)) || ((value == end+1)&&(increment<0));}
    @Override public boolean full(){
        return ((value == end-1)&&(0<increment)) || ((value == start)&&(increment<0));}
        
    
    @Override public int fetch(){
        int _value = value;
        value = this.peak();
        return _value;
    }
    @Override public int poll(){
        value = this.peak();
        return value;
    }
}
