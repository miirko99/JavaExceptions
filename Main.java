public class Main {

    public static void main(String[] args){
        double[] heights=new double[]{180,185,192};
        //heights[3]=216; //unchecked exception index out of bounds


        HeightComparator HC1=new HeightComparator(100,200);
        HeightComparator HC=new HeightComparator();
        try {
            //heights[3]=216;//catched unchecked exception
            HC.isGrather(1,623);
            HC.isGrather(-1,2);
            HC.isGrather(0,2);
            HC.isGrather(0,2);
            HC.isLess(1,623);
            HC.isLess(-1,2);
            HC.isLess(0,2);
            HC.isLess(-12341,2);
            System.out.println(HC.isLess(1,2));
            HC1.isGrather(101,623);
            HC1.isGrather(50,150);
            HC1.isGrather(100,199);
            HC1.isGrather(101,102);
            HC1.isLess(101,623);
            HC1.isLess(50,150);
            HC1.isLess(-1,160);
            HC1.isLess(-12341,243);
        } catch (HeightLessThanLowException | HeightTooBigException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        //HC.isGrather(2,3);checked
    }
}