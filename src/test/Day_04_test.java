package test;

import junit.framework.TestCase;
import main.Day_04;
import org.junit.Test;

public class Day_04_test extends TestCase {

    main.Day_04 day_04 = new Day_04();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_04.day04PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }
}
