package test;

import junit.framework.TestCase;
import main.Day_XX;
import org.junit.Test;

public class Day_XX_test extends TestCase {

    main.Day_XX day_xx = new Day_XX();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_xx.dayXXPartOne();
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }
}

