import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BracketTester {
    /**
     * The main method to start the bracket tester application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Displaying a startup message
        System.out.println("Starting Bracket Checker application");
        // Define arrays for opening and closing brackets
        char[] opening = {'{', '(', '[', '<'};
        char[] closing = {'}', ')', ']', '>'};
        // Instantiate a BracketChecker with the defined opening and closing brackets
        BracketChecker checker = new BracketChecker(opening, closing);

        // Read from the file and store it in the queue/buffer
        Queue<String> queue = new ArrayDeque<String>();
        String filePath = "assets/brackets03.txt";
        Scanner in = new Scanner(new FileReader(filePath));
        while (in.hasNextLine()) {
            queue.offer(in.nextLine());
        }

        // Process each item in the queue and check brackets
        while (queue.peek() != null) {
            System.out.println(queue.peek());
            if (checker.check(queue.poll())) {
                System.out.println("Syntax Correct");
            } else {
                for (int i = 0; i < checker.getPosition(); i++) {
                    System.out.print(" ");
                }
                System.out.println("|");
                System.out.println("Syntax Error at position " + checker.getPosition());
            }
        }

        // Display an exiting message
        System.out.println("Exiting Checker");
    }
}
