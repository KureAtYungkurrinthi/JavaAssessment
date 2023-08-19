import java.util.Stack;

public class BracketChecker {
    /**
     * Stack used to track opening and closing brackets.
     */
    private final Stack<Character> stack = new Stack<Character>();
    /**
     * Array containing the types of opening brackets.
     */
    private final char[] opening;
    /**
     * Array containing the types of closing brackets.
     */
    private final char[] closing;
    /**
     * Variable to track the position of the incorrect bracket, if any.
     */
    private int position;

    /**
     * Constructs a new BracketChecker with specified opening and closing brackets.
     *
     * @param opening Array of opening brackets.
     * @param closing Array of closing brackets.
     */
    public BracketChecker(char[] opening, char[] closing) {
        this.opening = opening;
        this.closing = closing;
    }

    /**
     * Determine if the parameter 'in' is in the opening array and returns
     * the position if found.
     *
     * @param in the character to check
     * @return the position in the array if found, -1 otherwise
     */
    private int isOpening(char in) {
        for (int ci = 0; ci < opening.length; ci++) {
            if (in == opening[ci]) {
                return ci;
            }
        }
        return -1; // character not found
    }

    /**
     * Determine if the parameter 'in' is in the closing array and returns
     * the position if found.
     *
     * @param in the character to check
     * @return the position in the array if found, -1 otherwise
     */
    private int isClosing(char in) {
        for (int ci = 0; ci < closing.length; ci++) {
            if (in == closing[ci]) {
                return ci;
            }
        }
        return -1; // character not found
    }

    /**
     * Returns the position of the incorrect bracket, if any.
     *
     * @return Position of the incorrect bracket.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Checks the given text for correct sequence and nesting of brackets.
     *
     * <p>
     * This method traverses the given text and checks if the brackets
     * are correctly nested and balanced using the specified opening and
     * closing brackets.
     * </p>
     *
     * @param text The text containing the sequence of brackets to check.
     * @return True if the sequence is correct, false otherwise.
     */
    public boolean check(String text) {
        stack.clear();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (isOpening(c) > -1) {
                stack.push(c);
            } else if (isClosing(c) > -1) {
                if (stack.empty() || stack.peek() != opening[isClosing(c)]) {
                    // ERROR, not matching brackets
                    position = i;
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            position = text.length();
            return false;
        }
    }
}
