public class HeightValidator {
    private double[] heights=new double[]{1,1,1};
    public HeightValidator(){
        this.fillHeights();
        //this.validateHeight(3);
    };
    public HeightValidator(double[] heights){
        this.heights=heights;
    }
    public void fillHeights(){
        this.heights[0]=3456;
        this.heights[1]=-3;
        this.heights[2]=23;
        //this.heights[3]=345;
    }
    public boolean checkHeights() throws HeightTooBigException, HeightLessThanZeroException {
        //validateHeight(heights[3]);//Index out of bounds unchecked
        this.validateHeight(this.heights[0]);//checked HeightTooBigException
        this.validateHeight(this.heights[1]);//checked HeightLessThanZeroException
        this.validateHeight(this.heights[2]);//checked but not throw any
        return true;
    }
    public boolean validateHeight(double Height) throws HeightLessThanZeroException, HeightTooBigException {
        if(Height<=0){
            throw new HeightLessThanZeroException();
        }
        if(Height>300){
            throw new HeightTooBigException();
        }
        return true;
    }
}
