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

        if (p_flyable instanceof Aircraft) {
            Aircraft aircraft = (Aircraft) p_flyable;
            long newId = aircraft.getId();
            if (isDuplicate(newId)) {
                throw new DuplicateIdException("The Flyable with ID " + newId + " is already in the observers list.");
            }
            observers.add(p_flyable);
        }
    }

    public void unregister(Flyable p_flyable) throws IdNotFoundException {
        if (p_flyable instanceof Aircraft) {
            Aircraft aircraft = (Aircraft) p_flyable;
            long newId = aircraft.getId();
            if (!isDuplicate(newId)) {
                throw new IdNotFoundException("The Flyable with ID " + newId + " is not in the observers list.");
            }
            observers.remove(p_flyable);
        }
    }

    protected void conditionChanged() {
        // Do stuff
    }

    protected boolean isDuplicate(long newId) {
        for (Flyable flyable : observers) {
            Aircraft aircraft = (Aircraft) flyable;
            if (newId == aircraft.getId()) {
                return true;
            }
        }
        return false;
    }
}