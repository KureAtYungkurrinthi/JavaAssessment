public class SeverityOutOfBoundsException extends Exception {
    public SeverityOutOfBoundsException() {
        super("Severity is not within 1-10");
    }
}
