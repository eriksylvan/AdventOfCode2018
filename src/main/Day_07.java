package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Day_07
 */
public class Day_07 {

    String inputFile = "input\\input_07.txt";

    public static class Node {
		public char name;
        public List<Node> assambleAfter = new ArrayList<>();
	}

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
        

        List<Node> graph = new ArrayList<>(); 
        Map<String, Integer> order = new HashMap<String, Integer>();
        
        ArrayList<String>  instruction = new ArrayList<String>();  
        for (String str : input) {
            Pattern p = Pattern.compile("Step ([A-Z]) must be finished before step ([A-Z])");
            Matcher m = p.matcher(str);
            String step = "";
            String before = "";
            if (m.find()) {
                step = m.group(1);
                before = m.group(2);
            }
            instruction.add(before + step);
            if (order.containsKey(step)) {
                order.put(step, order.get(step) + 1);
            } else {
                order.put(step, 1);
            }
            if (order.containsKey(before)) {
                order.put(before, order.get(before) - 1);
            } else {
                order.put(before, -1);
            }
            System.out.println(step + " -> " + before);
        
        }
        Collections.sort(instruction);
        
        System.out.println(instruction);

        System.out.println(order);
        Node n = new Node();

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
