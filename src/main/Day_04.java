package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Day_04
 */
public class Day_04 {

    String inputFile = "input\\input_04.txt";

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_04.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            inp.add(inputScanner.nextLine());
        }
        inputScanner.close();

        processinputData(inp);
        //log.entrySet().stream().sorted(Map.Entry.<Date,String>comparingByKey()).forEach(action);;
        return inp;
    }

    public void processinputData(ArrayList<String> inp) {
        //DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Map<Date, String> log = new HashMap<Date, String>();

        inp.sort(Comparator.naturalOrder());
        
        for (String str : inp) {
            //Pattern p = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})\\]");
            Pattern p = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2}) (\\d{2}):(\\d{2})\\] (falls asleep|wakes up|Guard #\\d{1,})");
            Matcher m = p.matcher(str);
            if (m.find()) {
                String dateStr = m.group(1);
                String hr = m.group(2);
                String min = m.group(3);
                String action = m.group(4);
                try {
                    Date date = format.parse(dateStr);
                    System.out.println(date + " -- " + hr + " -- " + min + " -- " + action );
                    log.put(date, str);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }

    public int day04PartOne() {
        int sum = -1;
        return sum;
    }

    public int day04PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 04\n");
        Day_04 day = new Day_04();
        int answer1, answer2;
        ArrayList<String> inp = day.getInputData();
        answer1 = day.day04PartOne();
        System.out.println("Solution Part one: " + answer1);
        answer2 = day.day04PartTwo();
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }

    private class Asleep {

        int Month;
        int Day;
        int ID;
        char isAsleep;

        public void Asleep(int month, int day, int id, char isAsleep) {
            this.Month = month;
            this.Day = day;
            this.ID = id;
            this.isAsleep = isAsleep;
        }

    }

}
