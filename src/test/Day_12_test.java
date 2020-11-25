package test;

import junit.framework.TestCase;
import main.Day_12;
import org.junit.Test;

public class Day_12_test extends TestCase {

    main.Day_12 day_12 = new Day_12();

    

    @Test
    public void testPartOne_1() {
        day_12.inputFile =  "input\\input_12_test.txt";
        day_12.getInputData();
        int expected = 325;
        int actual = day_12.day12PartOne("#..#.#..##......###...###");
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        day_12.inputFile =  "input\\input_12.txt";
        day_12.getInputData();
        int expected = 3605;
        int actual = day_12.day12PartOne(".#..##..#.....######.....#....####.##.#.#...#...##.#...###..####.##.##.####..######......#..##.##.##");
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    
}

