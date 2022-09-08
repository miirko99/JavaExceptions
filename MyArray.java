public class MyArray {
    private double[] arr;
    MyArray(){}
    MyArray(double[] arr){
        this.arr=arr;
    }
    void insert(int index,double value){
        try{
            arr[index]=value;
        }catch(IndexOutOfBoundsException e){
            throw new myUncheckedException();
        }
    }
}
