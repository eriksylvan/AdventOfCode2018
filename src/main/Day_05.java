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

        AlchemicalReduction(sb);

        int len = sb.length();
        return len;
    }

    private void AlchemicalReduction(StringBuilder sb) {
        int l = sb.length();
        int i = 0;
        while (i < l - 1) {
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(i + 1);
            if (isOppositePolarity(ch1, ch2)) {
                sb.delete(i, i + 2);
                l = sb.length();
                i = 0;
            } else {
                i++;
            }
        }
    }

    private StringBuilder RemoveUnit(StringBuilder sb, Character ch) {
        String crLow = String.valueOf(Character.toLowerCase(ch));
        String crUpp = String.valueOf(Character.toUpperCase(ch));
        String regex = "[" + crLow + crUpp + "]";
        return new StringBuilder(sb.toString().replaceAll(regex, ""));
    }

    public boolean isOppositePolarity(char a, char b) {
        return Math.abs((int) a - (int) b) == 32;
    }

    public int day05PartTwo(String inp) {
       int minLength = inp.length();
        for (char c = 'a'; c <= 'z'; c++) {
            StringBuilder sb = new StringBuilder(inp);
            sb = RemoveUnit(sb, c);
            AlchemicalReduction(sb);
            if (sb.length() < minLength) {
                minLength = sb.length();
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 05\n");
        Day_05 day_05 = new Day_05();
        int answer1, answer2;
        String inp = day_05.getInputData();
        answer1 = day_05.day05PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_05.day05PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/**
 * Advent of code 2018, Day 05
 * 
 * Solution Part one: 10132
 * Solution Part two: 4572
 */