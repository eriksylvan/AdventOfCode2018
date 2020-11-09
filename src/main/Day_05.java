package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_05
 * https://adventofcode.com/2018/day/5
 */
public class Day_05 {

    String inputFile = "input\\input_05.txt";

    public String getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_05.class.getResourceAsStream(inputFile));
        String inp = "";
        if (inputScanner.hasNextLine()) {
            inp = inputScanner.next();
        }
        inputScanner.close();
        return inp;
    }

    public int day05PartOne(String inp) {
        int sum = inp.length();
        return sum;
    }

    public int day05PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 05\n");
        Day_05 day_05 = new Day_05();
        int answer1, answer2;
        String inp = day_05.getInputData();
        answer1 = day_05.day05PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_05.day05PartTwo();
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
