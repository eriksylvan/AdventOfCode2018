package test;

import junit.framework.TestCase;
import main.Day_08;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Day_08_test extends TestCase {

    

    main.Day_08 day_08 = new Day_08();

    @Test
    public void testPartOne_1() {
        Integer[] input = { 2, 3, 0, 3, 10, 11, 12, 1, 1, 0, 1, 99, 2, 1, 1, 2 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));
        day_08.input = indata; 
        int expected = 138;
        int actual = day_08.day08PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }



    @Test
    public void testSoulutionPartOne() {
        day_08.getInputData(); 
        int expected = 41521;
        int actual = day_08.day08PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

