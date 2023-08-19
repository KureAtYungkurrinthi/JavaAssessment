import java.util.Scanner;

public class BracketTester {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Starting Bracket Checker application");
        char[] opening = new char[]{'{'};
        char[] closing = new char[]{'}'};
        BracketChecker checker = new BracketChecker(opening, closing);
        Scanner in = new Scanner(System.in);

        String nextLine;
        boolean notEmpty = true;
        while (notEmpty) {
            nextLine = in.nextLine();
            if (nextLine.isEmpty())
                notEmpty = false;
            else
                System.out.println(checker.check(nextLine) ? "Syntax Correct" : "Syntax Error");
        }
        System.out.println("Exiting Checker");

    }
}
