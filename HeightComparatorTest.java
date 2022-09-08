import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HeightComparatorTest {
    static Logger LOGGER;
    static HeightValidator HV;
    static HeightComparator HC;
    @BeforeAll
    public static void setup() throws HeightTooBigException, HeightLessThanLowException {
        LOGGER = Logger.getLogger(HeightComparatorTest.class.getName());
        LOGGER.info("Logger Name: "+LOGGER.getName());
        LOGGER.log(Level.INFO, "Testiranje sa mockom je pocelo");
        HV=mock(HeightValidator.class);
        when(HV.validateHeight(10)).thenThrow(HeightLessThanLowException.class);
        when(HV.validateHeight(50)).thenThrow(HeightLessThanLowException.class);
        when(HV.validateHeight(99)).thenThrow(HeightLessThanLowException.class);
        when(HV.validateHeight(99.99)).thenThrow(HeightLessThanLowException.class);
        when(HV.validateHeight(100)).thenReturn(true);
        when(HV.validateHeight(150)).thenReturn(true);
        when(HV.validateHeight(182)).thenReturn(true);
        when(HV.validateHeight(215)).thenReturn(true);
        when(HV.validateHeight(215.01)).thenThrow(HeightTooBigException.class);
        when(HV.validateHeight(250)).thenThrow(HeightTooBigException.class);
        HC=new HeightComparator(HV);

    }
    @AfterAll
    public static void end(){
        LOGGER.log(Level.INFO, "Svi testovi su se zavrsili");
    }
    @AfterEach
    public void each(){
        LOGGER.log(Level.INFO, "Test zavrsen");
    }
    @Test
    void comparethrowsHLTLE() throws HeightLessThanLowException,HeightTooBigException{
        assertThrows(HeightLessThanLowException.class,()->{HC.isLess(10,50);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isLess(100,50);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isLess(99.99,250);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isLess(99,250);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isGrather(10,50);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isGrather(100,50);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isGrather(99.99,250);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isGrather(99,250);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isEqual(10,50);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isEqual(100,50);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isEqual(99.99,250);});
        assertThrows(HeightLessThanLowException.class,()->{HC.isEqual(99,250);});
        LOGGER.log(Level.INFO, "HLTLE radi");
    }
    @Test
    void comparethrowsHTBE() throws HeightLessThanLowException,HeightTooBigException{
        assertThrows(HeightTooBigException.class,()->{HC.isLess(215.01,50);});
        assertThrows(HeightTooBigException.class,()->{HC.isLess(250,50);});
        assertThrows(HeightTooBigException.class,()->{HC.isLess(250,250);});
        assertThrows(HeightTooBigException.class,()->{HC.isLess(182,215.01);});
        assertThrows(HeightTooBigException.class,()->{HC.isGrather(215.01,50);});
        assertThrows(HeightTooBigException.class,()->{HC.isGrather(250,50);});
        assertThrows(HeightTooBigException.class,()->{HC.isGrather(150,250);});
        assertThrows(HeightTooBigException.class,()->{HC.isGrather(182,215.01);});
        assertThrows(HeightTooBigException.class,()->{HC.isEqual(215.01,50);});
        assertThrows(HeightTooBigException.class,()->{HC.isEqual(250,50);});
        assertThrows(HeightTooBigException.class,()->{HC.isEqual(150,250);});
        assertThrows(HeightTooBigException.class,()->{HC.isEqual(182,215.01);});
        LOGGER.log(Level.INFO, "HTBE radi");
    }
    @Test
    void compareReturnsTrue() throws HeightTooBigException, HeightLessThanLowException {
        assertTrue(HC.isLess(100,150));
        assertTrue(HC.isLess(150,182));
        assertTrue(HC.isLess(150,215));
        assertTrue(HC.isGrather(150,100));
        assertTrue(HC.isGrather(182,100));
        assertTrue(HC.isGrather(215,182));
        assertTrue(HC.isEqual(215,215));
        assertTrue(HC.isEqual(100,100));
        assertTrue(HC.isEqual(182,182));
        LOGGER.log(Level.INFO, "metode vraca true kad treba");
    }
    @Test
    void compareReturnsFalse() throws HeightTooBigException, HeightLessThanLowException {
        assertFalse(HC.isLess(150,100));
        assertFalse(HC.isLess(182,150));
        assertFalse(HC.isLess(182,182));
        assertFalse(HC.isEqual(182,150));
        assertFalse(HC.isEqual(100,150));
        assertFalse(HC.isGrather(100,150));
        assertFalse(HC.isGrather(150,215));
        assertFalse(HC.isGrather(182,215));
        LOGGER.log(Level.INFO, "metode vraca false kad treba");
    }

}