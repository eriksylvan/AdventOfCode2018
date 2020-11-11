package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_06
 * https://adventofcode.com/2018/day/6
 */
public class Day_06 {

    String inputFile = "input\\input_06.txt";

    public ArrayList<Integer> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_06.class.getResourceAsStream(inputFile));
        ArrayList<Integer> inp = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        inputScanner.close();
        return inp;
    }

    public int day06PartOne() {
        int sum = 0;
        return sum;
    }

    public int day06PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 06\n");
        Day_06 day_xx = new Day_06();
        int answer1, answer2;
        //ArrayList<Integer> inp = day_xx.getInputData();
        answer1 = day_xx.day06PartOne();
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_xx.day06PartTwo();
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
