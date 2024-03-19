package tech.iam.exception;

public class SodaNotFoundException extends RuntimeException {
    public SodaNotFoundException(String name) {
        super("Soda by name not found: " + name);
    }
}
