package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_05 https://adventofcode.com/2018/day/5
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
        StringBuilder sb = new StringBuilder(inp);

        boolean end = false;
        int l = sb.length();
        System.out.println(l);
        // while(end){
        // for (int i = 0; i < (l - 1); i++) {
        int i = 0;
        while (i < l - 1) {
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(i + 1);
            if (isOppositePolarity(ch1, ch2)) {
                // sb.deleteCharAt(i);
                // sb.deleteCharAt(i);
                sb.delete(i, i + 2);
                l = sb.length();
                i = 0;
            }else
            {
                i++;
            }
        }
        // end = true;
        // }
        int sum = sb.length();
        return sum;
    }

    public boolean isOppositePolarity(char a, char b) {
        return Math.abs((int) a - (int) b) == 32;
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

/*
 * abstract System.out.println((int)inp.charAt(0));
 * System.out.println(Math.abs((int)'A'-(int)'a'));
 * System.out.println((int)'a'-(int)'A');
 * 
 * System.out.println(isOppositePolarity('a','A'));
 * System.out.println(isOppositePolarity('A','A'));
 * System.out.println(isOppositePolarity('A','a'));
 * System.out.println(isOppositePolarity('a','b'));
 */