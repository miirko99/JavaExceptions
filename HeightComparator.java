public class HeightComparator {
    private HeightValidator valid;
    HeightComparator(){
        this.valid=new HeightValidator();
    }
    HeightComparator(double low, double high){
        this.valid=new HeightValidator(low, high);
    }

    public boolean isGrather(double a,double b) throws HeightTooBigException, HeightLessThanZeroException {
        this.valid.validateHeight(a);
        this.valid.validateHeight(b);
        return a>b;
    }
    public boolean isLess(double a,double b) throws HeightTooBigException, HeightLessThanZeroException {
        this.valid.validateHeight(a);
        this.valid.validateHeight(b);
        return a<b;
    }


}
