public class HeightValidator {
    private double low,high;
    HeightValidator(){
        low=0;
        high=215;
    }
    HeightValidator(double low, double high){
        this.low=low;
        this.high=high;
    }
    public boolean checkHeights(double[] heights) throws HeightTooBigException, HeightLessThanLowException {
        for (double a:heights) {
            validateHeight(a);
        }
        return true;
    }
    public boolean validateHeight(double Height) throws HeightLessThanLowException, HeightTooBigException {
        if(Height<low){
            throw new HeightLessThanLowException(Height,low);
        }
        if(Height>high){
            throw new HeightTooBigException(Height,high);
        }
        return true;
    }
}
