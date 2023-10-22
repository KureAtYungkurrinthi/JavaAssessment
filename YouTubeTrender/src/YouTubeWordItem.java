import java.util.HashSet;
import java.util.Set;

/**
 * Represents a word item that tracks its occurrences and the videos where it appears.
 */
public class YouTubeWordItem implements Comparable<YouTubeWordItem> {
    private final String word;
    private final Set<YouTubeVideo> videos;
    private int count;

    /**
     * Constructs a YouTubeWordItem with the given word.
     *
     * @param word The word to be tracked.
     */
    public YouTubeWordItem(String word) {
        this.word = word;
        this.count = 0;
        this.videos = new HashSet<>();
    }

    /**
     * Adds a YouTube video where the word appears and increments the count.
     *
     * @param video The video to be added to the list of videos where the word appears.
     */
    public void add(YouTubeVideo video) {
        videos.add(video);
        count++;
    }

    /**
     * Retrieves the occurrence count of the word.
     *
     * @return The number of times the word has appeared.
     */
    public int getCount() {
        return count;
    }

    /**
     * Retrieves the set of YouTube videos where the word appears.
     *
     * @return A set containing the videos where the word appears.
     */
    public Set<YouTubeVideo> getPosts() {
        return videos;
    }

    /**
     * Retrieves the word being tracked by this item.
     *
     * @return The word associated with this item.
     */
    public String getWord() {
        return word;
    }

    /**
     * Provides a string representation of the word item, detailing the word, its occurrences, and the number of videos where it appears.
     *
     * @return A descriptive string representation of the word item.
     */
    @Override
    public String toString() {
        return "Word: " + word + ", Occurrence: " + count + ", Videos: " + videos.size() + "\n";
    }

    /**
     * Compares this word item to another based on their counts.
     *
     * @param o The other YouTubeWordItem to compare with.
     * @return a negative integer, zero, or a positive integer if this item's count is less than, equal to, or greater than the other's count.
     */
    @Override
    public int compareTo(YouTubeWordItem o) {
        return Integer.compare(count, o.getCount());
    }
}