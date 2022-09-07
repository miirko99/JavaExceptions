public class HeightValidator {
    private double low,high;
    HeightValidator(){
        this.low=0;
        this.high=215;
    }
    HeightValidator(double low, double high){
        this.low=low;
        this.high=high;
    }
    public boolean checkHeights(double[] heights) throws HeightTooBigException, HeightLessThanZeroException {
        for (double a:heights) {
            this.validateHeight(a);
        }
        return true;
    }
    public boolean validateHeight(double Height) throws HeightLessThanZeroException, HeightTooBigException {
        if(Height<=this.low){
            throw new HeightLessThanZeroException(Height);
        }
        if(Height>this.high){
            throw new HeightTooBigException(Height);
        }
        return true;
    }
}
