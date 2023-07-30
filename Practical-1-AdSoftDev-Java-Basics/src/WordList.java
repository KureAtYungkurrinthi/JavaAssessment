import java.util.ArrayList;
import java.util.Collections;

public class WordList {
    private final ArrayList<String> theWordList = new ArrayList<>();

    /**
     * Adds a word to this wordlist
     *
     * @param s the word to add
     */
    public void addWord(String s) {
        theWordList.add(s);
    }

    /**
     * Gets the first word of this WordList,
     *
     * @return the first word of the list, or "-" if the list is empty
     */
    public String getFirst() {
        return theWordList.get(0);
    }

    /**
     * Gets the last word of this WordList,
     *
     * @return the last word of the list, or "-" if the list is empty
     */
    public String getLast() {
        return theWordList.get(size() - 1);
    }

    /**
     * @return a String representation of this WordList
     */
    public String toString() {
        return theWordList.toString();
    }

    /**
     * @return the number of elements in this WordList
     */
    public int size() {
        return theWordList.size();
    }

    public void sortAlpha() {
        Collections.sort(theWordList);
    }
}