/**
 * class Quo:
 * -A Quotient; more precise, and can be converted to/from a double
 * 
 * @author Tyler Bakeman
 * @version 1.02 11/28/18
 **/
public class Quo{
    public int numer;
    public int denom;
    private static int precision = 2;
    public Quo(){
        this(0,1);
    }
    public Quo(int numer){
        this(numer,1);
    }
    public Quo(int numer,int denom){
        this.numer = numer;
        this.denom = denom;
        if(denom == 0) System.err.println("UNDEF : Quo.denom = 0");
    }
    public Quo(double decimal){
        this(decimal,precision);
    }
    public Quo(double decimal,int _precision){
        int whole = (int)decimal;
        decimal -= whole;
        int denom = (int)Math.pow(10,_precision);
        int numer = (int)((decimal * denom) + 0.5);
        this.numer = numer;
        this.denom = denom;
    }
    
    
    @Override public String toString(){
        return (numer + "/" + denom);}
    public int toInt(){
        return numer/denom;}
    public double toDouble(){
        return (double)numer/denom;}
    public static void setPrecision(int _precision){
        if(precision <= 8)
            if(precision >= 0) precision = _precision;
            else System.err.println("decimal Quo.precision < 0");
        else System.err.println("decimal Quo.precision > 8");
    }
        
    
    public void flip(){
        int temp = numer; numer = denom; denom = temp;}
    public void reduce(){
        if(numer == 0){
            denom = 1;
        } else {
            int sign = (Integer.signum(numer) != Integer.signum(denom))? -1 : 1;
            numer = Math.abs(numer);
            denom = Math.abs(denom);
            int factor = 1;
            int max = Math.max(numer,denom);
            for(int f = 1; f <= max; f++)
                if((numer % f == 0) && (denom % f == 0))
                    factor = f;
            numer /= factor;
            denom /= factor;
            numer *= sign;
        }
    }
    
    
    public final Quo sum(Quo a,Quo b){
        Quo temp;
        a.reduce();
        b.reduce();
        if(a.denom == b.denom)
            temp = new Quo(a.numer + b.numer, a.denom);
        else
            temp = new Quo(a.numer*b.denom + b.numer*a.denom, a.denom*b.denom);
        return temp;
    }
    public Quo add(int n,int d){
        return add(new Quo(n,d));}
    public Quo add(Quo that){
        Quo temp = sum(this,that);
        this.numer = temp.numer;
        this.denom = temp.denom;
        return temp;
    }
    public final Quo pro(Quo a,Quo b){
        a.reduce();
        b.reduce();
        return new Quo(a.numer*b.numer, a.denom*b.denom);
    }
    public Quo mul(int n,int d){
        return mul(new Quo(n,d));}
    public Quo mul(Quo that){
        Quo temp = pro(this,that);
        this.numer = temp.numer;
        this.denom = temp.denom;
        return this;
    }
    public final Quo pow(Quo a,int e){
        if(e < 0) flip();
        else if(e == 0) return new Quo(1);
        return new Quo(a.numer*a.numer,a.denom*a.denom);
    }
}
