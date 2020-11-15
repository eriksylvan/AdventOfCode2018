package test;

import junit.framework.TestCase;
import main.Day_06;

import java.util.ArrayList;
import java.awt.Point;
import org.junit.Test;

public class Day_06_test extends TestCase {

    main.Day_06 day_06 = new Day_06();

    @Test
    public void testPartOne_1() {
        int[][] input = 
            {{1, 1},
            {1, 6},
            {8, 3},
            {3, 4},
            {5, 5},
            {8, 9}};
        
        ArrayList<Point> indata = int2Point(input);

        int expected = 17;
        int actual = day_06.day06PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartTwo_1() {
        int[][] input = 
            {{1, 1},
            {1, 6},
            {8, 3},
            {3, 4},
            {5, 5},
            {8, 9}};
        
        ArrayList<Point> indata = int2Point(input);

        int expected = 16;
        int actual = day_06.day06PartTwo(indata, 32);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {

        ArrayList<Point> indata = day_06.getInputData();

        int expected = 5358;
        int actual = day_06.day06PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartTwo() {

        ArrayList<Point> indata = day_06.getInputData();

        int expected = 37093;
        int actual = day_06.day06PartTwo(indata, 10000);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    ArrayList<Point> int2Point(int[][] intArray)
    {
        ArrayList<Point> points = new ArrayList<Point>();
        for (int[] point : intArray)
        {
            points.add(new Point(point[0], point[1]));
        }
        return points;
    }
}



