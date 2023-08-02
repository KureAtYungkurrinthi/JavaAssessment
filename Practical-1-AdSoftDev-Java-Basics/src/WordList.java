import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        if (size() == 0)
            return "-";
        else
            return theWordList.get(0);
    }

    /**
     * Gets the last word of this WordList,
     *
     * @return the last word of the list, or "-" if the list is empty
     */
    public String getLast() {
        if (size() == 0)
            return "-";
        else
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

    public double getAvgLength() {
        double length = 0;
        for (String word : theWordList)
            length += word.length();
        return length / size();
    }

    public void sortByLength() {
        Collections.sort(theWordList, new WordListComparator());
    }
}

class WordListComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}