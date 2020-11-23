package main;

/**
 * Day_09 https://adventofcode.com/2018/day/9
 */
public class Day_09 {
    class Game {
        Marble currentMarble;
        int noOfMarbles = 0;

        public Game() {
            this.currentMarble = new Marble();
            noOfMarbles = 1;
        }

        public void add(long nr) {
            Marble m = new Marble(currentMarble.next, currentMarble.next.next, nr);
            m.previous.next = m;
            m.next.previous = m;
            noOfMarbles++;
            currentMarble = m;
        }

        public long pick7() {
            Marble m = currentMarble;
            for (int i = 0; i < 7; i++)
                m = m.previous;
            m.previous.next = m.next;
            m.next.previous = m.previous;
            currentMarble = m.next;
            noOfMarbles--;
            return m.number;
        }

        public void print() {
            Marble m = currentMarble;
            for (int i = 0; i < noOfMarbles; i++) {
                m = m.next;
                System.out.print(m.number + ", ");
            }
            System.out.println();
        }
    }

    class Marble {
        Marble previous;
        Marble next;
        long number;

        public Marble(Marble p, Marble n, long number) {
            this.previous = p;
            this.next = n;
            this.number = number;
        }

        public Marble() {
            this.previous = this;
            this.next = this;
            this.number = 0;
        }
    }

    public long day09PartOne(int noOfPlayers, int points) {
        Game game = new Game();
        long[] player = new long[noOfPlayers];
        int cp = -1;
        for (int i = 1; i <= points; i++) {
            cp = (i % noOfPlayers) == 0 ? noOfPlayers : (i % noOfPlayers);
            // if i % 23
            if (i % 23 == 0) {
                player[cp - 1] += i;
                player[cp - 1] += game.pick7();
            } else {
                game.add(i);
            }
        }
        long w = maxPoints(player);

        return w;
    }

    private long maxPoints(long[] player) {
        long max = -1;
        for (int i = 0; i < player.length; i++)
            if (player[i] > max) {
                max = player[i];
            }
        return max;
    }

    public static void main(String[] args) {
        Day_09 day_09 = new Day_09();
        long answer1, answer2;
        answer1 = day_09.day09PartOne(463, 71787);
        answer2 = day_09.day09PartOne(463, 7178700);
        System.out.println("\n\nAdvent of code 2018, Day 09\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}


/*
Advent of code 2018, Day 09

Solution Part one: 396136
Solution Part two: 3183301184
*/