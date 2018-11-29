/**
 * A helper Class
 * @author Tyler Bakeman
 */public class IncQuo extends Quo{
    private int count = 0;
    public IncQuo(int numer){
        super(numer);
    }
    public IncQuo(int numer,int denom){
        super(numer,denom);
    }
    
    
    public int poll(){
        int d = Math.abs(denom);
        count = (count + 1) % d;
        if((d - count - 1) < (numer % d))
            return numer / denom + Integer.signum(numer) * Integer.signum(denom);
        return numer/denom;
    }
}
