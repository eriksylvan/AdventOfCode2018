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

    public int day11PartOne() {
        int sum = 0;
        return sum;
    }

    public int day11PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_11 day_11 = new Day_11();
        int answer1, answer2;
        //ArrayList<Integer> inp = day_xx.getInputData();
        answer1 = day_11.day11PartOne();
        
        answer2 = day_11.day11PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 11\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
