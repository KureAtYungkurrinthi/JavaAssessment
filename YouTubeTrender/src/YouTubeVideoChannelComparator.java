import java.util.Comparator;

/**
 * Comparator for comparing two YouTube videos by their channel titles.
 * This will allow sorting of a list of YouTube videos in alphabetical order of their channel titles.
 */
public class YouTubeVideoChannelComparator implements Comparator<YouTubeVideo> {

    /**
     * Compares two YouTube videos based on their channel titles.
     *
     * @param o1 the first YouTube video to compare
     * @param o2 the second YouTube video to compare
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(YouTubeVideo o1, YouTubeVideo o2) {
        return o1.getChannelTitle().compareTo(o2.getChannelTitle());
    }
}