import java.util.Stack;

public class BracketChecker {
    private final Stack<Character> stack = new Stack<>();
    private final char[] opening;
    private final char[] closing;

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
                if (stack.empty())
                    return false;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
