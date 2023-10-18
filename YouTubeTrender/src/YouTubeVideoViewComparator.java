import java.util.Comparator;

/**
 * Comparator for comparing two YouTube videos by their view counts.
 * This will allow sorting of a list of YouTube videos in order of their view counts.
 */
public class YouTubeVideoViewComparator implements Comparator<YouTubeVideo> {

    /**
     * Compares two YouTube videos based on their view counts.
     *
     * @param o1 the first YouTube video to compare
     * @param o2 the second YouTube video to compare
     * @return a negative integer, zero, or a positive integer as the first argument has fewer, equal, or more views than the second.
     */
    @Override
    public int compare(YouTubeVideo o1, YouTubeVideo o2) {
        return Integer.compare(o1.getViewCount(), o2.getViewCount());
    }
}