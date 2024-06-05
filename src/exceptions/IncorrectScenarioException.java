package src.exceptions;

public class IncorrectScenarioException extends Exception {
    public IncorrectScenarioException(String message) {
        super("Error in scenario file: " + message);
    }
}
