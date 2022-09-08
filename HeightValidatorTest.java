import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class HeightValidatorTest {
    static Logger LOGGER;
    private static HeightValidator HV;
    @BeforeAll
    public static void setup(){
        LOGGER = Logger.getLogger(HeightValidatorTest.class.getName());
        LOGGER.info("Logger Name: "+LOGGER.getName());
        LOGGER.log(Level.INFO, "Testiranje je pocelo");
        HV=new HeightValidator(100,215);
    }
    @AfterAll
    public static void end(){
        LOGGER.log(Level.INFO, "Testiranje se zavrsilo");
    }
    @Test
    void LessThanLowSouldThrowHLTLE(){
        assertThrows(HeightLessThanLowException.class,()->{HV.validateHeight(99.99);});
        assertThrows(HeightLessThanLowException.class,()->{HV.validateHeight(99);});
        assertThrows(HeightLessThanLowException.class,()->{HV.validateHeight(0);});
        assertThrows(HeightLessThanLowException.class,()->{HV.validateHeight(-123);});
        LOGGER.log(Level.INFO, "HeightLessThanLow working correct");
    }
    @Test
    void GratherThanHighSouldThrowHTBE(){
        assertThrows(HeightTooBigException.class,()->{HV.validateHeight(215.00000001);});
        assertThrows(HeightTooBigException.class,()->{HV.validateHeight(216);});
        assertThrows(HeightTooBigException.class,()->{HV.validateHeight(2000);});
        LOGGER.log(Level.INFO, "HeightTooBig working correct");
    }
    @Test
    void valiShouldReturnTrue() throws HeightTooBigException,HeightLessThanLowException{
        assertTrue(HV.validateHeight(100));
        assertTrue(HV.validateHeight(178));
        assertTrue(HV.validateHeight(215));
        LOGGER.log(Level.INFO, "No exception working correct");
    }
    @Test
    void checkHeightsTooBig(){
        assertThrows(HeightTooBigException.class,()->{HV.checkHeights(new double[]{123,432,150});});
        assertThrows(HeightTooBigException.class,()->{HV.checkHeights(new double[]{215.0001,99,150});});
        assertThrows(HeightTooBigException.class,()->{HV.checkHeights(new double[]{215,150,250});});
        LOGGER.log(Level.INFO, "CheckHeights TooBig exception working correct");
    }
    @Test
    void checkHeightsTooLow(){
        assertThrows(HeightLessThanLowException.class,()->{HV.checkHeights(new double[]{99.99,432,150});});
        assertThrows(HeightLessThanLowException.class,()->{HV.checkHeights(new double[]{182,150,45});});
        assertThrows(HeightLessThanLowException.class,()->{HV.checkHeights(new double[]{150,75,250});});
        LOGGER.log(Level.INFO, "CheckHeights TooLow exception working correct");
    }
    @Test
    void checkHeightsTrue() throws HeightTooBigException, HeightLessThanLowException {
        assertTrue(HV.checkHeights(new double[]{100,150,215}));
        LOGGER.log(Level.INFO, "CheckHeights no exception working correct");
    }
}