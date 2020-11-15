package test;

import junit.framework.TestCase;
import main.Day_07;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Day_07_test extends TestCase {

    main.Day_07 day_07 = new Day_07();

    @Test
    public void testPartOne_1() {

        String[] input = { 
            "Step C must be finished before step A can begin.",
            "Step C must be finished before step F can begin.",
            "Step A must be finished before step B can begin.",
            "Step A must be finished before step D can begin.",
            "Step B must be finished before step E can begin.",
            "Step D must be finished before step E can begin.",
            "Step F must be finished before step E can begin.",
         };

        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_07.day07PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + expected, actual);
    }


    
}

