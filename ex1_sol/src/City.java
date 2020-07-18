
public class City {
    private final String name;
    private final Road[] roads;
    private int numRoads;

    public City(String name) { //Constructor for the city
        this.name = name;
        roads = new Road[10];
        numRoads = 0;
    }

    public void connect(Road r) { //saving road to array of roads connected to this city
        if (numRoads < 10) {
            roads[numRoads] = r;
            numRoads++;
        }
    }

    public City nearestCity() {
        int min = 0; //min - for save index of nearest city
        for (int i = 0; i < numRoads; i++) { //check each road and get it's length
            if (roads[i].getLength() < roads[min].getLength()) { //save index of road with minimal distance
                min = i;
            }
        } //check which city to return, null if there's no second city connected
        if (this.name.equals(roads[min].getCity1().name))
            return roads[min].getCity2();
        else if (this.name.equals(roads[min].getCity2().name))
            return roads[min].getCity1();
        return null;
    }

    public String toString() {
        return name;
    }
}
