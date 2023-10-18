import java.util.Comparator;

/**
 * A Comparator for comparing two YouTube videos based on the number of occurrences of a given word in their description.
 * Useful for sorting a list of YouTube videos based on how frequently the specified word appears in the video's description.
 */
public class YouTubeVideoDescriptionCountComparator implements Comparator<YouTubeVideo> {
    private final String word; // The word used for comparison purposes.

    /**
     * Constructor to initialize the comparator with the word for comparison.
     *
     * @param word The word to check the occurrences for.
     */
    public YouTubeVideoDescriptionCountComparator(String word) {
        this.word = word;
    }

    /**
     * Compares two YouTube videos based on the number of occurrences of the specified word in their descriptions.
     *
     * @param o1 the first YouTube video to compare.
     * @param o2 the second YouTube video to compare.
     * @return a negative integer, zero, or a positive integer as the first argument has fewer, the same, or more occurrences of the word than the second.
     */
    @Override
    public int compare(YouTubeVideo o1, YouTubeVideo o2) {
        int count1 = countOccurrences(o1, word);
        int count2 = countOccurrences(o2, word);
        return Integer.compare(count1, count2);
    }

    /**
     * Count the occurrences of the word in the title and description of the YouTube video.
     *
     * @param video The YouTube video whose title and description are to be checked.
     * @param word  The word for which occurrences need to be counted.
     * @return The number of times the word appears in the video's title and description.
     */
    private int countOccurrences(YouTubeVideo video, String word) {
        int count = 0;
        String[] topics = (video.getTitle() + " " + video.getDescription()).split("\\s+");
        for (String topic : topics)
            if (topic.contains(word))
                count++;
        return count;
    }
}