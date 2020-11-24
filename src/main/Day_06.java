package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.awt.Point;

/**
 * Day_06 
 * https://adventofcode.com/2018/day/6
 */
public class Day_06 {

    String inputFile = "input\\input_06.txt";

    public ArrayList<Point> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_06.class.getResourceAsStream(inputFile));
        ArrayList<Point> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String str = inputScanner.nextLine();
            int x = Integer.parseInt(str.split(",")[0].strip());
            int y = Integer.parseInt(str.split(",")[1].strip());
            inp.add(new Point(x, y));
        }
        inputScanner.close();
        return inp;
    }

    public int day06PartOne(ArrayList<Point> inp) {

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;

        for (Point pos : inp) {
            int x = pos.x;
            int y = pos.y;
            left = (x < left) ? x : left;
            right = (x > right) ? x : right;
            top = (y < top) ? y : top;
            bottom = (y > bottom) ? y : bottom;

        }

        Map<Point, int[]> space = new HashMap<Point, int[]>();
        for (int x = left; x <= right; x++) {
            for (int y = top; y <= bottom; y++) {
                // find shortest Manhattan Distance
                int smd = Integer.MAX_VALUE;
                int c = 1;
                int closest = 0;
                for (Point pos : inp) {
                    int md = Math.abs(x - pos.x) + Math.abs(y - pos.y);
                    if (md < smd) {
                        smd = md;
                        closest = c;
                    } else if (md == smd) {
                        smd = md;
                        closest = 0;
                    }
                    c++;
                }
                space.put(new Point(x, y), new int[] { closest, smd });
            }
        }

        // count size of all finite areas
        int[] areas = new int[inp.size() + 1];
        for (int x = left; x <= right; x++) {
            for (int y = top; y <= bottom; y++) {
                int c = space.get(new Point(x, y))[0];
                if (x == left || x == right || y == top || y == bottom || areas[c] == -1) {
                    // -1 indicates infinite area
                    areas[c] = -1;
                }
                areas[c]++;
            }
        }

        // Find biggest finite area
        int maxArea = 0;
        for (int area : areas) {
            if (area > maxArea)
                maxArea = area;
        }

        return maxArea;
    }

    public int day06PartTwo(ArrayList<Point> inp, int limit) {

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;

        for (Point pos : inp) {
            int x = pos.x;
            int y = pos.y;
            left = (x < left) ? x : left;
            right = (x > right) ? x : right;
            top = (y < top) ? y : top;
            bottom = (y > bottom) ? y : bottom;
        }

        Map<Point, Integer> space = new HashMap<Point, Integer>();
        for (int x = left; x <= right; x++) {
            for (int y = top; y <= bottom; y++) {
                // sum manhatan distance to all points
                int mdSum = 0;
                for (Point pos : inp) {
                    mdSum += Math.abs(x - pos.x) + Math.abs(y - pos.y);
                }
                if (mdSum < limit)
                    space.put(new Point(x, y), 1);
                else
                    space.put(new Point(x, y), 0);
            }
        }

        int sum = 0;
        for (int safe : space.values())
            sum += safe;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 06\n");
        Day_06 day_06 = new Day_06();
        int answer1, answer2;
        ArrayList<Point> inp = day_06.getInputData();
        answer1 = day_06.day06PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_06.day06PartTwo(inp, 10000);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2018, Day 06

Solution Part one: 5358
Solution Part two: 37093
*/