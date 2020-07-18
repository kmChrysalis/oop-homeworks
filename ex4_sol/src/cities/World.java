package cities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class World {

    private TreeMap<String, Country> countries = new TreeMap<>();

    public void addCountry(String name) {
        countries.put(name, new Country(name));
    }

    public void addCity(String name, String countryName, int population) {
        Country country = countries.get(countryName);
        if (!countries.containsKey(countryName)) //check if country exist in map
            throw new IllegalArgumentException();
        else country.addCity(new City(name, country, population));
    }

    public int population() {
        int counter = 0; //for each country
        for (HashMap.Entry<String, Country> entry : countries.entrySet())
            counter += entry.getValue().population(); //count population
        return counter;
    }

    public List<City> smallCities(int under) {
        List<City> set = new LinkedList<>(); //create list for output
        for (HashMap.Entry<String, Country> entry : countries.entrySet())
            set.addAll(entry.getValue().smallCities(under)); //get cities to set
        return set;
    }


    public String report() {
        StringBuilder output = new StringBuilder();
        for (HashMap.Entry<String, Country> entry : countries.entrySet())
            output.append(entry.getValue().report()).append("\n");
        return output.append("Total population is ").append(population()).append("\n").toString();
    }
}