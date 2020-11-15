package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Day_07
 */
public class Day_07 {

    String inputFile = "input\\input_07.txt";

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_07.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            inp.add(inputScanner.nextLine());
        }
        inputScanner.close();
        return inp;
    }

    public int day07PartOne(ArrayList<String> input) {
        for (String str : input) {
            Pattern p = Pattern.compile("Step ([A-Z]) must be finished before step ([A-Z])");
            Matcher m = p.matcher(str);
            String step = "";
            String before = "";
            if (m.find()) {
                step = m.group(1);
                before = m.group(2);
            }
            System.out.println(step + " -> " + before);
        }
        System.out.println("Size: " + input.size());
        return 0;
    }

    public int day07PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 07\n");
        Day_07 day_07 = new Day_07();
        int answer1, answer2;
        ArrayList<String> inp = day_07.getInputData();
        answer1 = day_07.day07PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_07.day07PartTwo();
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
