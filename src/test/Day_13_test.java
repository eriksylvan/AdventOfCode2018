package test;

import junit.framework.TestCase;
import main.Day_13;
import org.junit.Test;

public class Day_13_test extends TestCase {

    main.Day_13 day_13 = new Day_13();

    @Test
    public void testPartOne_1() {
        day_13.inputFile = "input\\input_13_test.txt";
        day_13.getInputData();
        String expected = "7,3";
        String actual = day_13.day13PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        day_13.inputFile =  "input\\input_13.txt";
        day_13.getInputData();
        String expected = "79,128";
        String actual = day_13.day13PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }


}

