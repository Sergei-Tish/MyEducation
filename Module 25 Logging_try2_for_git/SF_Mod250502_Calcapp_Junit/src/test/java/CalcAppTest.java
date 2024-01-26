import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcAppTest {
    CalcApp calcApp = new CalcApp();

    @Before
    public void setUp() throws Exception {
        CalcApp calcApp = new CalcApp();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void hasEndCommandTrue() {
        assertTrue(calcApp.hasEndCommand("5+4 end TEST"));
    }

    @Test
    public void hasEndCommandFalse() {
        assertFalse(calcApp.hasEndCommand("5+4 enQd TEST"));
    }

    @Test
    public void hasWrongSymbol() {
        assertTrue(calcApp.hasWrongSymbol("4+4 TEST"));
    }

    @Test
    public void hasDecimalSymbol() {
        assertFalse(calcApp.hasDecimalSymbol("++-*/"));
    }

    @Test
    public void hasFirstDecimalInArray() {
        assertTrue(calcApp.hasFirstDecimalInArray(new String[]{"2", "+", "TEST"}, "2+TEST"));
        assertFalse(calcApp.hasFirstDecimalInArray(new String[]{"+", "3", "TEST"}, "+3+TEST"));
    }

    @Test
    public void hasSecondDecimalInArray() {
        assertTrue(calcApp.hasSecondDecimalInArray(new String[]{"", "4", ""}, "+4"));
        assertFalse(calcApp.hasSecondDecimalInArray(new String[]{"5", "+", "TEST"}, "5+TEST"));
    }

    @Test
    public void getAdd() {
        assertEquals(20, calcApp.getAdd(10, 10));
    }

    @Test
    public void getSubtract() {
        assertEquals(10, calcApp.getSubtract(20, 10));
    }

    @Test
    public void getMultiply() {
        assertEquals(100, calcApp.getMultiply(10, 10));
    }

    @Test
    public void getDivide() {
        assertEquals(1, calcApp.getDivide(10, 10));
    }
}