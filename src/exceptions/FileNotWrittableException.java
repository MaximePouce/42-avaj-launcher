package src.exceptions;

public class FileNotWrittableException extends RuntimeException {
    private final String fileName;

    public FileNotWrittableException(String fileName) {
        super("unable to write to file: " + fileName);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}