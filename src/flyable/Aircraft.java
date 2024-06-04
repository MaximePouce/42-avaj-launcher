package src.flyable;

import src.Coordinates;

public class Aircraft extends Flyable {
    protected long        id;
    protected String      name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        System.out.println("Creating Aircraft");
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    @Override
    public void updateConditions() {
        // Do something?
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return "Aircraft";
    }
}
