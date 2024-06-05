package src.flyable;

import src.Coordinates;
import src.exceptions.MaxIdReachedException;

public class AircraftFactory {
    // Private static instance
    private static AircraftFactory instance;
    private long aircraftCounter = 0;

    // Private constructor to prevent instantiation
    private AircraftFactory() {}

    // Access the singleton instance, making sure it is unique
    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws MaxIdReachedException {
        if (aircraftCounter == Long.MAX_VALUE) {
            throw new MaxIdReachedException(p_type + " " + p_name);
        }
        ++aircraftCounter;
        switch (p_type.toLowerCase()) {
            case "baloon":
                return new Baloon(aircraftCounter, p_name, p_coordinates);
            case "helicopter":
                return new Helicopter(aircraftCounter, p_name, p_coordinates);
            case "jetplane":
                return new JetPlane(aircraftCounter, p_name, p_coordinates);
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + p_type);
        }
    }
}
