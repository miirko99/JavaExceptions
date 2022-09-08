public class HeightComparator {
    private HeightValidator valid;
    HeightComparator(){
        valid=new HeightValidator();
    }
    HeightComparator(double low, double high){
        valid=new HeightValidator(low, high);
    }
    HeightComparator(HeightValidator HV){
        valid=HV;
    }

    public boolean isGrather(double a, double b) throws HeightTooBigException, HeightLessThanLowException {
        valid.validateHeight(a);
        valid.validateHeight(b);
        return a>b;
    }
    public boolean isLess(double a, double b) throws HeightTooBigException, HeightLessThanLowException {
        valid.validateHeight(a);
        valid.validateHeight(b);
        return a<b;
    }
    public boolean isEqual(double a, double b) throws HeightTooBigException, HeightLessThanLowException {
        valid.validateHeight(a);
        valid.validateHeight(b);
        return a==b;
    }
}
