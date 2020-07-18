package circuits;

public class FalseGate extends Gate {

    private static FalseGate _F = new FalseGate();

    private FalseGate() { //constructor
        super(null);
    }

    public static Gate instance() { //if gate doesn't exist return new, else return this
        return (_F == null) ? new FalseGate() : _F;
    }

    @Override
    public String getName() {
        return "F";
    }

    @Override
    protected boolean func(boolean[] inValues) {
        return false;
    }

    @Override
    public Gate simplify() {
        return instance();
    }

}
