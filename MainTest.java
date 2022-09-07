import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        HeightComparator HV=new HeightComparator();
        assertThrows(HeightLessThanZeroException.class,()->{HV.validateHeight(-1);});
    }
    @Test
    public void zerothrowsHLTZE(){
        HeightComparator HV=new HeightComparator();
        assertThrows(HeightLessThanZeroException.class,()->{HV.validateHeight(0);});
    }
    @Test
    public void bigNegativethrowsHLTZE(){
        HeightComparator HV=new HeightComparator();
        assertThrows(HeightLessThanZeroException.class,()->{HV.validateHeight(-1000);});
    }
    @Test
    public void positive1ReturnsTrue() throws HeightTooBigException, HeightLessThanZeroException {
        HeightComparator HV=new HeightComparator();
        assertEquals(true,HV.validateHeight(1));
    }
    @Test
    public void positive2ReturnsTrue() throws HeightTooBigException, HeightLessThanZeroException {
        HeightComparator HV=new HeightComparator();
        assertEquals(true,HV.validateHeight(299));
    }
    @Test
    public void positive3ReturnsTrue() throws HeightTooBigException, HeightLessThanZeroException {
        HeightComparator HV=new HeightComparator();
        assertEquals(true,HV.validateHeight(150));
    }
    @Test
    public void bigPositiveThrowsHTBE(){
        HeightComparator HV=new HeightComparator();
        assertThrows(HeightTooBigException.class,()->{HV.validateHeight(301);});
    }
    @Test
    public void reallybigPositiveThrowsHTBE(){
        HeightComparator HV=new HeightComparator();
        assertThrows(HeightTooBigException.class,()->{HV.validateHeight(10001);});
    }

}