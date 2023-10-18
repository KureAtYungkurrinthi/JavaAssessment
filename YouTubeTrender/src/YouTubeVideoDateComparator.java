import java.util.Comparator;

/**
 * Comparator for comparing two YouTube videos by their published dates.
 * This will allow sorting of a list of YouTube videos in chronological order of their publication.
 */
public class YouTubeVideoDateComparator implements Comparator<YouTubeVideo> {

    /**
     * Compares two YouTube videos based on their published dates.
     *
     * @param o1 the first YouTube video to compare
     * @param o2 the second YouTube video to compare
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(YouTubeVideo o1, YouTubeVideo o2) {
        return o1.getPublishedAt().compareTo(o2.getPublishedAt());
    }
}