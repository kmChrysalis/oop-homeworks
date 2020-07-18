package cities;

public class City implements Comparable<City> {

    private String CityName;
    private Country Country;
    private int population;

    public City(String name, Country country, int population) {
        this.CityName = name;
        this.Country = country;
        this.population = population;
    }

    public String getName() {
        return CityName;
    }

    public Country getCountry() {
        return Country;
    }

    public int getPopulation() {
        return population;
    }

    public String toString() {
        return CityName + " (of " + Country.toString() + ")";
    }

    @Override
    public int compareTo(City city) {
        /* get data to variables */
        String country1 = Country.toString();
        String city1 = CityName;
        String country2 = city.Country.toString();
        String city2 = city.CityName;
        /* return 1 if equals, 0 if not */
        return (country1.compareTo(country2) == 0) ? city1.compareTo(city2) : -1;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.compareTo((City) obj) == 0);
    }

}