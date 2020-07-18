
public class Road {

    private int length;
    private City city1;
    private City city2;

    public Road(City city1, City city2, int length) { //constructor for the Road
        this.city1 = city1;
        this.city2 = city2;
        this.length = length;
        city1.connect(this);
        city2.connect(this);
    }

    public City getCity1() { //getter city1
        return city1;
    }

    public City getCity2() { //getter city2
        return city2;
    }

    public int getLength() { //getter length of road
        return length;
    }
}
