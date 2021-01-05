/*
package IE3_ADL_LAB4.com.mhelghamrawy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

*/
/**
 * Keep a record of how many times each word was
 * entered by users.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    1.0 (2016.02.29)
 *//*

public class WordCounter<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    // Associate each word with a count.
    // private HashMap<String, Integer> counts;
    private HashMap<Integer, HashSet<String> > inverted;

    @Override
    public void put(Key key, Value val) {

    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    */
/**
     * Create a WordCounter
     *//*

    public WordCounter()
    {
        updateInverted(); //instance variable
    }

    */
/**
     * Update the usage count of all words in input.
     * @param input A set of words entered by the user.
     *//*

    public void addWords(HashSet<String> input)
    {
        for(String word : input) {
            addWord(word);
        }
    }

    */
/**
     * Method addWord and update the counts of all words
     *
     * @param word A word to be added
     *//*

    public void addWord(String word)
    {
        Value counter = get( (Key) word);
        // get(word) would return null if word is not in the counts HashMap
        // but we want to get returned 0 it word is not ... " ....
        // getOrDefault(word, 999) will return 999 if word is not ... " ....
        put(word, (Value) counter + 1);
        updateInverted();
    }
    
    */
/**
     * get all words
     *
     * @return the set of all words
     *//*

    public HashSet<String> getWords()
    {
        HashSet<String> set= new HashSet<String>(counts.keySet()); // uses HashSet's copy contructor
        return set;
    }

    private void updateInverted() // allways to be called after changing counts!!
    // in order to keep inverted consistent!!!
    {
        inverted = new HashMap<Integer, HashSet<String> >();
        // counts.keySet() returns all the words in the HashMap keys
        for (String word: counts.keySet()){
            int counter= counts.get(word); // returns the number of occurencies of the word
            // i.e. the y-values in the histogram !
            HashSet<String> tmp= inverted.get(counts.get(word));// returns the hashSet of words 
            // in inverted for the y-value 
            // or null if that integer is not in the keys of inverted
            if(tmp == null) tmp= new HashSet<String>();
            // inverted.getOrDefault(counter, new HashSet<String>());
            tmp.add(word);
            inverted.put(counter, tmp);
        }
    }

    */
/**
     * Method calculateInverted 
     * to demonstrate the implementation of problems 8,9 in Lab 3
     * contains redundant code taken from method private updateInverted
     * Think the HashMap in terms of Histogram and inverted Histogram (sketch in the lecture)
     *
     * @return The return value
     *//*

    public HashMap<Integer, HashSet<String> > calculateInverted()
    {
        HashMap<Integer, HashSet<String> > inverted 
        = new HashMap<Integer, HashSet<String> >();
        // counts.keySet() returns all the words in the HashMap keys
        for (String word: counts.keySet()){
            int counter= counts.get(word); // returns the number of occurencies of the word
            // i.e. the y-values in the histogram !
            HashSet<String> tmp= inverted.get(counts.get(word));// returns the hashSet of words 
            // in inverted for the y-value 
            // or null if that integer is not in the keys of inverted
            if(tmp == null) tmp= new HashSet<String>();
            // inverted.getOrDefault(counter, new HashSet<String>()); // replaces the last 2 lines
            tmp.add(word);
            inverted.put(counter, tmp);
        }
        return inverted;
    }

    */
/**
     * print the HashMap containing the counted words
     *
     *//*

    public void print()
    {
        System.out.println(counts);
        System.out.println(inverted);
    }
}
*/
