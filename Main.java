public class Main {
    public static void fillHeights(double[] heights) throws HeightTooBigException, HeightLessThanZeroException {
        heights[0]=3456;
        heights[1]=-3;
        heights[2]=23;
        heights[3]=345;//Index out of bounds unchecked
        checkHeights(heights);//checked HeightTooBigException, HeightLessThanZeroException
    }
    public static void checkHeights(double[] heights) throws HeightTooBigException, HeightLessThanZeroException {
        validateHeight(heights[3]);//Index out of bounds unchecked
        validateHeight(heights[0]);//checked HeightTooBigException
        validateHeight(heights[1]);//checked HeightLessThanZeroException
        validateHeight(heights[2]);//checked but not throw any
    }
    public static boolean validateHeight(double Height) throws HeightLessThanZeroException, HeightTooBigException {
        if(Height<=0){
            throw new HeightLessThanZeroException();
        }
        if(Height>300){
            throw new HeightTooBigException();
        }
        return true;
    }
    public static void main(String[] args){
        double[] heights=new double[3];
        heights[3]=345;//Index out of bounds unchecked
        try {
            fillHeights(heights);
        } catch (HeightLessThanZeroException | HeightTooBigException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        //validateHeight(heights[0]);
    }
}