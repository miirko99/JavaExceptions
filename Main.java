public class Main {

    public static void main(String[] args){
        double[] heights=new double[3];


        HeightComparator HC=new HeightComparator();
        try {
            HC.isGrather(1,2);
        } catch (HeightLessThanZeroException | HeightTooBigException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}