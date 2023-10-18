import java.time.Instant;

/**
 * Represents a YouTube video with associated metadata.
 */
public class YouTubeVideo {
    private String channelId;
    private String channelTitle;
    private Instant publishedAt;
    private String title;
    private String description;
    private int viewCount;

    /**
     * Constructs a new YouTubeVideo instance.
     *
     * @param channelId  the ID that YouTube uses to uniquely identify the channel that the video was uploaded to
     * @param channelTitle  channel title for the channel that the video belongs to
     * @param publishedAt the date and time that the video was published
     * @param title the video's title. The property value has a maximum length of 100 characters and may contain all valid UTF-8 characters except < and >
     * @param description the video's description. The property value has a maximum length of 5000 bytes and may contain all valid UTF-8 characters except < and >
     * @param viewCount  the number of times the video has been viewed
     */
    public YouTubeVideo(String channelId, String channelTitle, Instant publishedAt, String title, String description, int viewCount) {
        this.channelId = channelId;
        this.channelTitle = channelTitle;
        this.publishedAt = publishedAt;
        this.title = title;
        this.description = description;
        this.viewCount = viewCount;
    }

    /**
     * Retrieves the ID of the channel the video belongs to.
     *
     * @return the channelId of the YouTube video
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Sets the ID of the channel the video belongs to.
     *
     * @param channelId the ID to set for the YouTube video's channel
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * Retrieves the title of the channel the video belongs to.
     *
     * @return the channel title of the YouTube video
     */
    public String getChannelTitle() {
        return channelTitle;
    }

    /**
     * Sets the title of the channel the video belongs to.
     *
     * @param channelTitle the title to set for the YouTube video's channel
     */
    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    /**
     * Retrieves the date and time the video was published.
     *
     * @return the publication Instant of the YouTube video
     */
    public Instant getPublishedAt() {
        return publishedAt;
    }

    /**
     * Sets the date and time the video was published.
     *
     * @param publishedAt the Instant to set as the publication date and time of the YouTube video
     */
    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    /**
     * Retrieves the title of the video.
     *
     * @return the title of the YouTube video
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the video.
     *
     * @param title the title to set for the YouTube video
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the description of the video.
     *
     * @return the description of the YouTube video
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the video.
     *
     * @param description the description to set for the YouTube video
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the number of times the video has been viewed.
     *
     * @return the view count of the YouTube video
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * Sets the number of times the video has been viewed.
     *
     * @param viewCount the number of views to set for the YouTube video
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}