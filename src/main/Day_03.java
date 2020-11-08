package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Day_03
 * https://adventofcode.com/2018/day/3
 */

public class Day_03 {

    protected int[][] map;
    protected ArrayList<int[]> coordinateList;

    String inputFile = "input\\input_03.txt";

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_03.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            inp.add(inputScanner.nextLine());
        }
        inputScanner.close();
        return inp;
    }

    public int day03PartOne(ArrayList<String> claimInput) {
        int sum = 0;

        map = new int[1100][1100];
        coordinateList = new ArrayList<int[]>();

        for (String str : claimInput) {
            Pattern p = Pattern.compile("#(\\d+)\\s@\\s(\\d+),(\\d+):\\s(\\d+)x(\\d+)");
            Matcher m = p.matcher(str);
            if (m.find()) {
                int n = Integer.parseInt(m.group(1));
                int x = Integer.parseInt(m.group(2));
                int y = Integer.parseInt(m.group(3));
                int w = Integer.parseInt(m.group(4));
                int h = Integer.parseInt(m.group(5));
                int[] c = { n, x, y, w, h };
                coordinateList.add(c); // Save for partTwo
                for (int i = y; i < (y + h); i++) {
                    for (int j = x; j < (x + w); j++) {
                        if (map[i][j] == 1) {
                            sum++;
                        }
                        map[i][j] = map[i][j] + 1;
                    }
                }
            } else {
                System.out.println("NO MATCH");
            }
        }
        return sum;
    }

    public int day03PartTwo() {
        int number = 0;
        if (map == null) {
            System.out.println("Run day03PartOne first.");
            return 0;
        }
        boolean found = true;
        for (int[] c : coordinateList) {
            overlap:for (int i = c[2]; i < (c[2] + c[4]); i++) {
                for (int j = c[1]; j < (c[1] + c[3]); j++) {                    
                    if (map[i][j] > 1) {
                        found = false;
                        break overlap; // a value > 1 indicates overlap 
                    }                       
                }
            }
            if (found){
                number = c[0];
                break;
            }
            found = true;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 03\n");
        Day_03 day_03 = new Day_03();
        int answer1 = 0, answer2 = 0;
        ArrayList<String> inp = day_03.getInputData();
        answer1 = day_03.day03PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_03.day03PartTwo();
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
