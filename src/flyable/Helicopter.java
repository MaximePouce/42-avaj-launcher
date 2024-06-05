package src.flyable;

import src.Coordinates;
import src.Movement;
import src.exceptions.IdNotFoundException;
import java.util.HashMap;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    
        reactionMap.put("FOG", "Slowing down, I can't see anything!");
        reactionMap.put("RAIN", "Better here than in a Baloon !");
        reactionMap.put("SNOW", "Bravo 6, going down.");
        reactionMap.put("SUN", "I might be cooking inside right now chief.");

        movementsMap.put("FOG", new Movement(1, 0, 0));
        movementsMap.put("RAIN", new Movement(5, 0, 0));
        movementsMap.put("SNOW", new Movement(0, 0, -12));
        movementsMap.put("SUN", new Movement(10, 0, 2));
    }

    @Override
    public void updateConditions() throws IdNotFoundException {
        super.updateConditions();
    }

    @Override
    public String getType() {
        return "Helicopter";
    }
}