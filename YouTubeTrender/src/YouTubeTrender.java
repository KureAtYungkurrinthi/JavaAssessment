import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The YouTubeTrender class provides a command-line interface for users to interact with YouTube video data.
 * Users can sort videos, analyze trending topics, parse YouTube API data, and navigate through various options in the main menu.
 */
public class YouTubeTrender {
    // Scanner for reading user input
    private static final Scanner scanner = new Scanner(System.in);
    // List to store YouTubeVideo objects
    private static List<YouTubeVideo> list;

    /**
     * Parses the YouTube API data from a specified file path.
     * Continuously prompts the user for the file path until a valid path is provided and data is successfully parsed.
     */
    private static void parseYouTubeAPI() {
        while (true) {
            try {
                System.out.print("Please provide the path to the YouTube API: ");
                String filename = scanner.nextLine();
                YouTubeDataParser parser = new YouTubeDataParser();
                list = parser.parse(filename);
                System.out.println(list.size() + " videos parsed.");
                return;
            } catch (YouTubeDataParserException e) {
                System.out.println(e.getMessage());
                System.out.println("Please check your path and try again.");
            }
        }
    }

    /**
     * Provides options to sort videos based on various criteria, view details of a specific video or all videos.
     * The user can interactively choose the sorting criteria or action to perform on the list of videos.
     */
    private static void sortVideos() {
        while (true) {
            System.out.println("First video in the list:");
            System.out.println(list.get(0));
            System.out.println("Sort Videos:");
            System.out.println("1. Sort by Name of Channel");
            System.out.println("2. Sort by Date of Publish");
            System.out.println("3. Sort by Number of Views");
            System.out.println("4. Sort by Length of Description");
            System.out.println("5. List Video by Index");
            System.out.println("6. List All Videos");
            System.out.println("7. Return to Main Menu");
            System.out.print("Please select [1-7]: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Add this line to consume the pending newline character.
                switch (choice) {
                    case 1 -> list.sort(new YouTubeVideoChannelComparator());
                    case 2 -> list.sort(new YouTubeVideoDateComparator());
                    case 3 -> list.sort(new YouTubeVideoViewComparator());
                    case 4 -> list.sort(new YouTubeVideoDescriptionComparator());
                    case 5 -> {
                        System.out.println("There are " + list.size() + " videos in this list.");
                        System.out.print("Please select index [0-" + (list.size() - 1) + "]: ");
                        int index = scanner.nextInt();
                        System.out.println();
                        System.out.println(list.get(index));
                    }
                    case 6 -> {
                        System.out.println();
                        System.out.println(list);
                    }
                    case 7 -> {
                        return;
                    }
                    default -> throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid number! ");
                scanner.nextLine();  // Clear the invalid input from the stream.
            } catch (IndexOutOfBoundsException e) {
                System.out.print("Index is out of bounds! ");
            }
        }
    }

    /**
     * Provides options for analyzing trending topics based on the video data.
     * Users can search for words, find the count of a word, list videos that use a word, and more.
     */
    private static void trendingTopics() {
        YouTubeVideoIndexer indexer = new YouTubeVideoIndexer(list);
        indexer.index();

        while (true) {
            System.out.println("Trending Topics:");
            System.out.println("1. Find a word");
            System.out.println("2. Find the count associated with a word");
            System.out.println("3. Find all the videos that use that word");
            System.out.println("4. Find the word that is used the most");
            System.out.println("5. List of words sorted by their counts (low to high)");
            System.out.println("6. Return to Main Menu");
            System.out.print("Please select [1-6]: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Add this line to consume the pending newline character.
                switch (choice) {
                    case 1 -> {
                        System.out.print("Word you are searching for: ");
                        String word = scanner.nextLine();
                        System.out.println(indexer.getWord(word));
                    }
                    case 2 -> {
                        System.out.print("Word you are searching for: ");
                        String word = scanner.nextLine();
                        System.out.println("Count associated with " + word + " : " + indexer.getCountByWord(word));
                    }
                    case 3 -> {
                        System.out.print("Word you are searching for: ");
                        String word = scanner.nextLine();
                        list = indexer.getYouTubeVideosByWord(word);
                        System.out.println(list);
                        System.out.println("Video list have been saved!");
                    }
                    case 4 -> {
                        System.out.println("Word that is used the most:");
                        System.out.println(indexer.getMostUsedWord());
                    }
                    case 5 -> {
                        System.out.println("List of words sorted by their counts:");
                        System.out.println(indexer.getSortedYouTubeWordItems());
                    }
                    case 6 -> {
                        return;
                    }
                    default -> throw new InputMismatchException();
                }
            } catch (NullPointerException e) {
                System.out.println("Word you searched does not exist in the video list!");
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid number! ");
                scanner.nextLine();  // Clear the invalid input from the stream.
            } catch (IndexOutOfBoundsException e) {
                System.out.print("Index is out of bounds! ");
            }
        }
    }

    /**
     * Main method that serves as the entry point for the application.
     *
     * @param args command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        System.out.println("Welcome to YouTube Trender!");
        parseYouTubeAPI();

        boolean waitingForInput = true;
        while (waitingForInput) {
            System.out.println("Main Menu:");
            System.out.println("1. Sort Videos");
            System.out.println("2. Trending Topics");
            System.out.println("3. Parse Another File");
            System.out.println("4. Exit");
            System.out.print("Please select [1-4]: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Add this line to consume the pending newline character.
                switch (choice) {
                    case 1 -> sortVideos();
                    case 2 -> trendingTopics();
                    case 3 -> parseYouTubeAPI();
                    case 4 -> {
                        System.out.println("Goodbye!");
                        waitingForInput = false;
                    }
                    default -> throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid number! ");
                scanner.nextLine();  // Clear the invalid input from the stream.
            } catch (IndexOutOfBoundsException e) {
                System.out.print("Index is out of bounds! ");
            }
        }
    }
}