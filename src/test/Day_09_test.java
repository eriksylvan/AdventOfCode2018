package test;

import junit.framework.TestCase;
import main.Day_09;
import org.junit.Test;

public class Day_09_test extends TestCase {

    main.Day_09 day_09 = new Day_09();

    @Test
    public void testPartOne_1() {
        long expected = 32;
        long actual = day_09.day09PartOne(9, 25);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_2() {
        long expected = 8317;
        long actual = day_09.day09PartOne(10, 1618);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_3() {
        long expected = 146373;
        long actual = day_09.day09PartOne(13, 7999);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_4() {
        long expected = 2764;
        long actual = day_09.day09PartOne(17, 1104);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_5() {
        long expected = 54718;
        long actual = day_09.day09PartOne(21, 6111);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_6() {
        long expected = 37305;
        long actual = day_09.day09PartOne(30, 5807);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSoulutionPartOne() {
        long expected = 396136;
        long actual = day_09.day09PartOne(463, 71787);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSoulutionPartTwo() {
        long expected = 3183301184L;
        long actual = day_09.day09PartOne(463, 7178700);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

}
