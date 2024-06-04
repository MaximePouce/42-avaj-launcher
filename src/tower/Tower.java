package src.tower;

import src.flyable.Flyable;
import src.flyable.Aircraft;

import src.exceptions.DuplicateIdException;
import src.exceptions.IdNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers;

    public void register(Flyable p_flyable) throws DuplicateIdException {
        if (observers == null) {
            observers = new ArrayList<>();
        }

        if (observers.contains(p_flyable)) {
            throw new DuplicateIdException("The Flyable  " + p_flyable + " is already in the observers list.");
        }
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) throws IdNotFoundException {
        if (p_flyable instanceof Aircraft) {
            Aircraft aircraft = (Aircraft) p_flyable;
            long newId = aircraft.getId();
            if (!observers.contains(p_flyable)) {
                throw new IdNotFoundException("The Flyable " + p_flyable + " is not in the observers list.");
            }
            observers.remove(p_flyable);
        }
    }

    protected void conditionChanged() {
        // Do stuff
    }
}
