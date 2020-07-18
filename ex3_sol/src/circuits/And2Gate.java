package circuits;

public class And2Gate extends AndGate {

    public And2Gate(Gate g1, Gate g2) {
        super(new Gate[] {g1, g2}); //build array with two gates and send to super-class
    }
}
