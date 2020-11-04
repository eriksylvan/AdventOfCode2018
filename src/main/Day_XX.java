package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_XX
 */
public class Day_XX {

    String inputFile = "input\\input_XX.txt";

    public ArrayList<Integer> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_XX.class.getResourceAsStream(inputFile));
        ArrayList<Integer> inp = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        inputScanner.close();
        return inp;
    }

    public int dayXXPartOne() {
        int sum = 0;
        return sum;
    }

    public int dayXXPartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day XX\n");
        Day_XX day_xx = new Day_XX();
        int answer1, answer2;
        //ArrayList<Integer> inp = day_xx.getInputData();
        answer1 = day_xx.dayXXPartOne();
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_xx.dayXXPartTwo();
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
