package storage;

import java.util.*;

public class UsedCities {
    private Collection<String> usedCities;

    public UsedCities() {
        usedCities = new HashSet<>();
    }

    public boolean addUsed(String s) {
        try {
            return usedCities.add(s);
        } catch (NullPointerException e) {
            return true;
        }
    }

    public boolean isUsed(String name) {
        return usedCities.contains(name);
    }

    @Override
    public String toString() {

        StringJoiner sj = new StringJoiner(", ");
        for (String city : usedCities) {
            sj.add(city);
        }
        return sj.toString();
    }
}
