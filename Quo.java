public class Quo{
    public int numer;
    public int denom;
    public Quo(int numer){
        this(numer,1);
    }
    public Quo(int numer,int denom){
        this.numer = numer;
        this.denom = denom;
        if(denom == 0)
            System.err.println("UNDEF : Quo.denom = 0");
    }
    
    
    @Override public String toString(){
        return (numer + "/" + denom);}
    public double toDouble(){
        return (double)numer/denom;}
    public void set(int n,int d){
        set(new Quo(n,d));}
    public void set(Quo that){
        this.numer = that.numer;
        this.denom = that.denom;
        if(denom == 0)
            System.err.println("UNDEF : Quo.denom = 0");
    }
        
    
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
    
    
    public Quo add(int n,int d){
        return add(new Quo(n,d));}
    public Quo add(Quo that){
        Quo temp;
        this.reduce();
        that.reduce();
        if(this.denom == that.denom)
            temp = new Quo(this.numer + that.numer, this.denom);
        else
            temp = new Quo(this.numer*that.denom + that.numer*this.denom, this.denom*that.denom);
        this.set(temp);
        return this;
    }
    public Quo mul(int n,int d){
        return mul(new Quo(n,d));}
    public Quo mul(Quo that){
        Quo temp;
        this.reduce();
        that.reduce();
        temp = new Quo(this.numer*that.numer, this.denom*that.denom);
        this.set(temp);
        return this;
    }
}
