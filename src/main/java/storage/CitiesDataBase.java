package storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CitiesDataBase {
    private final Collection<String> cities;
    private static final String path = "./src/main/resources/UAcities.txt";

    public CitiesDataBase() {
        cities = new TreeSet<>();
        try (BufferedReader buffReader = new BufferedReader(new FileReader(path))) {
            String city = buffReader.readLine();
            while (city != null) {
                cities.add(city);
                city = buffReader.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String nextCity(String toCompare) {
        String lastLetter = String.valueOf(toCompare.charAt(toCompare.length() - 1));
        Optional<String> answer = cities.stream()
                .filter(city -> city.startsWith(lastLetter.toUpperCase()))
                .findAny();

        answer.ifPresent(cities::remove);

        return answer.orElse(null);
    }

    //maybe useful methods
    public void removeCity(String toRemove) {
        cities.remove(toRemove);
    }

    public boolean containsCity(String str) {
        return cities.contains(str);
    }

    public static void main(String[] args) {
        CitiesDataBase citiesDataBase = new CitiesDataBase();
        System.out.println(citiesDataBase.nextCity("Druzhkivka"));
    }
}
