package test;

import junit.framework.TestCase;
import main.Day_11;
import org.junit.Test;

public class Day_11_test extends TestCase {

    main.Day_11 day_11 = new Day_11();


    @Test
    public void testPowerLevel_1() {
        int expected = 4;
        int actual = day_11.getPowerLevel(3, 5, 8);

        //System.out.println((9876543 / 100) % 10);
        
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPowerLevel_2() {
        int expected = -5;
        int actual = day_11.getPowerLevel(122,79, 57);
        
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPowerLevel_3() {
        int expected = 0;
        int actual = day_11.getPowerLevel(217,196, 39);
        
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPowerLevel_4() {
        int expected = 4;
        int actual = day_11.getPowerLevel(101,153, 71);
        
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    

    @Test
    public void testPartOne_2() {
        int serialNumber = 18;
        String expected = "33,45";
        String actual = day_11.day11PartOne(serialNumber);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_3() {
        int serialNumber = 42;
        String expected = "21,61";
        String actual = day_11.day11PartOne(serialNumber);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_1() {
        int serialNumber = 18;
        String expected = "90,269,16";
        String actual = day_11.day11PartTwo(serialNumber);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_2() {
        int serialNumber = 42;
        String expected = "232,251,12";
        String actual = day_11.day11PartTwo(serialNumber);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionOne() {
        int serialNumber = 9995;
        String expected = "33,45";
        String actual = day_11.day11PartOne(serialNumber);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionTwo() {
        int serialNumber = 9995;
        String expected = "233,116,15";
        String actual = day_11.day11PartTwo(serialNumber);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

