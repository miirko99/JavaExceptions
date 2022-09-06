public class Main {
    public static void validateHeight(double Height) throws HeightLessThanZeroException, HeightTooBigException {
        if(Height<=0){
            throw new HeightLessThanZeroException();
        }
        if(Height>300){
            throw new HeightTooBigException();
        }

    }
    public static void main(String[] args){
        System.out.println("Hello world!");
        double[] heights=new double[3];
        heights[0]=3456;
        heights[1]=-3;
        heights[2]=23;
        heights[3]=345;
        try {
            validateHeight(heights[0]);
            validateHeight(heights[1]);
            validateHeight(heights[2]);
            heights[3]=345;//unchecked

        } catch (HeightLessThanZeroException | HeightTooBigException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        //validateHeight(heights[0]);
    }
}