package graph;

public class Place {
    private int x, y;
    private int bound;

    public Place(int x, int y, int bound) {
        if (x < 0 || y < 0 || x > bound - 1 || y > bound - 1)
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
        this.bound = bound;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        /* will give exact counter by place in matrix */
        return bound * x + y;
    }

    @Override
    public boolean equals(Object obj) {
        Place o = (Place) obj;
        /* some tests before */
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        if (o == this) return true;
        /* then return answer */
        return getX() == o.getX() && getY() == o.getY();

    }
}