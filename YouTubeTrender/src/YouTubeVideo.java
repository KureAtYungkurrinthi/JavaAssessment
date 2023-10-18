import java.time.Instant;

/**
 * Represents a YouTube video with associated metadata.
 */
public class YouTubeVideo {
    private String id;
    private String title;
    private String channelId;
    private String channelTitle;
    private String description;
    private Instant publishedAt;
    private int viewCount;

    /**
     * Constructs a new YouTubeVideo instance.
     *
     * @param id           the ID that YouTube uses to uniquely identify the video
     * @param title        the video's title. The property value has a maximum length of 100 characters and may contain all valid UTF-8 characters except < and >
     * @param channelId    the ID that YouTube uses to uniquely identify the channel that the video was uploaded to
     * @param channelTitle channel title for the channel that the video belongs to
     * @param description  the video's description. The property value has a maximum length of 5000 bytes and may contain all valid UTF-8 characters except < and >
     * @param publishedAt  the date and time that the video was published
     * @param viewCount    the number of times the video has been viewed
     */
    public YouTubeVideo(String id, String title, String channelId, String channelTitle, String description, Instant publishedAt, int viewCount) {
        this.id = id;
        this.title = title;
        this.channelId = channelId;
        this.channelTitle = channelTitle;
        this.description = description;
        this.publishedAt = publishedAt;
        this.viewCount = viewCount;
    }
    
    /**
     * Retrieves the video ID.
     *
     * @return the video's unique ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the video ID.
     *
     * @param id the unique video ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the video title.
     *
     * @return the title of the video.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the video title.
     *
     * @param title the title of the video.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the channel ID.
     *
     * @return the unique ID of the channel to which the video belongs.
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Sets the channel ID.
     *
     * @param channelId the unique ID of the channel to which the video belongs.
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * Retrieves the channel title.
     *
     * @return the title of the channel to which the video belongs.
     */
    public String getChannelTitle() {
        return channelTitle;
    }

    /**
     * Sets the channel title.
     *
     * @param channelTitle the title of the channel to which the video belongs.
     */
    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    /**
     * Retrieves the video description.
     *
     * @return the video's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the video description.
     *
     * @param description the description of the video.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the video's publication date and time.
     *
     * @return the instant the video was published.
     */
    public Instant getPublishedAt() {
        return publishedAt;
    }

    /**
     * Sets the video's publication date and time.
     *
     * @param publishedAt the date and time the video was published.
     */
    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    /**
     * Retrieves the video's view count.
     *
     * @return the number of times the video has been viewed.
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * Sets the video's view count.
     *
     * @param viewCount the number of times the video has been viewed.
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * Returns a formatted string representation of the YouTube video.
     *
     * @return a string containing the video's URL, title, channel ID, channel title, description, publication date and time, and view count.
     */
    @Override
    public String toString() {
        return "URL: https://youtu.be/" + id + "\n" +
                "Title: " + title + "\n" +
                "Channel ID: " + channelId + "\n" +
                "Channel Title: " + channelTitle + "\n" +
                "Description: " + description + "\n" +
                "Published At: " + publishedAt + "\n" +
                "View Count: " + viewCount;
    }
}