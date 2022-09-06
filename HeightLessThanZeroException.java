public class HeightLessThanZeroException extends Exception {
    public HeightLessThanZeroException(){
        super("Visina morabiti veca od nule");    }
    public HeightLessThanZeroException(String msg){
        super("Cusom"+msg);
    }
}
