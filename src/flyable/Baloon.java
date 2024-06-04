package src.flyable;

import src.Coordinates;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        System.out.println("Creating Baloon");
    }

    @Override
    public void updateConditions() {
        String message = String.format("Coordonates : %d, %d, %d", coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
        System.out.println(message);
    }

    @Override
    public String getType() {
        return "Baloon";
    }
}