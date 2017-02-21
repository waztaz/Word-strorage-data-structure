package org.example.hash_words;

//Jonathan Henley jth106 12/4/2016
//this class extends the Hastable class in order to create a hastable of words and their frequency

import java.util.*;

public class CustomHashtable extends Hashtable {

    public CustomHashtable(){
        super();
    }

    public CustomHashtable(int size){
        super(size);
    }

    /*this program only takes a single string as it's input and then uses it as the key in the hastable
    it then checks to see if the table contains a given word then either increases its occurence or adds the word to the table */
    public void put(String key){
        if(containsKey(key)){
            super.put(key, ((int) get(key)) + 1);
        }
        else{
            super.put(key, 1);
        }
    }
    /*
    finds and prints out the most frequently used word as well as how many times it was used
    it also returns the most frequently used word in case that need arises
     */
    public String findLargest(){
        Set<String> keys = this.keySet();      //this code uses a list of the keys to find the most common word
        Iterator<String> iterator = keys.iterator();
        int max = 1;
        String largest = "";
        while(iterator.hasNext()){
            String next = iterator.next();
            //System.out.println(next);
            if((int) this.get(next) > max){
                max = (int) this.get(next);
                largest = next;
            }
        }
        System.out.println("the most common word is: " + "\"" + largest + "\"" + " which was written " + max + " times");
        return largest;
    }

}
