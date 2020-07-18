package circuits;

import java.util.ArrayList;

public class AndGate extends Gate {

    private static AndGate _AND = new AndGate(null); //make new instance with no gates

    public AndGate(Gate[] inGates) {
        super(inGates); //send array to super-class Gate
    }

    private static Gate instance() { //if no instance, make new and send else just send an exist one
        return (_AND == null) ? new AndGate(null) : _AND;
    }

    @Override
    public String getName() {
        return "AND";
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        try {
            boolean out = true;
            for (boolean temp : inValues) //go through input values and calculate AND-operation
                out = out && temp;
            return out;
        } catch (Exception e) { //catch any exception
            throw new CircuitException(); //throw Circuit
        }
    }

    @Override
    public Gate simplify() {
        ArrayList<Gate> out = new ArrayList<>();

        for (Gate temp : inGates) { //for each inGate check
            Gate simple = temp.simplify();
            if (simple instanceof FalseGate) return FalseGate.instance(); //if one of them FalseGate, return tho
            if (!(simple instanceof TrueGate)) out.add(simple); //if not TrueGate add to array
        }

        Gate[] out_arr = new Gate[out.size()];
        out_arr = out.toArray(out_arr);

        return (out_arr.length == 1) ? out_arr[0] : //if length == 1 return out_arr[0]
                (out_arr.length == 0) ? TrueGate.instance() : //else if == 0 return true gate
                        new AndGate(out_arr); //else create new AndGate with out_arr as inGates
    }
}
