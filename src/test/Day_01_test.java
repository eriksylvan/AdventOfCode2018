package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;
import main.Day_01;

public class Day_01_test extends TestCase {

    main.Day_01 day1 = new Day_01();

    @Test
    public void testPartOne_1() {
        Integer[] input = { +1, -2, +3, +1 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 3;
        int actual = day1.day01PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartOne_2() {
        Integer[] input = { +1, +1, +1 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 3;
        int actual = day1.day01PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartOne_3() {
        Integer[] input = { +1, +1, -2 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 0;
        int actual = day1.day01PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartOne_4() {
        Integer[] input = { -1, -2, -3 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = -6;
        int actual = day1.day01PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartTwo_1() {
        Integer[] input = { +1, -1 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 0;
        int actual = day1.day01PartTwo(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartTwo_2() {
        Integer[] input = { +3, +3, +4, -2, -4 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 10;
        int actual = day1.day01PartTwo(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartTwo_3() {
        Integer[] input = { -6, +3, +8, +5, -6 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 5;
        int actual = day1.day01PartTwo(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartTwo_4() {
        Integer[] input = { +7, +7, -2, -7, -4 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 14;
        int actual = day1.day01PartTwo(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartOne() {
        ArrayList<Integer> inp = day1.getInputData();
        int expected = 497;
        int actual = day1.day01PartOne(inp);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartTwo() {
        ArrayList<Integer> inp = day1.getInputData();
        int expected = 558;
        int actual = day1.day01PartTwo(inp);

        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);

    }
}
