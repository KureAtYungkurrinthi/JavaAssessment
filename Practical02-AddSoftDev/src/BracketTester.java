import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BracketTester {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Starting Bracket Checker application");
        char[] opening = {'{', '(', '[', '<'};
        char[] closing = {'}', ')', ']', '>'};
        BracketChecker checker = new BracketChecker(opening, closing);

        // Read from the file and store it in the queue/buffer
        Queue<String> queue = new ArrayDeque<String>();
        String filePath = "assets/brackets02.txt";
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

        System.out.println("Exiting Checker");
    }
}
