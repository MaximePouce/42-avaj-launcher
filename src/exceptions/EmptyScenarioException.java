package src.exceptions;

public class EmptyScenarioException extends Exception {
    public EmptyScenarioException() {
        super("Scenario file is empty.");
    }
}
