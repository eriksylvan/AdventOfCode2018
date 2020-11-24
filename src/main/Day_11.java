package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_11
 */
public class Day_11 {

    String inputFile = "input\\input_11.txt";

    public ArrayList<Integer> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_11.class.getResourceAsStream(inputFile));
        ArrayList<Integer> inp = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        inputScanner.close();
        return inp;
    }

    public int getPowerLevel(int x, int y, int sn) {
        int r = x + 10;
        int pl = r * y;
        pl = pl + sn;
        pl = pl * r;
        pl = (pl / 100) % 10;
        pl = pl - 5;

        return pl;
    }

    public String day11PartOne(int serial) {
        // int[][] grid = new int[300][300];
        int[][] grid = new int[300][300];

        for (int y = 0; y < 300; y++) {
            for (int x = 0; x < 300; x++) {
                grid[x][y] = getPowerLevel(x, y, serial);

            }
        }

        int maxP = Integer.MIN_VALUE;
        int maxX = -1, maxY = -1;
        for (int y = 0; y < 298; y++) {
            for (int x = 0; x < 298; x++) {
                //System.out.print(grid[x][y] + " ");
                int p = grid[x][y] + grid[x+1][y] + grid[x+2][y] +
                grid[x][y+1] + grid[x+1][y+1] + grid[x+2][y+1] +
                grid[x][y+2] + grid[x+1][y+2] + grid[x+2][y+2];
                if (p > maxP){
                    maxP = p;
                    maxX = x;
                    maxY = y;
                }
            }
        }
        String c = maxX+","+maxY;
        return c;
    }

    public int day11PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_11 day_11 = new Day_11();
        String answer1;
        int answer2;
        answer1 = day_11.day11PartOne(9995);

        answer2 = day_11.day11PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 11\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
