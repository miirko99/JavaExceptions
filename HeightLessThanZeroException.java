public class HeightLessThanZeroException extends Exception {
    public HeightLessThanZeroException(){
        super("Visina mora biti veca od nule");    }
    public HeightLessThanZeroException(String msg){
        super("Cusom"+msg);
    }
}
