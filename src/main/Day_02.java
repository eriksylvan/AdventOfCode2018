
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Day_02
 * https://adventofcode.com/2018/day/2#part2
 */
public class Day_02 {

    String inputFile = "input\\input_02.txt";

    public ArrayList<String> getInputData() {

        Scanner inputScanner;
        inputScanner = new Scanner(Day_02.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            inp.add(inputScanner.nextLine());
        }
        inputScanner.close();
        return inp;
    }

    public int day02PartOne(ArrayList<String> input) {
        int no2 = 0, no3 = 0;
        // find and count unique letters in each row
        for (String str : input) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (Character c : str.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            // count numer of three and two occurance
            if (map.containsValue(2)) {
                no2++;
            }
            if (map.containsValue(3)) {
                no3++;
            }
        }
        return no2 * no3;
    }

    public String day02PartTwo(ArrayList<String> input) {

        // compare all string with eachother
        for (String str1 : input) {
            for (String str2 : input) {
                int diffCount = 0;
                String answer = "";
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) != str2.charAt(i)) {

                        diffCount++;
                    }
                    else{
                        answer = answer + str1.charAt(i);
                    }
                    if (diffCount > 1)
                        break; // Not this one

                }
                if (diffCount == 1) {
                    return answer;
                }
            }
        }
        return ""; // nothing found
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 02\n");
        Day_02 day = new Day_02();
        int answer1;
        String answer2;
        ArrayList<String> inp = day.getInputData();
        // System.out.println(inp);
        answer1 = day.day02PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day.day02PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2018, Day 02

Solution Part one: 9633
Solution Part two: lujnogabetpmsydyfcovzixaw
*/