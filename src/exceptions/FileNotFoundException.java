package src.exceptions;

public class FileNotFoundException extends Exception {
    public FileNotFoundException(String message) {
        super("(404) file not found: " + message);
    }
}
