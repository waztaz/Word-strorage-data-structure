package org.example.hash_words;

/*
Created by Jonathan Henley jth106
this class uses arraylist as a parent class with the methods below to modify it's behavior to suit the needs of determining
the frequency of word usage
 */
import java.util.*;


public class FrequencyArray extends ArrayList{
    public FrequencyArray(){
        super();
    }

    //this method creates a new WordFrequency element and either adds it to the Array or increases the frequency of its duplicate
    public void add(String word){
        WordFrequency temp = new WordFrequency(word);
        int compare = this.contains(temp);
        if(compare >= 0 ){
            ((WordFrequency)(this.get(compare))).incrementFrequency();
        }
        else{
            this.add(temp);
        }
    }

    //determines if the list contains a word see Word Frequency class for altered equals() method
    public int contains(WordFrequency temp){
        Iterator<WordFrequency> iterator = this.iterator();
        while(iterator.hasNext()) {
            WordFrequency next = iterator.next();
            if (next.equals(temp)) {
                return this.indexOf(next);
            }
        }
        return -1;
    }

    //This method prints out and returns the frequency of an entered word. Note capitalization is considered
    public int find(String word){
        Iterator<WordFrequency> iterator = this.iterator();
        int max = 1;
        while(iterator.hasNext()){
            WordFrequency next = iterator.next();
            if(next.getWord().equals(word)){
                max = next.getFrequency();
            }
        }
        System.out.println("the frequency of " + "\"" + word + "\"" + " is " + max);
        return max;
    }

    //determines the most frequently used word then prints out and returns it's frequency
    public int findLargest(){
        Iterator<WordFrequency> iterator = this.iterator();
        int max = 1;
        String largest = "";
        while(iterator.hasNext()){
            WordFrequency next = iterator.next();
            //System.out.println(next.getWord() + " frequency = " + next.getFrequency());
            if(next.getFrequency() > max){
                max = next.getFrequency();
                largest = next.getWord();
            }
        }
        System.out.println("the most common word is: " + "\"" + largest + "\"" + " which was written " + max + " times");
        return max;
    }



}
