package iterator;

public class Fibonacci implements Iterator{
    private int next_num;
    private int prev1, prev2;
    private int upperBound;

    public Fibonacci(int upperBound) {
        this.prev1 = 0;
        this.prev2 = 0;
        this.next_num = 1;
        this.upperBound = upperBound;
    }

    @Override
    public boolean hasNext() {
        return this.next_num <= this.upperBound;
    }
    @Override
    public int next() {
        if (this.upperBound > 0) { //check if upperbound is legal
            if (this.hasNext()) { //if has next, do:
                this.prev1 = this.prev2;
                this.prev2 = this.next_num;
                this.next_num += this.prev1;
            }
            return this.prev2; //adn return
        } else return 0; //or return 0
    }
}
