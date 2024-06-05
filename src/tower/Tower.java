package src.tower;

import src.flyable.Flyable;
import src.flyable.Aircraft;

import src.exceptions.DuplicateIdException;
import src.exceptions.IdNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) throws DuplicateIdException {
        if (observers.contains(p_flyable)) {
            throw new DuplicateIdException("The Flyable  " + p_flyable + " is already in the observers list.");
        }
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) throws IdNotFoundException {
        if (!observers.contains(p_flyable)) {
            throw new IdNotFoundException("The Flyable " + p_flyable + " is not in the observers list.");
        }
        observers.remove(p_flyable);
    }

    protected void conditionChanged() throws IdNotFoundException {
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
