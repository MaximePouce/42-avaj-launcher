package src.tower;

import src.Coordinates;

import src.flyable.Flyable;
import src.flyable.Aircraft;

import src.exceptions.DuplicateIdException;
import src.exceptions.IdNotFoundException;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        System.out.println("Getting weather.");
        return "lol";
    }

    public void changeWeather() {
        System.out.println("Changing weather.");
    }

    @Override
    public void register(Flyable p_flyable) throws DuplicateIdException {
        super.register(p_flyable);
        if (p_flyable instanceof Aircraft) {
            Aircraft aircraft = (Aircraft) p_flyable;
            String message = String.format("Weather Tower says: %s %s(%d) registered to the weather tower.", aircraft.getType(), aircraft.getName(), aircraft.getId());
            System.out.println(message);
        }
        p_flyable.registerTower(this);
    }

    @Override
    public void unregister(Flyable p_flyable) throws IdNotFoundException {
        super.unregister(p_flyable);
        if (p_flyable instanceof Aircraft) {
            Aircraft aircraft = (Aircraft) p_flyable;
            String message = String.format("Weather Tower says: %s %s(%d) unregistered from the weather tower.", aircraft.getType(), aircraft.getName(), aircraft.getId());
            System.out.println(message);
        }
        p_flyable.registerTower(null);
    }
}