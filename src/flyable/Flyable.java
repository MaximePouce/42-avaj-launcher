package src.flyable;

import src.tower.WeatherTower;
import src.exceptions.IdNotFoundException;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions() throws IdNotFoundException;

    public void registerTower(WeatherTower p_tower)
    {
        this.weatherTower = p_tower;
    }
}