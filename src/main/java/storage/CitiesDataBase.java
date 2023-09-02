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

    //    Метод String nextCity(String toCompare) він приймає назву міста (не має бути null)
//    з нього бере останню літеру  і з колекції бере якесь
//    місто яке починається з останньої літери toCompare
//    видаляє toCompare й answer з колекції
//    може повернути answer або null якщо його немає
    public String nextCity(String toCompare) {
        if (toCompare == null) {
            throw new NullPointerException("toCompare = null");
        }
        String lastLetter = String.valueOf(toCompare.charAt(toCompare.length() - 1));
        Optional<String> answer = cities.stream()
                .filter(city -> city.startsWith(lastLetter.toUpperCase()))
                .findAny();

        answer.ifPresent(cities::remove);
        cities.remove(toCompare);

        return answer.orElse(null);
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

    public int getSize(){
        return cities.size();
    }

}
