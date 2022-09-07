import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class MainTest {
    static Logger LOGGER;
    @BeforeAll
    public static void setup(){
        LOGGER = Logger.getLogger(MainTest.class.getName());
        LOGGER.info("Logger Name: "+LOGGER.getName());
        LOGGER.log(Level.INFO, "Testiranje je pocelo");

    }
    @AfterAll
    public static void end(){
        LOGGER.log(Level.INFO, "Testiranje se zavrsilo");
    }
    @AfterEach
    public void each(){
        LOGGER.log(Level.INFO, "Ovo se stampa posle svakog testa");
    }
    @Test
    public void negativethrowsHLTZE(){
        Main m=new Main();
        assertThrows(HeightLessThanZeroException.class,()->{m.validateHeight(-1);});
    }
    @Test
    public void zerothrowsHLTZE(){
        Main m=new Main();
        assertThrows(HeightLessThanZeroException.class,()->{m.validateHeight(0);});
    }
    @Test
    public void bigNegativethrowsHLTZE(){
        Main m=new Main();
        assertThrows(HeightLessThanZeroException.class,()->{m.validateHeight(-1000);});
    }
    @Test
    public void positive1ReturnsNull() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=new Main();
        assertEquals(true,m.validateHeight(1));
    }
    @Test
    public void positive2ReturnsNull() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=new Main();
        assertEquals(true,m.validateHeight(299));
    }
    @Test
    public void positive3ReturnsNull() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=new Main();
        assertEquals(true,m.validateHeight(150));
    }
    @Test
    public void bigPositiveThrowsHTBE(){
        Main m=new Main();
        assertThrows(HeightTooBigException.class,()->{m.validateHeight(301);});
    }
    @Test
    public void reallybigPositiveThrowsHTBE(){
        Main m=new Main();
        assertThrows(HeightTooBigException.class,()->{m.validateHeight(10001);});
    }

}