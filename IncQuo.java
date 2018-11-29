/**
 * class IncQuo:
 * -A Quotient; for denominator polls, return the value of the numerator,
 *  but distributed evenly among each poll
 * 
 * @author Tyler Bakeman
 * @version 1.02 11/28/18
 **/
public class IncQuo extends Quo{
    private int count = 0;
    public IncQuo(){
        super();
    }
    public IncQuo(int numer){
        super(numer);
    }
    public IncQuo(int numer,int denom){
        super(numer,denom);
    }
    public IncQuo(double decimal){
        super(decimal);
    }
    public IncQuo(double decimal,int precision){
        super(decimal,precision);
    }
    
    
    public int poll(){
        int d = Math.abs(denom);
        count = (count + 1) % d;
        if((d - count - 1) < (numer % d))
            return numer / denom + Integer.signum(numer) * Integer.signum(denom);
        return numer/denom;
    }
}
