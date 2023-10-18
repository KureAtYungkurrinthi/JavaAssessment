import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class YouTubeTrender {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please provide the path to YouTube API: ");
        String filename = scanner.nextLine();

        try {
            YouTubeDataParser parser = new YouTubeDataParser();
            List<YouTubeVideo> list = parser.parse(filename);
            System.out.println(list.size() + " videos parsed.");
            System.out.println("1. Show first video");
            System.out.println("2. Sort by channel name, then show first video");
            System.out.println("3. Sort by date, then show first video");
            System.out.println("4. Sort by views, then show first video");
            System.out.println("5. Sort by description length, then show first video");
            System.out.println("6. Exit");

            class TerminateMenuException extends Exception {}

            boolean waitingForInput = true;
            while (waitingForInput) {
                try {
                    System.out.println();
                    System.out.print("Please select [1-6]: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1 -> {
                        }
                        case 2 -> list.sort(new YouTubeVideoChannelComparator());
                        case 3 -> list.sort(new YouTubeVideoDateComparator());
                        case 4 -> list.sort(new YouTubeVideoViewComparator());
                        case 5 -> list.sort(new YouTubeVideoDescriptionComparator());
                        case 6 -> throw new TerminateMenuException();
                        default -> throw new InputMismatchException();
                    }
                    System.out.println();
                    System.out.println(list.get(0));
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("The list is empty or the index is out of bounds.");
                } catch (TerminateMenuException e) {
                    System.out.println("Goodbye!");
                    waitingForInput = false;
                }
            }
        } catch (YouTubeDataParserException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check your path and try again.");
            System.out.println("Goodbye!");
        }
    }
}
