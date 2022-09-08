public class HeightComparator {
    private HeightValidator valid;
    HeightComparator(){
        valid=new HeightValidator();
    }
    HeightComparator(double low, double high){
        valid=new HeightValidator(low, high);
    }

    public boolean isGrather(double a,double b) throws HeightTooBigException, HeightLessThanZeroException {
        valid.validateHeight(a);
        valid.validateHeight(b);
        return a>b;
    }
    public boolean isLess(double a,double b) throws HeightTooBigException, HeightLessThanZeroException {
        valid.validateHeight(a);
        valid.validateHeight(b);
        return a<b;
    }
}
