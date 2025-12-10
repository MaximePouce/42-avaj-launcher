package src.flyable;

import src.Coordinates;
import src.Movement;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);

        reactionMap.put("FOG", "So much fog, might as well take a nap.");
        reactionMap.put("RAIN", "Stupid rain, I miss being dry...");
        reactionMap.put("SNOW", "I could go for a snowball fight!");
        reactionMap.put("SUN", "Now that's the sun I paid for !");

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
