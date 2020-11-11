package test;

import junit.framework.TestCase;
import main.Day_05;
import org.junit.Test;

public class Day_05_test extends TestCase {

    main.Day_05 day_05 = new Day_05();

    @Test
    public void testPartOne_1() {
        String input = "dabAcCaCBAcCcaDA";
        int expected = 10;
        int actual = day_05.day05PartOne(input);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartOne_2() {
        String input = "AaAaAa";
        int expected = 0;
        int actual = day_05.day05PartOne(input);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartTwo_1() {
        String input = "dabAcCaCBAcCcaDA";
        int expected = 4;
        int actual = day_05.day05PartTwo(input);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartOne() {
        String input = day_05.getInputData();
        int expected = 10132;
        int actual = day_05.day05PartOne(input);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartTwo() {
        String input = day_05.getInputData();
        int expected = 4572;
        int actual = day_05.day05PartTwo(input);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

}
