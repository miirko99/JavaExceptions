public class HeightLessThanLowException extends Exception {
    public HeightLessThanLowException(){
        super("Visina mora biti veca od low");    }
    HeightLessThanLowException(double H, double L){
        super("Visina mora biti veca od "+L+", vas unos: "+H);
    }
    public HeightLessThanLowException(String msg){
        super("Cusom"+msg);
    }
}
