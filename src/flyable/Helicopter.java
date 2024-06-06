package src.flyable;

import src.Coordinates;
import src.Movement;
import src.exceptions.IdNotFoundException;
import java.util.HashMap;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    
        reactionMap.put("FOG", "Slowing down, I can't see anything in this fog!");
        reactionMap.put("RAIN", "Atleast we're protected from the rain inside.");
        reactionMap.put("SNOW", "I could go for a nice landing in the snow !");
        reactionMap.put("SUN", "I think the sun is trying to cook me alive.");

        movementsMap.put("FOG", new Movement(1, 0, 0));
        movementsMap.put("RAIN", new Movement(5, 0, 0));
        movementsMap.put("SNOW", new Movement(0, 0, -12));
        movementsMap.put("SUN", new Movement(10, 0, 2));
    }

    @Override
    public void updateConditions() {
        super.updateConditions();
    }

    @Override
    public String getType() {
        return "Helicopter";
    }
}