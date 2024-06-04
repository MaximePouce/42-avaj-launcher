package src;

import src.flyable.AircraftFactory;
import src.flyable.Flyable;

import src.tower.WeatherTower;

public class Simulator {

    public static void main(String[] args) {
        try {
            Coordinates testCoord = new Coordinates(1,2,3);
    
            WeatherTower wTower = new WeatherTower();
            Flyable test = (AircraftFactory.getInstance().newAircraft("helicopter", "jet", testCoord));
            wTower.register(test);
            wTower.register(test);
            wTower.unregister(test);
            wTower.unregister(test);
        } catch (Exception e) {
            System.out.println("An exception occured: " + e.getMessage());
        }

    }
}