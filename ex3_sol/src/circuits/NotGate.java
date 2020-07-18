package circuits;

public class NotGate extends Gate {
    private static NotGate _NOT = new NotGate(null);

    public NotGate (Gate in) {
        super(new Gate[] {in});
    }

    private static Gate instance() {
        return (_NOT == null) ? new NotGate(null) : _NOT;
    }

    @Override
    public String getName() {
        return "NOT";
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
       try {
           return !inValues[0]; //try return only value from inValues
       }
       catch (NullPointerException e) { //catch null pointer exception, throw new one
           throw new CircuitException();
       }
    }

    @Override
    public Gate simplify() {
        Gate simple = inGates[0].simplify(); //get simplified gate
        return (simple instanceof TrueGate) ? FalseGate.instance() : //if it's True return False
                (simple instanceof FalseGate) ? TrueGate.instance() : //if it's False return True
                               this; //else return this gate
    }
}
