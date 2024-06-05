package src;

import src.flyable.AircraftFactory;
import src.flyable.Flyable;

import src.tower.WeatherTower;

import src.utils.Parser;

import java.util.List;
import java.util.Map;

public class Simulator {

    public static void main(String[] args) {
        try {
            Parser parser = new Parser("scenario.txt");
            parser.parseInputFile();

            WeatherTower wTower = new WeatherTower();
            List<Map<String, Object>> aircrafts = parser.getAircrafts();
            
            for (Map<String, Object> aircraft : aircrafts) {
                String type = (String) aircraft.get("type");
                String name = (String) aircraft.get("name");
                int longitude = (int) aircraft.get("longitude");
                int latitude = (int) aircraft.get("latitude");
                int height = (int) aircraft.get("height");

                wTower.register(AircraftFactory.getInstance().newAircraft(
                    type, name, new Coordinates(longitude, latitude, height)
                    ));
            }

            for (int i = 0; i < parser.getRunCount(); ++i) {
                wTower.changeWeather();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }

    }
}