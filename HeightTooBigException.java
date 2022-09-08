public class HeightTooBigException extends Exception {
    public HeightTooBigException(){
        super("Prevelika visina");    }
    HeightTooBigException(double H, double h){
        super("Visina mora biti manja od "+h+", vas unos: "+H);
    }
    public HeightTooBigException(String msg){
        super("custom"+msg);
    }
}
