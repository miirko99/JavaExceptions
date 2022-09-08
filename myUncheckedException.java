public class myUncheckedException extends RuntimeException{
    myUncheckedException(){
        super("Pogresan index!!");
    };
    myUncheckedException(String msg){
        super("Custom Exception says: "+msg);
    }
}
