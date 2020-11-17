package main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
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

    public String day07PartOne(ArrayList<String> input) {

        Map<Character, List<Character>> E = new HashMap<Character, List<Character>>();
        Map<Character, Integer> D = new HashMap<Character, Integer>();
        for (String str : input) {
            Pattern p = Pattern.compile("Step ([A-Z]) must be finished before step ([A-Z])");
            Matcher m = p.matcher(str);
            String step = "";
            String before = "";
            Character x = ' ';
            Character y = ' ';
            if (m.find()) {
                step = m.group(1);
                before = m.group(2);
                x = step.charAt(0);
                y = before.charAt(0);
            }

            if (E.containsKey(x)) {
                E.get(x).add(y);
            } else {
                List<Character> l = new ArrayList<Character>();
                l.add(y);
                E.put(x, l);
            }

            E.putIfAbsent(y, new ArrayList<Character>());
            D.putIfAbsent(x, 0);

            if (D.containsKey(y)) {
                D.put(y, D.get(y) + 1);
            } else {
                D.put(y, 1);
            }
        }

        Deque<Character> Q = new ArrayDeque<Character>();

        // Find the instruction that is has no instructions besfore
        for (Character ch : E.keySet()) {
            if (D.get(ch) == 0) {
                Q.add(ch);
            }
        }

        String answer = "";

        while (!Q.isEmpty()) {

            // Sort dqueue
            Character[] sorted = Q.toArray(new Character[0]);
            Arrays.sort(sorted);
            Q.clear();
            for (Character c : sorted) {
                Q.add(c);
            }

            char a = Q.pop();
            answer += a;
            for (Character ch : E.get(a)) {
                D.put(ch, D.get(ch) - 1);
                if (D.get(ch) == 0) {
                    Q.add(ch);
                }
            }
        }
        return answer;
    }

    public int day07PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 07\n");
        Day_07 day_07 = new Day_07();
        String answer1;
        int answer2;
        ArrayList<String> inp = day_07.getInputData();
        answer1 = day_07.day07PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_07.day07PartTwo();
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
 * procedure BFS(G, v) is create a queue Q enqueue v onto Q mark v while Q is
 * not empty do w ← Q.dequeue() if w is what we are looking for then return w
 * for all edges e in G.adjacentEdges(w) do x ← G.adjacentVertex(w, e) if x is
 * not marked then mark x enqueue x onto Q return null
 * 
 **/