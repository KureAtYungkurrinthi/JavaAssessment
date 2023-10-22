import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class YouTubeVideoIndexerTest {
    private YouTubeVideoIndexer indexer;

    @BeforeEach
    void setUp() {
        YouTubeDataParser instance = new YouTubeDataParser();
        String filename = "data/youtubedata_indextest.json";
        try {
            List<YouTubeVideo> videos = instance.parse(filename);
            indexer = new YouTubeVideoIndexer(videos);
        } catch (YouTubeDataParserException e) {
            fail("Parsing failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Indexing YouTube videos should store words in map")
    void testIndex() {
        indexer.index();
        YouTubeWordItem result = indexer.getWord("ONE");
        assertNotNull(result, "Word 'ONE' should be indexed after calling index()");
    }

    @Test
    @DisplayName("Retrieving word that is not indexed should return null")
    void testGetWordNotIndexed() {
        indexer.index();
        YouTubeWordItem result = indexer.getWord("SIX");
        assertNull(result, "Retrieving a word that is not indexed should return null");
    }

    @Test
    @DisplayName("Getting count of word should return correct count after indexing")
    void testGetCountByWord() {
        indexer.index();
        int count = indexer.getCountByWord("THREE");
        assertEquals(3, count, "Count of word 'THREE' should be 3 after indexing");
    }

    @Test
    @DisplayName("Getting YouTube videos by word should return correct list of videos")
    void testGetYouTubeVideosByWord() {
        indexer.index();
        List<YouTubeVideo> result = indexer.getYouTubeVideosByWord("FIVE");
        assertEquals(1, result.size(), "Should return 1 videos for word 'FIVE'");
    }

    @Test
    @DisplayName("Getting the most used word should return the correct word")
    void testGetMostUsedWord() {
        indexer.index();
        YouTubeWordItem result = indexer.getMostUsedWord();
        assertEquals("FIVE", result.getWord(), "The most used word should be 'FIVE'");
    }

    @Test
    @DisplayName("Getting sorted YouTube word items should return correct order")
    void testGetSortedYouTubeWordItems() {
        indexer.index();
        List<YouTubeWordItem> result = indexer.getSortedYouTubeWordItems();
        assertEquals("ONE", result.get(0).getWord(), "The first word in sorted list should be 'ONE'");
    }
}