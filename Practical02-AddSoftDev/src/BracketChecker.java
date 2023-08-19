import java.util.Stack;

public class BracketChecker {
    private final Stack<Character> stack = new Stack<Character>();
    private final char[] opening;
    private final char[] closing;
    private int position;

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

    // Retrieve the index of the character where the error occurred
    public int getPosition() {
        return position;
    }

    public boolean check(String text) {
        stack.clear();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (isOpening(c) > -1) {
                stack.push(c);
            } else if (isClosing(c) > -1) {
                if (stack.empty() || stack.peek() != opening[isClosing(c)]) {
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
