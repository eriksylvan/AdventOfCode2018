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
 * 
 * https://adventofcode.com/2018/day/7
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

    private void ArrangeInstructions(ArrayList<String> input, Map<Character, List<Character>> e,
            Map<Character, Integer> d) {
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

            if (e.containsKey(x)) {
                e.get(x).add(y);
            } else {
                List<Character> l = new ArrayList<Character>();
                l.add(y);
                e.put(x, l);
            }

            e.putIfAbsent(y, new ArrayList<Character>());
            d.putIfAbsent(x, 0);

            if (d.containsKey(y)) {
                d.put(y, d.get(y) + 1);
            } else {
                d.put(y, 1);
            }
        }
        // System.out.println(E);

    }

    public String day07PartOne(ArrayList<String> input) {

        // E lists the instuctions that comes after every instruction
        // E['A'] = [B, D] means that A must be done before B and D
        Map<Character, List<Character>> E = new HashMap<Character, List<Character>>();
        // D counts the depth of every instruction, the number of instructions that has
        // to be done before this specific instructon
        // if D['A']==0 thean A can be performed, it has not dependent on any
        // instructions
        Map<Character, Integer> D = new HashMap<Character, Integer>();

        ArrangeInstructions(input, E, D);

        // Q contains all instructions that can be done next.
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
            SortQueue(Q);

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

    private void SortQueue(Deque<Character> Q) {
        Character[] sorted = Q.toArray(new Character[0]);
        Arrays.sort(sorted);
        Q.clear();
        for (Character c : sorted) {
            Q.add(c);
        }
    }

    private boolean IdleWorker(int[] i) {
        for (int a : i) {
            if (a == 0)
                return true;
        }
        return false;
    }

    private boolean AllIdleWorker(int[] i) {
        for (int a : i) {
            if (a != 0)
                return false;
        }
        return true;
    }

    private void PrintWork(int second, char[] WoInstr, String done) {
        if (second == 0) {
            System.out.print("Swk\t");
            for (int c = 0; c < WoInstr.length; c++) {
                System.out.print("W: " + c + "\t");

            }
            System.out.println("Done");
        }
        System.out.print(second + "\t");
        for (char i : WoInstr) {
            System.out.print(i + "\t");
        }
        System.out.println(done);

    }

    public int day07PartTwo(ArrayList<String> input, int workers, int time) {

        // E lists the instuctions that comes after every instruction
        // E['A'] = [B, D] means that A must be done before B and D
        Map<Character, List<Character>> E = new HashMap<Character, List<Character>>();
        // D counts the depth of every instruction, the number of instructions that has
        // to be done before this specific instructon
        // if D['A']==0 thean A can be performed, it has not dependent on any
        // instructions
        Map<Character, Integer> D = new HashMap<Character, Integer>();
        String answer = "";
        ArrangeInstructions(input, E, D);
        // Q contains all instructions that can be done next.
        Deque<Character> Q = new ArrayDeque<Character>();

        int[] WoTimeLeft = new int[workers];
        char[] WoInstr = new char[workers];
        List<Character> WoDone = new ArrayList<Character>();
        int seconds = 0;

        // Find the instruction(s) to start with
        for (Character ch : E.keySet()) {
            if (D.get(ch) == 0) {
                Q.add(ch);
            }
        }
        boolean done = false;

        while (WoDone.size() < D.size()) {

            // give all idle workers some work
            while (IdleWorker(WoTimeLeft)) {
                // Find the instruction that is has no instructions besfore
                if (Q.isEmpty()) {
                    break;
                }

                // Find idle worker
                int idleWorker = -1;
                for (int i = 0; i < WoTimeLeft.length; i++) {
                    if (WoTimeLeft[i] == 0)

                    {
                        idleWorker = i;
                        break; // for
                    }
                }

                // pick next job to do
                // Pick next instruction
                SortQueue(Q);

                System.out.println(E);
                System.out.println(D);
                System.out.println(Q);

                char a = Q.pop();

                WoTimeLeft[idleWorker] = (int) a - (int) 'A' + time + 1;
                WoInstr[idleWorker] = a;
            }

            PrintWork(seconds, WoInstr, WoDone.toString());
            // System.out.println(Q);

            // decrement each workers remaining time
            // if a worker finishes, mark its task as completed
            for (int i = 0; i < WoTimeLeft.length; i++) {
                // System.out.println("Worker: " + i + " Instr: " + WoInstr[i] + " TimeLeft: " +
                // WoTimeLeft[i]);
                WoTimeLeft[i] = (WoTimeLeft[i] == 0 ? 0 : WoTimeLeft[i] - 1);
                if (WoTimeLeft[i] == 0) {
                    if ((int) WoInstr[i] != 0) {
                        WoDone.add(WoInstr[i]);
                        // remove done jobs and fill job queue with new ones
                        for (Character ch : E.get(WoInstr[i])) {
                            D.put(ch, D.get(ch) - 1);
                            if (D.get(ch) == 0) {
                                Q.add(ch);
                            }
                        }
                        WoInstr[i] = 0;
                    }
                }

                // remove done jobs and fill job queue with new ones
/*
                for (Character j : WoDone) {
                    for (Character ch : E.get(j)) {
                        D.put(ch, D.get(ch) - 1);
                        if (D.get(ch) == 0) {
                            Q.add(ch);
                        }

                    }
                }
*/
            }

            // Time passes
            seconds++;
            // System.out.println(seconds + " sek, Done: " + WoDone);

        }
        PrintWork(seconds, WoInstr, WoDone.toString());
        return seconds;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 07\n");
        Day_07 day_07 = new Day_07();
        String answer1;
        int answer2;
        ArrayList<String> inp = day_07.getInputData();
        answer1 = day_07.day07PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_07.day07PartTwo(inp, 5, 60);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
/*
 * Advent of code 2018, Day 07
 * 
 * Solution Part one: ACBDESULXKYZIMNTFGWJVPOHRQ
 * 
 * 
 */
/*
 * Solution Part two: 433 to low
 * 
 * /* procedure BFS(G, v) is create a queue Q enqueue v onto Q mark v while Q is
 * not empty do w ← Q.dequeue() if w is what we are looking for then return w
 * for all edges e in G.adjacentEdges(w) do x ← G.adjacentVertex(w, e) if x is
 * not marked then mark x enqueue x onto Q return null
 * 
 **/