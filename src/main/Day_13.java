package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import java.awt.Point;

/**
 * Day_13 https://adventofcode.com/2018/day/13
 */
public class Day_13 {
    public String inputFile = "input\\input_13.txt";
    private ArrayList<char[]> map = new ArrayList<char[]>();
    private ArrayList<cart> carts = new ArrayList<cart>();

    public enum DIRECTION {
        UP(0), RIGHT(1), DOWN(2), LEFT(3);

        private final int value;

        DIRECTION(final int v) {
            value = v;
        }

        public int getValue() {
            return value;
        }
    }

    public enum TURN {
        LEFT(-1), STRAIGHT(0), RIGHT(1);

        private final int value;

        TURN(final int v) {
            value = v;
        }

        public int getValue() {
            return value;
        }
    }

    public class cart implements Comparable<cart> {
        private int x;
        private int y;
        private boolean onTrack;
        private DIRECTION direction; // enum
        private TURN nextTurn; //
        private ArrayList<char[]> map;

        @Override
        public int compareTo(cart c) {

            if (this.y < c.y)
                return -1;
            else if (this.y > c.y)
                return 1;
            else {
                if (this.x < c.x)
                    return -1;
                else if (this.x > c.x)
                    return 1;
                else
                    return 0;
            }
        }

        public cart(int x, int y, char direction, ArrayList<char[]> map) {
            this.x = x;
            this.y = y;
            this.onTrack = true;
            switch (direction) {
                case '<':
                    this.direction = DIRECTION.LEFT;
                    break;
                case '>':
                    this.direction = DIRECTION.RIGHT;
                    break;
                case '^':
                    this.direction = DIRECTION.UP;
                    break;
                case 'v':
                    this.direction = DIRECTION.DOWN;
                    break;
                default:
                    break;
            }
            this.nextTurn = TURN.LEFT;
            this.map = map;
        }

        public void move() {

            char ch = ' ';
            switch (this.direction) {
                case LEFT:
                    this.x = x - 1;
                    ch = map.get(this.y)[this.x];
                    switch (ch) {
                        case '\\':
                            this.direction = DIRECTION.UP;
                            break;
                        case '/':
                            this.direction = DIRECTION.DOWN;
                            break;
                        case '+':
                            this.direction = getNextDirection(this.direction, this.nextTurn);
                            this.nextTurn = getNextTurn(this.nextTurn);
                        default:
                    }
                    break;
                case RIGHT:
                    this.x = x + 1;
                    ch = map.get(this.y)[this.x];
                    switch (ch) {
                        case '\\':
                            this.direction = DIRECTION.DOWN;
                            break;
                        case '/':
                            this.direction = DIRECTION.UP;
                            break;
                        case '+':
                            this.direction = getNextDirection(this.direction, this.nextTurn);
                            this.nextTurn = getNextTurn(this.nextTurn);
                        default:

                    }
                    break;
                case UP:
                    this.y = y - 1;
                    ch = map.get(this.y)[this.x];
                    switch (ch) {
                        case '\\':
                            this.direction = DIRECTION.LEFT;
                            break;
                        case '/':
                            this.direction = DIRECTION.RIGHT;
                            break;
                        case '+':
                            this.direction = getNextDirection(this.direction, this.nextTurn);
                            this.nextTurn = getNextTurn(this.nextTurn);
                        default:
                    }
                    break;
                case DOWN:
                    this.y = y + 1;
                    ch = map.get(this.y)[this.x];
                    switch (ch) {
                        case '\\':
                            this.direction = DIRECTION.RIGHT;
                            break;
                        case '/':
                            this.direction = DIRECTION.LEFT;
                            break;
                        case '+':
                            this.direction = getNextDirection(this.direction, this.nextTurn);
                            this.nextTurn = getNextTurn(this.nextTurn);
                        default:
                    }
                    break;
                default:
                    // code block

            }

        }

        private DIRECTION getNextDirection(DIRECTION direction2, TURN nextTurn2) {
            return DIRECTION.values()[Math.floorMod(direction2.getValue() + nextTurn2.getValue(), 4)];
        }

        private TURN getNextTurn(TURN nextTurn2) {
            switch (nextTurn2) {
                case LEFT:
                    return TURN.STRAIGHT;

                case STRAIGHT:
                    return TURN.RIGHT;

                case RIGHT:
                    return TURN.LEFT;

                default:
                    return nextTurn2;
            }
        }

    }

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_13.class.getResourceAsStream(inputFile));
        int l = 0;
        while (inputScanner.hasNext()) {

            String line = inputScanner.nextLine();
            char[] chararray = new char[line.length()];
            int c = 0;
            char r;
            for (char ch : line.toCharArray()) {
                switch (ch) {
                    case '<':
                        r = '-';
                        System.out.println("< : " + c + "," + l);
                        break;
                    case '>':
                        r = '-';
                        System.out.println("> : " + c + "," + l);
                        break;
                    case '^':
                        r = '|';
                        System.out.println("^ : " + c + "," + l);
                        break;
                    case 'v':
                        r = '|';
                        System.out.println("v : " + c + "," + l);
                        break;
                    default:
                        r = ch;
                }
                if (r != ch)
                    this.carts.add(new cart(c, l, ch, this.map));

                chararray[c] = r;
                c++;
            }

            this.map.add(chararray);
            l++;

        }
        System.out.println();
        inputScanner.close();
    }

    public String day13PartOne() {

        boolean crash = false;
        int crashX = -1;
        int crashY = -1;
        while (!crash) {
            // sortera carts
            carts.sort(null);

            for (cart c : carts) {
                c.move();
                // System.out.println(c.direction + " " + c.nextTurn + " " + c.x + " " + c.y);
                for (cart cart1 : carts) {
                    if (cart1 != c && cart1.x == c.x && cart1.y == c.y) {
                        crash = true;
                        crashX = c.x;
                        crashY = c.y;
                        break;
                    }
                    if (crash)
                        break;
                }
            }
        }
        // System.out.println(crashX + "," + crashY);
        return crashX + "," + crashY;
    }

    public String day13PartTwo() {
        int nrOfChart = carts.size();
        while (nrOfChart > 1) {
            // sortera carts
            carts.sort(null);
            for (cart c : carts) {
                if (c.onTrack) {
                    c.move();
                    for (cart cart1 : carts) {
                        if (cart1.onTrack) {
                            if (cart1 != c && cart1.x == c.x && cart1.y == c.y) {
                                {
                                    // carts.remove(cart1);
                                    // carts.remove(c);
                                    cart1.onTrack = false;
                                    c.onTrack = false;
                                    nrOfChart -= 2;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        int posx = -1, posy = -1;
        for (cart l : carts) {
            if (l.onTrack) {
                posx = l.x;
                posy = l.y;
            }
        }
        return posx + "," + posy;

    }

    public static void main(String[] args) {
        Day_13 day_13 = new Day_13();
        String answer1, answer2;
        day_13.getInputData();
        answer1 = day_13.day13PartOne();

        answer2 = day_13.day13PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 13\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
/*
 * Part two fail: (You guessed 128,110.)
 * (You guessed 128,111.)
 */