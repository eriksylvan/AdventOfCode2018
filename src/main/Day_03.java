package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Day_03
 */

class Claim {
    int nr;
    int x;
    int y;
    int w;
    int h;

    public void Claim(int number, int posX, int posY, int width, int height) {
        nr = number;
        x = posX;
        y = posY;
        w = width;
        h = height;
    }

}

public class Day_03 {

    String inputFile = "input\\input_03.txt";

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_03.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            inp.add(inputScanner.nextLine());
        }
        inputScanner.close();
        return inp;
    }

    public int day03PartOne(ArrayList<String> claimInput) {
        int sum = 0;

        int[][] map = new int[1100][1100];
        
        System.out.println(map[1][2]);
        ArrayList<int[]> lst = new ArrayList<int[]>();
        for (String str : claimInput) {
            Pattern p = Pattern.compile("#(\\d+)\\s@\\s(\\d+),(\\d+):\\s(\\d+)x(\\d+)");
            Matcher m = p.matcher(str);
            if (m.find()) {
                int n = Integer.parseInt(m.group(1));
                int x = Integer.parseInt(m.group(2));
                int y = Integer.parseInt(m.group(3));
                int w = Integer.parseInt(m.group(4));
                int h = Integer.parseInt(m.group(5));
                for (int i = y;i<(y + h);i++){
                    for (int j = x;j<(x + w);j++){
                        if (map[i][j]==1){
                            sum++;
                        }
                        map[i][j]=map[i][j]+1;                       
                    }
                }



            } else {
                System.out.println("NO MATCH");
            }

            // save coordinates in ClameList
            // find max x + w and y + h
            // create a matrix big enough Integer[][]
            // iterate through ClaimList, fill matrix with claim
            // at the same time, count every new x


        }

        // Claim a = new
        // Claim((int)m.group(1),(int)m.group(2),(int)m.group(3),(int)m.group(4),m.group(5)));

        return sum;

    }

    public int day03PartTwo() {
        int sum = 0;
        return sum;
    }

   
    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 03\n");
        Day_03 day_03 = new Day_03();
        int answer1, answer2;
        ArrayList<String> inp = day_03.getInputData();
        answer1 = day_03.day03PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_03.day03PartTwo();
        System.out.println("Solution Part two: " + answer2 + "\n\n");
     }
}
