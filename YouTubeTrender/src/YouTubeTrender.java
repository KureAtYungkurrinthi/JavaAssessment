import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class YouTubeTrender {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<YouTubeVideo> list;

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
            System.out.print("Please select [1-8]: ");
            try {
                int choice = scanner.nextInt();
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

    private static void trendingTopics() {
        System.out.println("Trending Topics Placeholder!");
    }

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