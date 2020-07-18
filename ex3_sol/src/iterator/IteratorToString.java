package iterator;

public class IteratorToString {

    public static String toString(Iterator it) {
        StringBuilder output = new StringBuilder("["); //start string with [
        while(it.hasNext()) //while has next
            output.append(it.next()).append(" "); //append new number and ,
        return output.replace(output.length() - 1, output.length(), "]").toString(); //finish with ]
    }
}
