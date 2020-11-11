package test;

import junit.framework.TestCase;
import main.Day_06;
import org.junit.Test;

public class Day_06_test extends TestCase {

    main.Day_06 day_06 = new Day_06();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_06.day06PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }
}

