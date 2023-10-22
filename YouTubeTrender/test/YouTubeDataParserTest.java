import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class YouTubeDataParserTest {
    private final YouTubeDataParser instance = new YouTubeDataParser();

    @Test
    @DisplayName("Test parse method with single video data")
    void testParseSingleVideo() {
        String filename = "data/youtubedata.json";
        try {
            List<YouTubeVideo> result = instance.parse(filename);
            assertNotNull(result, "Video list should not be null");
            assertEquals(1, result.size(), "Video list should contain one video");
            assertEquals("XGM6sHIJuho", result.get(0).getId(), "Contain wrong video");
        } catch (YouTubeDataParserException e) {
            fail("Parsing failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test parse method with multiple video data")
    void testParseMultipleVideos() {
        String filename = "data/youtubedata_15_50.json";
        try {
            List<YouTubeVideo> result = instance.parse(filename);
            assertNotNull(result, "Video list should not be null");
            assertEquals(50, result.size(), "Video list should contain 50 videos");
            assertEquals("XGM6sHIJuho", result.get(0).getId(), "Wrong first video");
            assertEquals("3H7tebD75pM", result.get(result.size() - 1).getId(), "Wrong last video");
        } catch (YouTubeDataParserException e) {
            fail("Parsing failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test parse method with malformed JSON")
    void testParseMalformedJSON() {
        String filename = "data/youtubedata_malformed.json";
        assertThrows(YouTubeDataParserException.class, () -> instance.parse(filename), "Expected YouTubeDataParserException");
    }
}