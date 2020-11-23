package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_09 https://adventofcode.com/2018/day/9
 */
public class Day_09 {

    public int day09PartOne(int noOfPlayers, int points) {

        ArrayList<Integer> game = new ArrayList<Integer>();
        game.add(0);
        game.add(1);
        int cp;
        int currentMarble = 1;
        int[] player = new int[noOfPlayers];
        for (int i = 2; i <= points; i++) {
            cp = (i % noOfPlayers) == 0 ? noOfPlayers : (i % noOfPlayers);
            // if i % 23
            if (i % 23 == 0) {
                player[cp - 1] += i;
                int r = (currentMarble - 7) < 0 ? currentMarble - 7 + game.size() : currentMarble - 7;
                player[cp - 1] += game.remove(r);
                currentMarble = r;
            } else {
                currentMarble = (currentMarble + 2);
                if (currentMarble == game.size()) {
                    // add marble in the end
                    game.add(i);
                } else {
                    currentMarble = currentMarble % game.size();
                    game.add((currentMarble), i);
                }
            }

            int gs = game.size();
        }

        int w = maxPoints(player);
        return w;
    }

    private int maxPoints(int[] player) {
        int w = -1;
        int max = -1;
        for (int i=0; i< player.length; i++)
            if (player[i]> max)
            {
                w = i;
                max = player[i];
            }
        return max;
    }

    public int day09PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_09 day_09 = new Day_09();
        int answer1, answer2;

        answer1 = day_09.day09PartOne(463, 71787);
        //answer1 = day_09.day09PartOne(9, 25);
        answer2 = day_09.day09PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 09\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
