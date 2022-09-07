public class Main {

    public static void main(String[] args){
        double[] heights=new double[3];


        HeightValidator HV=new HeightValidator();
        HV.fillHeights();
        try {
            HV.checkHeights();
        } catch (HeightLessThanZeroException | HeightTooBigException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}