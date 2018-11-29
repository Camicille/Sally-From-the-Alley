/**
 * class counter:
 * - counts on an interval [a,b], tracks a value c, with an increment i
 * 
 * @author Tyler Bakeman
 * @version 1.02 11/28/18
 **/
public class counter{
    protected int value;
    protected int start;
    protected int end;
    protected int increment;
    private byte fetched = 0;
    public counter(){
        this(2_147_483_647);
    }
    public counter(int end){
        this(0,end);
    }
    public counter(int start,int end){
        this(start,end,Integer.signum(end-start));
    }
    public counter(int start,int end,int increment){
        this.value = start;
        this.start = start;
        this.end = end;
        this.increment = increment;
        if(start != end){
            if(start < end && 0 < increment){
                if(this.end == 2_147_483_647) this.end -= this.increment;
            }else if(end < start && increment < 0){
                if(this.end == -2_147_483_647) this.end -= this.increment;
            }else{
                System.err.println("illegal increment: Exit(1)");
                System.exit(1);
            }
        }else
            System.err.println("counter.front = counter.end = " + end);
    }
    
    
    @Override public String toString(){
        return ("" + value);}
    public int look(){
        return value;}
    public int size(){
        return Math.abs(end-start)/Math.abs(increment) + fetched;}
    public boolean empty(){
        return ((value == start)&&(0<increment)) || ((value == end)&&(increment<0));}
    public boolean full(){
        return ((value == end)&&(0<increment)) || ((value == start)&&(increment<0));}
    public void set(int value){
        this.value = value;}
    public void reset(){
        this.value = start;}
        
    
    public void reverse(){
        increment = -increment;
        swap(start,end);
    }
    private void swap(int x,int y){
        int temp = x;
        x = y;
        y = temp;
    }
        
    
    public int show(){
        return value;}
    public int peak(){
        if(value != end) return value + increment;
        return start; //start != end
    }
    public int fetch(){
        if(fetched == 0) fetched = 1;
        int _value = value;
        if(value != end) value = peak();
        return _value;
    }
    public int poll(){
        if(value != end) value = peak();
        return value;
    }
}
