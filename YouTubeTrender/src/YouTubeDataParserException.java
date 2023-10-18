/**
 * Custom exception class representing errors specific to YouTube data parsing.
 */
public class YouTubeDataParserException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     */
    public YouTubeDataParserException(String message) {
        super(message);
    }
}