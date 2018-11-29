/**
 * class AbsQuo:
 * -A Quotient; for denominator polls, return the numerator
 * 
 * @author Tyler Bakeman
 * @version 1.02 11/28/18
 **/
public class AbsQuo extends Quo{
    private int count = 0;
    public AbsQuo(){
        super();
    }
    public AbsQuo(int numer){
        super(numer);
    }
    public AbsQuo(int numer,int denom){
        super(numer,denom);
    }
    public AbsQuo(double decimal){
        super(decimal);
    }
    public AbsQuo(double decimal,int precision){
        super(decimal,precision);
    }
    
    
    public int poll(){
        count = (count + 1) % Math.abs(denom);
        if(count == 0)
            return numer;
        return 0;
    }
}
