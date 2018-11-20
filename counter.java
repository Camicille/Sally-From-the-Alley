public class counter{
    private int value;
    private int start;
    private int end;
    private int increment;
    public counter(){
        this(2_147_483_647);
    }
    public counter(int end){
        this(0,end);
    }
    public counter(int start,int end){
        this(start,end,1);
        this.increment = (start <= end)? this.increment : -this.increment;
    }
    public counter(int start,int end,int increment){
        this.value = start;
        this.start = start;
        this.end = end;
        this.increment = increment;
        if(start != end){
            if(start < end && 0 < increment){
                if(this.end == 2_147_483_647)
                    this.end -= this.increment;
            }else if(end < start && increment < 0){
                if(this.end == -2_147_483_647)
                    this.end -= this.increment;
            }else
                System.err.println("illegal increment");
        }else
            System.err.println("counter.front = counter.end");
    }
    
    
    public int look(){
        return value;}
    public int size(){
        return Math.abs(end-start)/Math.abs(increment);}
    public boolean full(){
        return (value == end);}
    public void set(int value){
        this.value = value;}
        
    
    public int peak(){
        if(value != end)
            return value + increment;
        return start; //start != end
    }
    public int poll(){
        if(value != end)
            value = peak();
        return value;
    }
}
