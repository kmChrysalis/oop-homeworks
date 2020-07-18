package circuits;

import java.util.ArrayList;

public class OrGate extends Gate {
    private static OrGate _OR = new OrGate(null);

    public OrGate(Gate[] inGates) {
        super(inGates);
    }

    private static Gate instance() {
        return (_OR == null) ? new OrGate(null) : _OR;
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException{
        try {
            boolean out = false;
            for (boolean temp : inValues) //run for each
                out = out || temp; //calculate OR
            return out;
        } catch (Exception e) { //catch any exception
            throw new CircuitException(); //throw new one
        }
    }

    @Override
    public String getName() {
        return "OR";
    }

    @Override
    public Gate simplify() {
        ArrayList<Gate> out = new ArrayList<>(); //will use an ArrayList for create dynamic Array

        for (Gate temp : inGates) { //run for each inGate
            Gate simple = temp.simplify(); //simplify gate
            if (simple instanceof TrueGate) return TrueGate.instance(); //if True -> return True
            if (!(simple instanceof FalseGate)) out.add(simple); //if False dd to array
        }

        Gate[] out_arr = new Gate[out.size()]; //new array of Gates with size
        out_arr = out.toArray(out_arr);

        return (out_arr.length == 1) ? out_arr[0] : //if length == 1 > return out_arr[0]
                (out_arr.length == 0) ? FalseGate.instance() : //if length == 0 > return FalseGate
                        new OrGate(out_arr); //create new OrGate
    }
}

