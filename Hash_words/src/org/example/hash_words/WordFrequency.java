package org.example.hash_words;

/*
Jonathan Henley jth106
This class is here to create the individual elements in the Frequency array it stores the word and it's frequency as well
as get and increment functions for ease of use this class also contains an equals methood in order to compare
different WordFrequency elements
 */
public class WordFrequency {
    private String word;
    private int frequency;

    public WordFrequency(String word){
        this.word = word;
        frequency = 1;
    }

    public String getWord(){
        return word;
    }

    public int getFrequency(){
        return frequency;
    }

    //compares WordFrequency's based on the words that they contain
    public boolean equals(WordFrequency temp){
        String word1 = this.getWord();
        String word2 = temp.getWord();
        if(word1.equals(word2)){
            return true;
        }
        else{
            return false;
        }
    }

    //increases the frequency by one with every call
    public void incrementFrequency(){
        frequency += 1;
    }

}
