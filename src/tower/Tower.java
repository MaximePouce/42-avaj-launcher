package src.tower;

import src.flyable.Flyable;
import src.flyable.Aircraft;

import src.exceptions.DuplicateIdException;
import src.exceptions.IdNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        if (!observers.contains(p_flyable)) {
            observers.add(p_flyable);
        }
    }

    public void unregister(Flyable p_flyable) {
        if (observers.contains(p_flyable)) {
            observers.remove(p_flyable);
        }
    }

    protected void conditionChanged() {
        if (observers.isEmpty()) {
            return ;
        }
        // Creating a Copy to avoid NullPointerException
        // Could also start from the end of the list, but it messes up the display order
        List<Flyable> observersCopy = new ArrayList<>(observers);
        for (Flyable flyable : observersCopy) {
            flyable.updateConditions();
        }
    }
}
