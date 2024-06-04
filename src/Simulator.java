package src;

import src.flyable.AircraftFactory;
import src.flyable.Flyable;

import src.tower.WeatherTower;

public class Simulator {

    public static void main(String[] args) {
        try {
            Coordinates testCoord = new Coordinates(1,2,3);
    
            WeatherTower wTower = new WeatherTower();
            Flyable test = (AircraftFactory.getInstance().newAircraft("baloon", "Bhaaloon", testCoord));
            Flyable test2 = (AircraftFactory.getInstance().newAircraft("helicopter", "Hylli", testCoord));
            Flyable test3 = (AircraftFactory.getInstance().newAircraft("jetplane", "Jett", testCoord));
            wTower.register(test);
            wTower.register(test2);
            wTower.register(test3);
            test.updateConditions();
            test2.updateConditions();
            test3.updateConditions();
            // wTower.unregister(test);
            // wTower.unregister(test2);
            // wTower.unregister(test3);
        } catch (Exception e) {
            System.out.println("An exception occured: " + e.getMessage());
        }

    }
}