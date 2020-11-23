package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_10
 */
public class Day_10 {

    String inputFile = "input\\input_10.txt";

    public ArrayList<Integer> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_10.class.getResourceAsStream(inputFile));
        ArrayList<Integer> inp = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        inputScanner.close();
        return inp;
    }

    public int day10PartOne() {
        int sum = 0;
        return sum;
    }

    public int day10PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_10 day_10 = new Day_10();
        int answer1, answer2;
        //ArrayList<Integer> inp = day_10.getInputData();
        answer1 = day_10.day10PartOne();
        
        answer2 = day_10.day10PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 10\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
