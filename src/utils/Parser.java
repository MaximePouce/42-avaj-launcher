package src.utils;

import src.exceptions.FileNotFoundException;
import src.exceptions.FileNotReadableException;
import src.exceptions.FileNotWrittableException;
import src.exceptions.IncorrectScenarioException;
import src.exceptions.EmptyScenarioException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    private File inFile;
    private File outFile = new File("simulation.txt");
    private int runCount;
    private List<Map<String, Object>> aircrafts = new ArrayList<>();

    public Parser(String filename) throws FileNotFoundException, FileNotReadableException {
        inFile = new File(filename);
        if (!inFile.exists()) {
            throw new FileNotFoundException(filename);
        }
        if (!inFile.canRead()) {
            throw new FileNotReadableException(filename);
        }
        aircrafts = new ArrayList<>();

        // outFile.createNewFile();
        // if (!outFile.canWrite()) {
        //     throw new FileNotWrittableException(outFile.getName());
        // }
    }

    public void parseInputFile() throws FileNotReadableException, EmptyScenarioException, IncorrectScenarioException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile.getName()));
            String line = reader.readLine();
            if (line == null) {
                throw new EmptyScenarioException();
            }
            runCount = Integer.valueOf(line);
            if (runCount < 0 ) {
                throw new NumberFormatException(line);
            }

            while ((line = reader.readLine()) != null) {
                this.checkLine(line);
                // aircrafts.add(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new FileNotReadableException(e.getMessage());
        } catch (NumberFormatException e) {
            throw new IncorrectScenarioException("Must start with a positive int");
        }
    }

    private void checkLine(String line) throws IncorrectScenarioException {
        Map<String, Object> aircraftData = new HashMap<>();
        String[] data = line.split(" ");

        if (data.length != 5) {
            throw new IncorrectScenarioException("Line must have exactly 5 elements : " + line);
        }

        int longitude;
        int latitude;
        int height;

        try {
            longitude = Integer.valueOf(data[2]);
            latitude = Integer.valueOf(data[3]);
            height = Integer.valueOf(data[4]);
        }
        catch (NumberFormatException e) {
            throw new IncorrectScenarioException("Coordinates must be integers in line: " + line);
        }

        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new IncorrectScenarioException("Coordinates must be positive integers in line: " + line);
        }

        if (height > 100) {
            throw new IncorrectScenarioException("Height cannot be greater that 100 in line: " + line);
        }

        aircraftData.put("type", data[0]);
        aircraftData.put("name", data[1]);
        aircraftData.put("longitude", longitude);
        aircraftData.put("latitude", latitude);
        aircraftData.put("height", height);

        aircrafts.add(aircraftData);
    }

    public List<Map<String, Object>> getAircrafts() {
        return aircrafts;
    }

    public int getRunCount() {
        return runCount;
    }
}