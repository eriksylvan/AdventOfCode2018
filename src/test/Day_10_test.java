package test;

import junit.framework.TestCase;
import main.Day_10;
import org.junit.Test;

public class Day_10_test extends TestCase {

    main.Day_10 day_10 = new Day_10();

    @Test
    public void testPartOne_1() {
        day_10.inputFile = "input\\input_10_test.txt";
        day_10.getInputData();
        int expected = 3;
        int actual = day_10.day10PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolution() {
        day_10.getInputData();
        int expected = 10946;
        int actual = day_10.day10PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

