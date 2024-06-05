package src.flyable;

import src.Coordinates;
import src.Movement;
import src.exceptions.IdNotFoundException;
import java.util.HashMap;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);

        reactionMap.put("FOG", "Glad I paid for this view...");
        reactionMap.put("RAIN", "I hope wind won't come up.");
        reactionMap.put("SNOW", "Well.. I should have worn gloves.");
        reactionMap.put("SUN", "Glad I paid for this view!");

        movementsMap.put("FOG", new Movement(0, 0, -3));
        movementsMap.put("RAIN", new Movement(0, 0, -5));
        movementsMap.put("SNOW", new Movement(0, 0, -15));
        movementsMap.put("SUN", new Movement(2, 0, 4));
    }

    @Override
    public void updateConditions() {
        super.updateConditions();
    }

    @Override
    public String getType() {
        return "Baloon";
    }
}