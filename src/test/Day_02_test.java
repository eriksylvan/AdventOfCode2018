package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;
import main.Day_02;

public class Day_02_test extends TestCase {

    main.Day_02 day = new Day_02();

    @Test
    public void testPartOne_1() {

        String[] input = { "abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab" };

        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));

        int expected = 12;
        int actual = day.day02PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartTwo_1() {

        String[] input = { "abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz" };

        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));

        String expected = "fgij";
        String actual = day.day02PartTwo(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartOne() {
        ArrayList<String> inp = day.getInputData();
        int expected = 9633;
        int actual = day.day02PartOne(inp);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartTwo() {
        ArrayList<String> inp = day.getInputData();
        String expected = "lujnogabetpmsydyfcovzixaw";
        String actual = day.day02PartTwo(inp);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

}
