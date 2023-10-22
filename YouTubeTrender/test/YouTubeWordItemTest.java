import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YouTubeWordItemTest {
    private YouTubeWordItem wordItem;
    private YouTubeVideo video1;
    private YouTubeVideo video2;

    @BeforeEach
    void setUp() {
        wordItem = new YouTubeWordItem("test");
        video1 = new YouTubeVideo("AA", "title 1", "channelId1", "Channel Title 1", "Description test 1", Instant.now(), 1111);
        video2 = new YouTubeVideo("BB", "title 2", "channelId2", "Channel Title 2", "Description test 2", Instant.now(), 2222);
    }

    @Test
    @DisplayName("Add YouTubeVideo to YouTubeWordItem")
    void testAdd() {
        // Before adding any videos
        assertEquals(0, wordItem.getCount(), "Initial count should be 0");
        assertTrue(wordItem.getPosts().isEmpty(), "Initial set of videos should be empty");

        // After adding one video
        wordItem.add(video1);
        assertEquals(1, wordItem.getCount(), "Count should be 1 after adding one video");
        assertTrue(wordItem.getPosts().contains(video1), "Set of videos should contain the added video");

        // After adding another video
        wordItem.add(video2);
        assertEquals(2, wordItem.getCount(), "Count should be 2 after adding another video");
        assertTrue(wordItem.getPosts().contains(video2), "Set of videos should contain the newly added video");
        assertEquals(2, wordItem.getPosts().size(), "Set of videos should have size 2");
    }

    @Test
    @DisplayName("Get Count of Word Occurrences")
    void testGetCount() {
        assertEquals(0, wordItem.getCount(), "Initial count should be 0");
        wordItem.add(video1);
        assertEquals(1, wordItem.getCount(), "Count should be 1 after adding a video");
    }

    @Test
    @DisplayName("Get Posts Where Word Appears")
    void testGetPosts() {
        Set<YouTubeVideo> posts = wordItem.getPosts();
        assertTrue(posts.isEmpty(), "Initial set of videos should be empty");
        wordItem.add(video1);
        posts = wordItem.getPosts();
        assertTrue(posts.contains(video1), "Set of videos should contain the added video");
        assertEquals(1, posts.size(), "Set of videos should have size 1");
    }

    @Test
    @DisplayName("Compare Two YouTubeWordItems")
    void testCompareTo() {
        YouTubeWordItem anotherWordItem = new YouTubeWordItem("another");

        // Same count
        assertEquals(0, wordItem.compareTo(anotherWordItem), "Comparison should return 0 for items with the same count");

        // Greater count
        wordItem.add(video1);
        assertTrue(wordItem.compareTo(anotherWordItem) > 0, "Comparison should return a positive number when first item's count is greater");

        // Lesser count
        anotherWordItem.add(video1);
        anotherWordItem.add(video2);
        assertTrue(wordItem.compareTo(anotherWordItem) < 0, "Comparison should return a negative number when first item's count is lesser");
    }
}