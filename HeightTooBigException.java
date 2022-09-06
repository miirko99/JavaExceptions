public class HeightTooBigException extends Exception {
    public HeightTooBigException(){
        super("Prevelika visina");    }
    public HeightTooBigException(String msg){
        super("custom"+msg);
    }
}
