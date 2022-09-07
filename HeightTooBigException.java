public class HeightTooBigException extends Exception {
    public HeightTooBigException(){
        super("Prevelika visina");    }
    HeightTooBigException(double H){
        super("prevelika visina, vas unos: "+H);
    }
    public HeightTooBigException(String msg){
        super("custom"+msg);
    }
}
