import java.util.*;

/**
 * Indexes a collection of YouTube videos by the words appearing in their title and description.
 * Allows for retrieval of word-related statistics and relevant videos based on a specified word.
 */
public class YouTubeVideoIndexer {
    private final List<YouTubeVideo> items;
    private final Map<String, YouTubeWordItem> words;

    /**
     * Constructs a YouTubeVideoIndexer with the provided list of YouTube videos.
     *
     * @param items The list of YouTube videos to be indexed.
     */
    public YouTubeVideoIndexer(List<YouTubeVideo> items) {
        this.items = items;
        this.words = new HashMap<>();
    }

    /**
     * Indexes the YouTube videos based on the words appearing in their title and description.
     */
    public void index() {
        for (YouTubeVideo video : items) {
            String[] topics = (video.getTitle() + " " + video.getDescription()).split("\\s+");
            for (String topic : topics) {
                YouTubeWordItem wordItem;
                if (words.containsKey(topic)) {
                    wordItem = words.get(topic);
                } else {
                    wordItem = new YouTubeWordItem(topic);
                    words.put(topic, wordItem);
                }
                wordItem.add(video);
            }
        }
    }

    /**
     * Retrieves the YouTubeWordItem associated with the specified word.
     *
     * @param word The word to retrieve the item for.
     * @return The YouTubeWordItem associated with the given word, or null if the word is not indexed.
     */
    public YouTubeWordItem getWord(String word) {
        return words.get(word);
    }

    /**
     * Retrieves the occurrence count of the specified word.
     *
     * @param word The word whose count is to be retrieved.
     * @return The count of the specified word or 0 if the word is not indexed.
     */
    public int getCountByWord(String word) {
        return words.get(word).getCount();
    }

    /**
     * Retrieves a list of YouTube videos sorted by the occurrence count of the specified word in their descriptions.
     *
     * @param word The word to filter and sort the videos by.
     * @return A list of YouTube videos sorted by the occurrence of the specified word.
     */
    public List<YouTubeVideo> getYouTubeVideosByWord(String word) {
        List<YouTubeVideo> videos = new ArrayList<>(words.get(word).getPosts());
        videos.sort(new YouTubeVideoDescriptionCountComparator(word));
        return videos;
    }

    /**
     * Retrieves the most frequently occurring word across all indexed YouTube videos.
     *
     * @return The YouTubeWordItem representing the most frequently occurring word.
     */
    public YouTubeWordItem getMostUsedWord() {
        return Collections.max(words.values());
    }

    /**
     * Retrieves a sorted list of YouTubeWordItems based on their counts.
     *
     * @return A sorted list of YouTubeWordItems in descending order of their counts.
     */
    public List<YouTubeWordItem> getSortedYouTubeWordItems() {
        List<YouTubeWordItem> wordItems = new ArrayList<>(words.values());
        Collections.sort(wordItems);
        return wordItems;
    }
}
