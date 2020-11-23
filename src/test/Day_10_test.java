package test;

import junit.framework.TestCase;
import main.Day_10;
import org.junit.Test;

public class Day_10_test extends TestCase {

    main.Day_10 day_10 = new Day_10();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_10.day10PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

