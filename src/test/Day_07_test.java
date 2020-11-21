package test;

import junit.framework.TestCase;
import main.Day_07;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Day_07_test extends TestCase {

    main.Day_07 day_07 = new Day_07();

    protected static 
    String[] input = { "Step C must be finished before step A can begin.",
            "Step C must be finished before step F can begin.", 
            "Step A must be finished before step B can begin.",
            "Step A must be finished before step D can begin.", 
            "Step B must be finished before step E can begin.",
            "Step D must be finished before step E can begin.",
            "Step F must be finished before step E can begin.", };


    @Test
    public void testPartOne_1() {
      ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));

        String expected = "CABDFE";
        String actual = day_07.day07PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_1() {
      ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));

        int expected = 15;
        int actual = day_07.day07PartTwo(indata,2,0);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_2() {
        String[] testinp = { "Step C must be finished before step D can begin.",
            "Step B must be finished before step D can begin.", 
            "Step A must be finished before step C can begin.",
            "Step A must be finished before step B can begin."};
      ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testinp));

        int expected = 11;
        int actual = day_07.day07PartTwo(indata,1,0);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
  

        expected = 9;
        actual = day_07.day07PartTwo(indata,2,0);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_3() {
        String[] testinp = {"Step A must be finished before step B can begin."};
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testinp));

        int expected = 4;
        int actual = day_07.day07PartTwo(indata,1,0);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
  

        expected = 4;
        actual = day_07.day07PartTwo(indata,2,0);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);

        expected = 124;
        actual = day_07.day07PartTwo(indata,2,60);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);

   
    }

    @Test
    public void testSolutionPartOne() {

        ArrayList<String> indata = day_07.getInputData();

        String expected = "ACBDESULXKYZIMNTFGWJVPOHRQ";
        String actual = day_07.day07PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

}
