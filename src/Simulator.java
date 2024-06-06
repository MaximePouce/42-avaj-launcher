package src;

import src.flyable.AircraftFactory;
import src.flyable.Flyable;

import src.tower.WeatherTower;

import src.utils.Parser;
import src.utils.Writer;

import src.exceptions.FileNotWrittableException;
import src.exceptions.MaxIdReachedException;

import java.util.List;
import java.util.Map;

public class Simulator {
    private static Parser parser;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("This program requires one and only one command line argument : The scenario file name.");
            System.exit(1);
        }
        
        WeatherTower wTower = new WeatherTower();

        try {
            parser = new Parser(args[0]);
            parser.parseInputFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        List<Map<String, Object>> aircrafts = parser.getAircrafts();
        for (Map<String, Object> aircraft : aircrafts) {
            String type = (String) aircraft.get("type");
            String name = (String) aircraft.get("name");
            int longitude = (int) aircraft.get("longitude");
            int latitude = (int) aircraft.get("latitude");
            int height = (int) aircraft.get("height");

            try {
                wTower.register(AircraftFactory.getInstance().newAircraft(
                    type, name, new Coordinates(longitude, latitude, height)
                    ));
            } catch (FileNotWrittableException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            } catch (MaxIdReachedException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < parser.getRunCount(); ++i) {
            try {
                wTower.changeWeather();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Writer.getInstance().toFile();
        }

    }
}