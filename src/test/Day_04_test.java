package test;

import junit.framework.TestCase;
import main.Day_04;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Day_04_test extends TestCase {

    main.Day_04 day_04 = new Day_04();

    static String[] input = { "[1518-11-01 00:00] Guard #10 begins shift", "[1518-11-01 00:05] falls asleep",
            "[1518-11-01 00:25] wakes up", "[1518-11-01 00:30] falls asleep", "[1518-11-01 00:55] wakes up",
            "[1518-11-01 23:58] Guard #99 begins shift", "[1518-11-02 00:40] falls asleep",
            "[1518-11-02 00:50] wakes up", "[1518-11-03 00:05] Guard #10 begins shift",
            "[1518-11-03 00:24] falls asleep", "[1518-11-03 00:29] wakes up",
            "[1518-11-04 00:02] Guard #99 begins shift", "[1518-11-04 00:36] falls asleep",
            "[1518-11-04 00:46] wakes up", "[1518-11-05 00:03] Guard #99 begins shift",
            "[1518-11-05 00:45] falls asleep", "[1518-11-05 00:55] wakes up" };

    @Test
    public void testPartOne_1() {
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));
        int expected = 240;
        int actual = day_04.day04PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartTwo_1() {
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));
        int expected = 4455;
        int actual = day_04.day04PartTwo(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartOne() {
        ArrayList<String> inp = day_04.getInputData();
        int expected = 36898;
        int actual = day_04.day04PartOne(inp);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartTwo() {
        ArrayList<String> inp = day_04.getInputData();
        int expected = 80711;
        int actual = day_04.day04PartTwo(inp);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }
}