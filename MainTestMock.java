import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
class MainTestMock {
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
    public void negativethrowsHLTZE() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=mock(Main.class);
        when(m.validateHeight(-1)).thenThrow(HeightLessThanZeroException.class);
        assertThrows(HeightLessThanZeroException.class,()->{m.validateHeight(-1);});
    }
    @Test
    public void zerothrowsHLTZE() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=mock(Main.class);
        when(m.validateHeight(0)).thenThrow(HeightLessThanZeroException.class);
        assertThrows(HeightLessThanZeroException.class,()->{m.validateHeight(0);});
    }
    @Test
    public void bigNegativethrowsHLTZE() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=mock(Main.class);
        when(m.validateHeight(-1000)).thenThrow(HeightLessThanZeroException.class);
        assertThrows(HeightLessThanZeroException.class,()->{m.validateHeight(-1000);});
    }
    @Test
    public void positive1ReturnsTrue() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=mock(Main.class);
        when(m.validateHeight(1)).thenReturn(true);
        assertEquals(true,m.validateHeight(1));
    }
    @Test
    public void positive2ReturnsTrue() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=mock(Main.class);
        when(m.validateHeight(299)).thenReturn(true);
        assertEquals(true,m.validateHeight(299));
    }
    @Test
    public void positive3ReturnsTrue() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=mock(Main.class);
        when(m.validateHeight(150)).thenReturn(true);
        assertEquals(true,m.validateHeight(150));
    }
    @Test
    public void bigPositiveThrowsHTBE() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=mock(Main.class);
        when(m.validateHeight(301)).thenThrow(HeightTooBigException.class);
        assertThrows(HeightTooBigException.class,()->{m.validateHeight(301);});
    }
    @Test
    public void reallybigPositiveThrowsHTBE() throws HeightTooBigException, HeightLessThanZeroException {
        Main m=mock(Main.class);
        when(m.validateHeight(10001)).thenThrow(HeightTooBigException.class);
        assertThrows(HeightTooBigException.class,()->{m.validateHeight(10001);});
    }
}