package circuits;

public abstract class Gate {

    protected Gate[] inGates;

    public Gate(Gate[] inGates) {
        this.inGates = inGates;
    }

    public boolean calc() throws CircuitException {
        try {
            boolean[] inValues = new boolean[this.inGates.length]; //create array
            for (int i = 0; i < inValues.length ; i++)  //calc each one
                inValues[i] = this.inGates[i].calc(); //save to inValues
            return func(inValues); //call to func for specific gate
        }
        catch (NullPointerException e) { //catch null pointer exception
            return func(null); //just use func without values
        }
        catch (Exception e) { //catch any other, return our new exception
            throw new CircuitException();
        }
    }

    public String toString() {
        if (inGates == null) { //if no inGates return only the name
            return this.getName();
        } else {    //or just build the String
            StringBuilder s = new StringBuilder(getName() + "[");
            for (Gate temp : inGates)
                s.append(temp.toString()).append(", ");
            s.replace(s.length() - 2, s.length(), "]");
            return s.toString();
        }
    }

    protected abstract boolean func(boolean[] inValues) throws CircuitException ;

    public abstract String getName();

    public abstract Gate simplify();

}
