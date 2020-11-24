package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.awt.Point;

/**
 * Day_10
 */
public class Day_10 {

    String inputFile = "input\\input_10.txt";
    ArrayList<String> input;

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_10.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            inp.add(inputScanner.nextLine());
        }
        inputScanner.close();

        this.input = inp;

        return inp;
    }

    public int day10PartOne() {

        List<Point> p = new ArrayList<Point>(); // Star positioin
        List<Point> v = new ArrayList<Point>(); // Star velocity

        for (String s : input) {
            String[] split = s.split("[<>,]");
            int px = Integer.parseInt(split[1].strip());
            int py = Integer.parseInt(split[2].strip());
            int vx = Integer.parseInt(split[4].strip());
            int vy = Integer.parseInt(split[5].strip());
            p.add(new Point(px, py));
            v.add(new Point(vx, vy));
        }
        boolean done = false;
        int s = 0;
        int minsize = Integer.MAX_VALUE;
        int lastsize = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        while (!done) {
            
            maxX = Integer.MIN_VALUE;
            maxY = Integer.MIN_VALUE;
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            for (int i = 0; i < p.size(); i++) {
                int nx = p.get(i).x + v.get(i).x;
                int ny = p.get(i).y + v.get(i).y;
                p.get(i).x = nx;
                p.get(i).y = ny;
                maxX = Integer.max(maxX, nx);
                maxY = Integer.max(maxY, ny);
                minX = Integer.min(minX, nx);
                minY = Integer.min(minY, ny);

            }
            int size = (maxX - minX);
            if (minsize == Integer.min(minsize, size)) {
                break;
            } else {
                minsize = Integer.min(minsize, size);
            }
            s++;
        }

        //reverse one sec
        for (int i = 0; i < p.size(); i++) {
            int nx = p.get(i).x - v.get(i).x;
            int ny = p.get(i).y - v.get(i).y;
            p.get(i).x = nx;
            p.get(i).y = ny;
        }
    

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {

                if (p.contains(new Point(x, y))) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
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
        ArrayList<String> inp = day_10.getInputData();
        answer1 = day_10.day10PartOne();

        answer2 = day_10.day10PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 10\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2018, Day 10

Solution Part one: RPNNXFZR
Solution Part two: 0
/*
/*
........................................................................
........................................................................
........................................................................
........................................................................
........................................................................
.....#####...#####...#....#..#....#..#....#..######..######..#####......
.....#....#..#....#..##...#..##...#..#....#..#............#..#....#.....
.....#....#..#....#..##...#..##...#...#..#...#............#..#....#.....
.....#....#..#....#..#.#..#..#.#..#...#..#...#...........#...#....#.....
.....#####...#####...#.#..#..#.#..#....##....#####......#....#####......
.....#..#....#.......#..#.#..#..#.#....##....#.........#.....#..#.......
.....#...#...#.......#..#.#..#..#.#...#..#...#........#......#...#......
.....#...#...#.......#...##..#...##...#..#...#.......#.......#...#......
.....#....#..#.......#...##..#...##..#....#..#.......#.......#....#.....
.....#....#..#.......#....#..#....#..#....#..#.......######..#....#.....
........................................................................
........................................................................
........................................................................
........................................................................
........................................................................


*/