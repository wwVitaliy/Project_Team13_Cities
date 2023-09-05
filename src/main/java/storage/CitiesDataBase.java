package storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

//Клас CitiesDatabase він зберігає назви
//міст має метод nextCity і декілька не обов'язкових методів
public class CitiesDataBase {
    private static final String CITIES_PATH = "./src/main/resources/UAcities.txt";
    private final Collection<String> cities;


    //В конструкторі CitiesDataBase з файла UAcities.txt
    //зчитуються всі міста України і додаються в колекцію унікальних елементів cities
    public CitiesDataBase() {
        cities = new ArrayList<>();

        try (BufferedReader buffReader = new BufferedReader(new FileReader(CITIES_PATH))) {
            String city = buffReader.readLine();
            while (city != null) {
                cities.add(city.toLowerCase());
                city = buffReader.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public Optional<String> getNextCity(char letter) {
        return cities.stream()
                .filter(city -> city.startsWith(String.valueOf(letter)))
                .findAny();
    }


    //maybe useful methods
    public void removeCity(String toRemove) {
        try {
            cities.remove(toRemove);
        } catch (NullPointerException e) {
            //NOP
        }

    }

    public boolean containsCity(String str) {
        return cities.contains(str);
    }

}
