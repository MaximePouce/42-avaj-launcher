package src.flyable;

import src.Coordinates;
import src.Movement;
import src.exceptions.IdNotFoundException;
import java.util.HashMap;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);

        reactionMap.put("FOG", "Hopefully we won't pierce a Baloon on our way.");
        reactionMap.put("RAIN", "Welp, guess it's coffee break.");
        reactionMap.put("SNOW", "Look Ma! No hand!");
        reactionMap.put("SUN", "Gotta thank the Dev for installing the AC!");

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