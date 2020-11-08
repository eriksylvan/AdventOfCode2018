package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_04
 */
public class Day_04 {

    String inputFile = "input\\input_XX.txt";

    public ArrayList<Integer> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_04.class.getResourceAsStream(inputFile));
        ArrayList<Integer> inp = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        inputScanner.close();
        return inp;
    }

    public int day04PartOne() {
        int sum = -1;
        return sum;
    }

    public int day04PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 04\n");
        Day_04 day = new Day_04();
        int answer1, answer2;
        //ArrayList<Integer> inp = day.getInputData();
        answer1 = day.day04PartOne();
        System.out.println("Solution Part one: " + answer1);
        answer2 = day.day04PartTwo();
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
