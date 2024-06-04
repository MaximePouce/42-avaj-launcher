package src.flyable;

import src.Coordinates;
import src.WeatherProvider;
import src.Movement;

import src.exceptions.IdNotFoundException;

import java.util.Map;
import java.util.HashMap;

public class Aircraft extends Flyable {
    protected long        id;
    protected String      name;
    protected Coordinates coordinates;

    protected Map<String, String> reactionMap = new HashMap<>();
    protected Map<String, Movement> movementsMap = new HashMap<>();

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        System.out.println("Creating Aircraft");
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    @Override
    public void updateConditions() throws IdNotFoundException {
        // String weather = WeatherProvider.getInstance().getCurrentWeather(this.coordinates);
        String weather = "SNOW";
        String message = String.format("%s#%s(%d): %s", this.getType(), this.getName(), this.getId(), reactionMap.get(weather));
        System.out.println(message);
        this.applyMovement(weather);
    }

    protected void applyMovement(String weather) throws IdNotFoundException {
        Movement movement = movementsMap.get(weather);
        if (movement != null) {
            coordinates.addLongitude(movement.getLongitudeMovement());
            coordinates.addLatitude(movement.getLatitudeMovement());
            coordinates.addHeight(movement.getHeightMovement());

            if (coordinates.getHeight() == 0) {
                weatherTower.unregister(this);
            }
        }
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
