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
        char[] opening = new char[]{'{'};
        char[] closing = new char[]{'}'};
        BracketChecker checker = new BracketChecker(opening, closing);

        Queue<String> queue = new ArrayDeque<String>();
        String filePath = "assets/brackets01.txt";
        Scanner in = new Scanner(new FileReader(filePath));
        while (in.hasNextLine())
            queue.offer(in.nextLine());

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
