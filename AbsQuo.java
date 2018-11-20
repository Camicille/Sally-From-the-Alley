public class AbsQuo extends Quo{
    private int count = 0;
    public AbsQuo(int numer){
        super(numer);
    }
    public AbsQuo(int numer,int denom){
        super(numer,denom);
    }
    
    
    public int poll(){
        count = (count + 1) % Math.abs(denom);
        if(count == 0)
            return numer;
        return 0;
    }
}
