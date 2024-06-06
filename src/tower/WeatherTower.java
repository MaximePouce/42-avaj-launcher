package src.tower;

import src.Coordinates;
import src.WeatherProvider;

import src.flyable.Flyable;
import src.flyable.Aircraft;

import src.utils.Writer;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        this.conditionChanged();
    }

    @Override
    public void register(Flyable p_flyable) {
        super.register(p_flyable);
        
        if (p_flyable instanceof Aircraft) {
            Aircraft aircraft = (Aircraft) p_flyable;
            String message = String.format(
                "Weather Tower says: %s %s(%d) registered to the weather tower.", 
                aircraft.getType(),
                aircraft.getName(),
                aircraft.getId()
            );
            Writer.getInstance().write(message);
        }
        p_flyable.registerTower(this);
    }

    @Override
    public void unregister(Flyable p_flyable) {
        super.unregister(p_flyable);

        if (p_flyable instanceof Aircraft) {
            Aircraft aircraft = (Aircraft) p_flyable;
            String message = String.format(
                "Weather Tower says: %s %s(%d) unregistered from the weather tower.",
                aircraft.getType(),
                aircraft.getName(),
                aircraft.getId()
            );
            Writer.getInstance().write(message);
        }
        p_flyable.registerTower(null);
    }
}
