package src.utils;

import src.exceptions.FileNotWrittableException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private static Writer instance;
    private static FileWriter outFile;
    private static BufferedWriter buffer;
    private static String fileName = "simulation.txt";

    private Writer() {}

    public static Writer getInstance() {
        if (instance == null) {
            try {
                instance = new Writer();
                outFile = new FileWriter(fileName);
                buffer = new BufferedWriter(outFile);
            } catch (IOException e) {
                throw new FileNotWrittableException(fileName);
            }
        }
        return instance;
    }

    public void write(String message) {
        if (buffer != null) {
            try {
                buffer.write(message);
                buffer.newLine();
            } catch (IOException e) {
                throw new FileNotWrittableException(fileName);
            }
        }
    }

    public void toFile() {
        if (buffer != null) {
            try {
                buffer.flush();
            } catch (IOException e) {
                throw new FileNotWrittableException(fileName);
            }
        }
    }

    public void close() {
        if (outFile != null) {
            try {
                buffer.close();
            } catch (IOException e) {
                throw new FileNotWrittableException(fileName);
            }
        }
    }
}