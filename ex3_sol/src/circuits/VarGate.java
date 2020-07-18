package circuits;

public class VarGate extends Gate {
    private String _name;
    private Boolean _value;

    public VarGate(String name) { //constructor
        super(null);
        this._value = null;
        this._name = name;
    }

    public void setVal(boolean value) {
        this._value = value; //save value
    }

    @Override
    public String getName()	{
        return "V"+this._name;
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        if (this._value == null) // if no value throw exception
            throw new CircuitException();
        else return this._value; //else return in
    }

    @Override
    public Gate simplify() {
        return (this._value == null) ? this :
                (this._value) ? TrueGate.instance() : FalseGate.instance();
    }
}
