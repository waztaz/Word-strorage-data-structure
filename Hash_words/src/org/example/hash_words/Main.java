package org.example.hash_words;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.*;
import java.io.IOException;
/*
The main class contains two function main and read. The read function uses the Scanner class to read the file.
It parses only words in the text file (ignoring numbers and punctuation).
It then stores all the words in the array called token. Each word in token is then traversed
to build the different data structures and then the relevant functions are applied on the data structures.
The time is noted for each function and outputted. The main function passes the three files to the read function
and produces the output which is given below.
 */

public class Main {
    /*
    This method parses through the file that is written in the main method then sends the words to the custom hashtable
    After completing the building of the hashtable it then prints out a word to show that it has the frequency analysis for all of the words
    After that it also prints out the most common word and its frequency
     */
    public static void read(File file) throws IOException {
        CustomHashtable table = new CustomHashtable();
        FrequencyArray array = new FrequencyArray();
        Custom_BST tree = new Custom_BST();

        Scanner scanner = new Scanner(file);
        long startTime1, stopTime1;
        ArrayList<String> tokens = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            String [] raza =scanner.nextLine().split("[^\\w']+]*");
            for (int x=0; x<raza.length;x++)
                tokens.add(raza[x].toLowerCase());
        }
        startTime1 = System.currentTimeMillis();
        for (int i = 0; i < tokens.size(); i++) {
            array.add(tokens.get(i));
        }
        array.findLargest();
        stopTime1 = System.currentTimeMillis();
        System.out.println("time to create and find the most frequent word in a arraylist in milliseconds = " + (stopTime1 - startTime1));

        startTime1 = System.currentTimeMillis();
        array.find("horatio");
        stopTime1 = System.currentTimeMillis();
        System.out.println("time to find and print a randomly chosen word = " + (stopTime1 - startTime1)); //note this is representative not actually an average

        startTime1 = System.currentTimeMillis();
        for (int i = 0; i < tokens.size(); i++) {
            tree.insert(tokens.get(i));
        }
        tree.find_max();
        stopTime1 = System.currentTimeMillis();
        System.out.println("time to create and find the most frequent word in a Binary Search Tree in milliseconds = " + (stopTime1 - startTime1));

        startTime1 = System.currentTimeMillis();
        System.out.println("the occurrence of the word  horatio: " + tree.find("horatio"));
        stopTime1 = System.currentTimeMillis();
        System.out.println("time to find and print a randomly chosen word " + (stopTime1 - startTime1));

        startTime1 = System.currentTimeMillis();
        for (int i = 0; i < tokens.size(); i++) {
            table.put(tokens.get(i));
        }
        System.out.println();
        table.findLargest(); //this function returns the largest word as well as printing out the solution
        int horatioFrequency = (int) table.get("horatio");
        stopTime1 = System.currentTimeMillis();
        System.out.println("time to create and find the most frequent word in a Hashtable in milliseconds = " + (stopTime1 - startTime1));

        startTime1 = System.currentTimeMillis();
        System.out.println("the occurrence of the word  horatio: " + table.get("horatio"));  //this is here to show that any word can be accessed with its information
        System.out.println("time to find and print a random word from the hashtable milliseconds = " + (stopTime1 - startTime1));
        System.out.println();

    }
    /*
    main method takes written file and calls the read method above
     */
    public static void main(String[] args) {
        File sourcefile1 = new File("files/1000 words.txt");
        System.out.println("The following data is the time it takes each of these data structures to operate with 1000 words:" + "\n");
        try {
            read(sourcefile1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The following data is the time it takes each of these data structures to operate with 10,000 words:" + "\n");
        File sourcefile2 = new File("files/10,000 words.txt");
        try {
            read(sourcefile2);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The following data is the time it takes each of these data structures to operate with 100,000 words:" + "\n");
        File sourcefile3 = new File("files/100,000 words.txt");
        try {
            read(sourcefile3);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Special thanks to william shakespeare for providing a never ending supply of words");
    }
}