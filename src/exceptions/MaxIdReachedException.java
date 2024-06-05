package src.exceptions;

public class MaxIdReachedException extends Exception {
    public MaxIdReachedException(String message) {
        super("Maximum ID reached, unable to create: " + message);
    }
}
