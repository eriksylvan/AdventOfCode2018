package main;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Day_13
 * https://adventofcode.com/2018/day/13
 */
public class Day_13 {

    public String inputFile = "input\\input_13.txt";
    private ArrayList<char[]> map = new ArrayList<char[]>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_13.class.getResourceAsStream(inputFile));
        int l=0;
        while (inputScanner.hasNext()) {
            
            String line = inputScanner.nextLine();
            char[] chararray = new char[line.length()];
            int c = 0;
            for (char ch: line.toCharArray()){
                
                switch(ch) {
                    case '<':
                      ch = '-';
                      System.out.println("< : "+c+","+l);
                      break;
                      case '>':
                      ch = '-';
                      System.out.println("> : "+c+","+l);
                      break;
                      case '^':
                      ch = '|';
                      System.out.println("^ : "+c+","+l);
                      break;
                      case 'v':
                      ch = '|';
                      System.out.println("v : "+c+","+l);
                      break; 
                      default:
                      // code block
                      
                }
                chararray[c] = ch; 
                c++;
            }

            this.map.add(chararray);
            l++;
            
        }
        System.out.println();
        inputScanner.close();
    }

    public int day13PartOne() {
        int sum = 0;
        for (char[] s: this.map)
        {
            System.out.println(s);
        }
        return sum;
    }

    public int day13PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_13 day_13 = new Day_13();
        int answer1, answer2;
        day_13.getInputData();
        answer1 = day_13.day13PartOne();
        
        answer2 = day_13.day13PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 13\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
/*
< = -
> = -
v = |
^ = |
*/