import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YouTubeVideoComparatorTest {
    private List<YouTubeVideo> videos;
    private YouTubeVideo video1;
    private YouTubeVideo video2;
    private YouTubeVideo video3;

    @BeforeEach
    void setUp() {
        videos = new ArrayList<>();
        video1 = new YouTubeVideo("AA", "title 1", "channelId1", "Channel Title 1", "Description test 1", Instant.now(), 1111);
        video2 = new YouTubeVideo("BB", "title 2", "channelId2", "Channel Title 2", "Description test test 2", Instant.now(), 2222);
        video3 = new YouTubeVideo("CC", "title 3", "channelId3", "Channel Title 3", "Description test test test 3", Instant.now(), 3333);
    }

    @Test
    @DisplayName("Test sorting by channel title")
    void testYouTubeVideoChannelComparator() {
        videos.add(video3);
        videos.add(video2);
        videos.add(video1);
        videos.sort(new YouTubeVideoChannelComparator());
        assertEquals("Channel Title 1", videos.get(0).getChannelTitle(), "The first video should be from video1");
        assertEquals("Channel Title 2", videos.get(1).getChannelTitle(), "The second video should be from video2");
        assertEquals("Channel Title 3", videos.get(2).getChannelTitle(), "The third video should be from video3");
    }

    @Test
    @DisplayName("Test sorting by published date")
    void testYouTubeVideoDateComparator() {
        videos.add(video3);
        videos.add(video2);
        videos.add(video1);
        videos.sort(new YouTubeVideoDateComparator());
        assertEquals(video1.getPublishedAt(), videos.get(0).getPublishedAt(), "The first video should be from video1");
        assertEquals(video2.getPublishedAt(), videos.get(1).getPublishedAt(), "The second video should be from video2");
        assertEquals(video3.getPublishedAt(), videos.get(2).getPublishedAt(), "The third video should be from video3");
    }

    @Test
    @DisplayName("Test sorting by view count")
    void testYouTubeVideoViewComparator() {
        videos.add(video3);
        videos.add(video2);
        videos.add(video1);
        videos.sort(new YouTubeVideoViewComparator());
        assertEquals(1111, videos.get(0).getViewCount(), "The first video should have the least views");
        assertEquals(2222, videos.get(1).getViewCount(), "The second video should have the second least views");
        assertEquals(3333, videos.get(2).getViewCount(), "The third video should have the most views");
    }

    @Test
    @DisplayName("Test sorting by description")
    void testYouTubeVideoDescriptionComparator() {
        videos.add(video3);
        videos.add(video2);
        videos.add(video1);
        videos.sort(new YouTubeVideoDescriptionComparator());
        assertEquals("Description test 1", videos.get(0).getDescription(), "The first video's description should be from video1");
        assertEquals("Description test test 2", videos.get(1).getDescription(), "The second video's description should be from video2");
        assertEquals("Description test test test 3", videos.get(2).getDescription(), "The third video's description should be from video3");
    }

    @Test
    @DisplayName("Test sorting by word count in description")
    void testYouTubeVideoDescriptionCountComparator() {
        videos.add(video1);
        videos.add(video2);
        videos.add(video3);
        videos.sort(new YouTubeVideoDescriptionCountComparator("test"));
        assertEquals("Description test 1", videos.get(0).getDescription(), "The first video should have the least occurrences of the word 'test'");
        assertEquals("Description test test 2", videos.get(1).getDescription(), "The second video should have the second least occurrences of the word 'test'");
        assertEquals("Description test test test 3", videos.get(2).getDescription(), "The third video should have the most occurrences of the word 'test'");
    }
}