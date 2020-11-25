package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Day_12
 */
public class Day_12 {

    public String inputFile = "input\\input_12.txt";

    public Map<String, String> spread;

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_12.class.getResourceAsStream(inputFile));
        this.spread = new HashMap<String, String>();
        while (inputScanner.hasNext()) {
            String k = inputScanner.next();
            inputScanner.next();
            String v = inputScanner.next();
            this.spread.put(k, v);
        }
        inputScanner.close();
    }

    public int day12PartOne(String gen) {
        //System.out.println("gen: "+0+"startPot: "+0);
        //System.out.println(gen);
        for (int g = 1; g <= 20; g++) {
            gen = "...." + gen + "....";
            String nextGen = new String();
            for (int i = 0; i < gen.length() - 5; i++) {
                String p = gen.substring(i, i + 5);
                String f = this.spread.get(p);
                if ((f != null) && f.equals("#")) {
                    nextGen += "#";
                } else {
                    nextGen += ".";
                }
            }
            gen = nextGen;
            //System.out.println("gen: "+g+"startPot: "+g*-2);
            //System.out.println(gen);
        }

        int sum = 0;
        int i = -40;
        char[] cc = gen.toCharArray();
        for (char ch: gen.toCharArray()) {
            if (ch == '#')
            {
                sum += i; 
            }
            i++;
        }

        return sum;
    }

    public int day12PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_12 day_12 = new Day_12();
        String init = ".#..##..#.....######.....#....####.##.#.#...#...##.#...###..####.##.##.####..######......#..##.##.##";
        int answer1, answer2;
        day_12.getInputData();
        System.out.println(day_12.spread);
        answer1 = day_12.day12PartOne(init);
        answer2 = day_12.day12PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 12\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
