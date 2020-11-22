package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_08 https://adventofcode.com/2018/day/8/
 * 
 */
public class Day_08 {

    String inputFile = "input\\input_08.txt";
    public ArrayList<Integer> input;

    public int dataSum = 0;

    class Node {
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Integer> metaData = new ArrayList<Integer>();

        public void addNode(Node node) {
            nodes.add(node);
        }

        public void addData(Integer data) {
            metaData.add(data);
        }
    }

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_08.class.getResourceAsStream(inputFile));
        ArrayList<Integer> inp = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        inputScanner.close();
        this.input = inp;
    }

    private int createTree(Node parentNode, int startPos) {
        // get header
        int noOfNodes = this.input.get(startPos);
        int noOfData = this.input.get(startPos + 1);
        int pos = startPos + 2;
        for (int n = 0; n < noOfNodes; n++) {
            Node node = new Node();
            pos = createTree(node, pos);
            parentNode.addNode(node);
        }
        for (int d = 0; d < noOfData; d++) {
            parentNode.addData(this.input.get(pos + d));
            dataSum += this.input.get(pos + d);
        }
        return pos + noOfData;
    }

    private int countMetadataSum(int startPos) {
        // get header
        int noOfNodes = this.input.get(startPos);
        int noOfData = this.input.get(startPos + 1);
        int pos = startPos + 2;
        for (int n = 0; n < noOfNodes; n++) {
            pos = countMetadataSum(pos);
        }
        for (int d = 0; d < noOfData; d++) {
            dataSum += this.input.get(pos + d);
        }
        return pos + noOfData;
    }

    public int countNodeValue(Node node) {
        int val = 0;
        // no child nodes
        if (node.nodes.size() == 0) {
            for (int v : node.metaData) {
                val += v;
            }
        } else {
            for (int n : node.metaData) {
                try {
                    val += countNodeValue(node.nodes.get(n-1));
                } catch (IndexOutOfBoundsException error) {
                    //Ignore non existing nodes
                }
            }
        }
        return val;
    }

    public int day08PartOne() {
        countMetadataSum(0);
        return dataSum;
    }

    public int day08PartTwo() {
        Node root = new Node();
        createTree(root, 0);
        int val = countNodeValue(root);
        return val;
    }

    public static void main(String[] args) {

        Day_08 day_08 = new Day_08();
        int answer1, answer2;
        day_08.getInputData();
        answer1 = day_08.day08PartOne();
        answer2 = day_08.day08PartTwo();
        System.out.println("\n\nAdvent of code 2018, Day 08\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}


/*
Advent of code 2018, Day 08

Solution Part one: 41521
Solution Part two: 19990
*/