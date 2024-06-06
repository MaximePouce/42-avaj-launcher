package src.flyable;

import src.Coordinates;
import src.Movement;
import src.exceptions.IdNotFoundException;
import java.util.HashMap;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);

        reactionMap.put("FOG", "Imagine not having help from a tower in all this fog...");
        reactionMap.put("RAIN", "If anyone needs a water refill, there's plenty outside!");
        reactionMap.put("SNOW", "All this snow, we might need to go a bit lower now.");
        reactionMap.put("SUN", "The sun is watching, time to zoom!");

        movementsMap.put("FOG", new Movement(0, 1, 0));
        movementsMap.put("RAIN", new Movement(0, 5, 0));
        movementsMap.put("SNOW", new Movement(0, 0, -7));
        movementsMap.put("SUN", new Movement(0, 10, 2));
    }

    @Override
    public void updateConditions() {
        super.updateConditions();
    }

    @Override
    public String getType() {
        return "JetPlane";
    }
}