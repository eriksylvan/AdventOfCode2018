package test;

import junit.framework.TestCase;
import main.Day_03;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Day_03_test extends TestCase {

    main.Day_03 day_03 = new Day_03();

    @Test
    public void testPartOne_1() {
        String[] input = { "#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2" };
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));
        int expected = 4;
        int actual = day_03.day03PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

}
