package src.exceptions;

public class FileNotReadableException extends Exception {
    public FileNotReadableException(String message) {
        super("unable to read file: " + message);
    }
}
