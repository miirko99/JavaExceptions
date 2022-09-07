public class HeightLessThanZeroException extends Exception {
    public HeightLessThanZeroException(){
        super("Visina mora biti veca od nule");    }
    HeightLessThanZeroException(double H){
        super("Visina mora biti veca od 0, vas unos: "+H);
    }
    public HeightLessThanZeroException(String msg){
        super("Cusom"+msg);
    }
}
