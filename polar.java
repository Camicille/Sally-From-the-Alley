public class polar extends counter {
    private int loop = 0;
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
        if(end % increment != 0)
            System.err.println("polar.end not congruent to polar.increment");
    }
    
    
    @Override public int size(){
        return super.size() + 1;}
    
    
    @Override public int poll(){
        if(this.full())
            loop = (loop + 1) % 2_147_483_647;
        int value = this.peak();
        this.set(value);
        return value;
    }
}
