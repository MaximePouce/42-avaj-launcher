package src.exceptions;

public class FileNotWrittableException extends Exception {
    public FileNotWrittableException(String message) {
        super("unable to write in file: " + message);
    }
}