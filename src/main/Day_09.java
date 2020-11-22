package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_09
 * https://adventofcode.com/2018/day/9
 */
public class Day_09 {

    public int day09PartOne(int noOfPlayers, int points) {
        
        ArrayList<Integer> game = new ArrayList<Integer>();
        game.add(0);
        int currentMarble = 0;
        int[] player = new int[noOfPlayers];
        for (int i=1;i<=points;i++)
        {
            int currentPlayer = i % noOfPlayers;
            // if i % 23
            game.add((currentMarble+2)%game.size(), i);
            System.out.println(currentPlayer + " -- " + game); 
        } 
        
        
        int sum = 0;
        return sum;
    }

    public int day09PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_09 day_09 = new Day_09();
        int answer1, answer2;
        
        //answer1 = day_09.day09PartOne(463, 71787);
        answer1 = day_09.day09PartOne(463, 71787);
        answer2 = day_09.day09PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 09\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
