import javax.json.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods to parse YouTube video data from JSON files.
 */
public class YouTubeDataParser {
    /**
     * Parses the specified JSON file and returns a list of YouTube videos.
     *
     * @param filename the path to the JSON file to be parsed
     * @return a list of YouTube videos parsed from the file
     * @throws YouTubeDataParserException if there's an error during the parsing process
     */
    public List<YouTubeVideo> parse(String filename) throws YouTubeDataParserException {
        List<YouTubeVideo> youTubeVideoList = new ArrayList<>();

        try {
            JsonReader jsonReader = Json.createReader(new FileInputStream(filename));
            JsonObject jobj = jsonReader.readObject();
            JsonArray items = jobj.getJsonArray("items");

            for (int i = 0; i < items.size(); i++) {
                JsonObject video = items.getJsonObject(i);

                // Extract video details from the JSON object
                JsonObject snippet = video.getJsonObject("snippet");
                String channelId = snippet.getString("channelId");
                String channelTitle = snippet.getString("channelTitle");
                Instant publishedAt = Instant.parse(snippet.getString("publishedAt"));
                String title = snippet.getString("title");
                String description = snippet.getString("description");

                // Extract video statistics from the JSON object
                JsonObject statistics = video.getJsonObject("statistics");
                int viewCount = Integer.parseInt(statistics.getString("viewCount"));

                YouTubeVideo youTubeVideo = new YouTubeVideo(channelId, channelTitle, publishedAt, title, description, viewCount);
                youTubeVideoList.add(youTubeVideo);
            }

        } catch (FileNotFoundException e) {
            throw new YouTubeDataParserException("File not found: " + filename);
        } catch (JsonException e) {
            throw new YouTubeDataParserException("Error parsing the JSON data: " + e.getMessage());
        }

        return youTubeVideoList;
    }
}