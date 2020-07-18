package circuits;

public class TrueGate extends Gate {

    private static TrueGate _T = new TrueGate();

    private TrueGate() { //constructor
        super(null);
    }

    public static Gate instance() { //same as FalseGate
        return (_T == null) ? new TrueGate() : _T;
    }

    @Override
    public String getName() {
        return "T";
    }

    @Override
    protected boolean func(boolean[] inValues) {
        return true;
    }

    @Override
    public Gate simplify() {
        return instance();
    }
}