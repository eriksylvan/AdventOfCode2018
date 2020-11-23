package test;

import junit.framework.TestCase;
import main.Day_09;
import org.junit.Test;

public class Day_09_test extends TestCase {

    main.Day_09 day_09 = new Day_09();

    @Test
    public void testPartOne_1() {
        int expected = 32;
        int actual = day_09.day09PartOne(9, 25);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    public void testPartOne_2() {
        int expected = 8317;
        int actual = day_09.day09PartOne(10, 1618);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    public void testPartOne_3() {
        int expected = 146373;
        int actual = day_09.day09PartOne(13, 7999);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    public void testPartOne_4() {
        int expected = 2764;
        int actual = day_09.day09PartOne(17, 1104);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    public void testPartOne_5() {
        int expected = 54718;
        int actual = day_09.day09PartOne(21, 6111);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    public void testPartOne_6() {
        int expected = 37305;
        int actual = day_09.day09PartOne(30, 5807);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSoulutionPartOne() {
        int expected = 396136;
        int actual = day_09.day09PartOne(463, 71787);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

}
