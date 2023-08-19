import java.util.Stack;

public class BracketChecker {
    private final Stack<Character> stack = new Stack<Character>();
    private final char[] opening;
    private final char[] closing;
    private int position;

    public int getPosition() {
        return position;
    }

    public BracketChecker(char[] opening, char[] closing) {
        this.opening = opening;
        this.closing = closing;
    }

    public boolean check(String text) {
        stack.clear();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == opening[0])
                stack.push(c);
            else if (c == closing[0]) {
                if (stack.empty()) {
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
