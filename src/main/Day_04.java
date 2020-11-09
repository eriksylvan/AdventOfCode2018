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
        return inp;
    }

    protected Map<Integer, int[]> processinputData(ArrayList<String> inp) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Map<Date, String> log = new HashMap<Date, String>();
        Map<Integer, int[]> guards = new HashMap<Integer, int[]>();
        inp.sort(Comparator.naturalOrder());
        int gn = 0;
        int mm = 0;
        for (String str : inp) {
            // Pattern p = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})\\]");
            // Pattern p = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2}) (\\d{2}):(\\d{2})\\]
            // (falls asleep|wakes up|Guard #\\d{1,})");
            Pattern p = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2}) (\\d{2}):(\\d{2})\\] (.).+(?:#|p)(\\d{1,})?");
            Matcher m = p.matcher(str);

            if (m.find()) {
                String dateStr = m.group(1);
                // String hr = m.group(2);
                int min = Integer.parseInt(m.group(3));
                String action = m.group(4);
                int guardNo = (m.group(5) != null) ? Integer.parseInt(m.group(5)) : 0;
                try {
                    Date date = format.parse(dateStr);
                    log.put(date, str);
                    if (action.equals("G")) {
                        mm = 0;
                        gn = guardNo;
                        guards.putIfAbsent(guardNo, new int[60]);
                    }
                    if (action.equals("f")) {
                        mm = min;
                    }
                    if (action.equals("w")) {
                        for (int i = mm; i < min; i++) {
                            guards.get(gn)[i] = guards.get(gn)[i] + 1;
                        }
                    }

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return guards;
    }

    public int day04PartOne(ArrayList<String> inputData) {
        Map<Integer, int[]> guards = this.processinputData(inputData);

        int mostTiredGuard = 0;
        int maxSleepMinTot = 0;
        int maxSleepMin = 0;

        for (Map.Entry<Integer, int[]> pair : guards.entrySet()) {
            int sleepMin = 0;
            int maxMin = 0;
            int maxMinPos = 0;
            for (int i = 0; i < 60; i++) {
                sleepMin = sleepMin + pair.getValue()[i];
                if (pair.getValue()[i] > maxMin) {
                    maxMin = pair.getValue()[i];
                    maxMinPos = i;
                }
            }
            if (sleepMin > maxSleepMinTot) {
                maxSleepMinTot = sleepMin;
                mostTiredGuard = pair.getKey();
                maxSleepMin = maxMinPos;
            }
        }
        return mostTiredGuard * maxSleepMin;
    }

    public int day04PartTwo(ArrayList<String> inputData) {
        Map<Integer, int[]> guards = this.processinputData(inputData);
        int maxGuardMaxMin = 0;
        int maxSleepMin = 0;
        int mostTiredGuard = 0;
        for (Map.Entry<Integer, int[]> pair : guards.entrySet()) {
            int maxMin = 0;
            int maxMinPos = 0;
            for (int i = 0; i < 60; i++) {
                if (pair.getValue()[i] > maxMin) {
                    maxMin = pair.getValue()[i];
                    maxMinPos = i;
                }
            }
            if (maxMin > maxGuardMaxMin) {
                mostTiredGuard = pair.getKey();
                maxSleepMin = maxMinPos;
                maxGuardMaxMin = maxMin;
            }   
        }
        return mostTiredGuard * maxSleepMin;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2018, Day 04\n");
        Day_04 day = new Day_04();
        int answer1, answer2;
        ArrayList<String> inp = day.getInputData();
        answer1 = day.day04PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day.day04PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/********
 * Advent of code 2018, Day 04
 *
 * Solution Part one: 36898
 * Solution Part two: 80711
 */