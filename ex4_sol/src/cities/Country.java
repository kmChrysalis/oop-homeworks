package cities;

import java.util.*;

public class Country implements Comparable<Country> {
    private String CountryName;
    private Set<City> cities = new TreeSet<>();

    public Country(String name) {
        this.CountryName = name;
    }

    public void addCity(City city) { /* Add city if it's same Country */
        if (!this.equals(city.getCountry()))
            throw new IllegalArgumentException();
        else cities.add(city);
    }

    public int population() {
        int count = 0; //count population for each city
        for (City entry : cities)
            count += entry.getPopulation();
        return count;
    }

    public String toString() {
        return CountryName;
    }

    public List<City> smallCities(int under) {
        List<City> output = new LinkedList<>();
        for (City entry : cities) //for each city check if
            if (entry.getPopulation() < under) //population < under
                output.add(entry); //than add
        return output;
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        int total = 0; //counter for total population
        for (City entry : cities) { //for each city
            output.append(entry.getName()).append("(").append(entry.getPopulation()).append("), "); //get data to string
            total += entry.getPopulation(); //count population to total
        }
        output.delete(output.length() - 2, output.length()); //delete last to symbols
        return CountryName + "(" + total + ") : " + output.toString(); //return String
    }

    @Override
    public int compareTo(Country country) {
        return equals(country) ? 1 : 0;
    }

    @Override
    public boolean equals(Object country) {
        Country cntry = (Country) country;
        /* some tests before */
        if (cntry == null) return false;
        if (this.getClass() != cntry.getClass()) return false;
        if (cntry == this) return true;
        /* then return answer */
        return CountryName.equals(cntry.toString());
        //return CountryName.equals(country.CountryName) ? 1 : 0;
    }
}