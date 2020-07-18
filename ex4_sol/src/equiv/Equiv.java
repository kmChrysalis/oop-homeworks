package equiv;

import java.util.HashMap;

public class Equiv<E> {
    /* Map is used for sets like which has their ID's*/
    private HashMap<E, Integer> map = new HashMap<>();
    private Integer setID = 0;

    public void add(E e1, E e2) {
            /* check keys in map */
        boolean hasE1 = map.containsKey(e1);
        boolean hasE2 = map.containsKey(e2);

        if (!hasE1 && !hasE2) { //if both not exist
            map.put(e1, setID); //put e1 with setID
            map.put(e2, setID++); //put e2 with same ID, and increment ID than
        }
        else if (!hasE1) //if only e1 not exist, add him to map, with ID of e2
            map.put(e1, map.get(e2));
        else if (!hasE2) //if e2 not exist, do the same with ID of e1
            map.put(e2, map.get(e1));
        else { /* if we are here, means both of keys exist in map */
            Integer value1 = map.get(e1); //get ID of e1
            Integer value2 = map.get(e2); //get ID of e2
            if (!value1.equals(value2)) //if ID's are not equal
                for (HashMap.Entry<E, Integer> test : map.entrySet()) //for each key
                    if (test.getValue().equals(value2)) //with same ID as e1
                        test.setValue(value1); //set ID of e1
        }
    }

    public boolean are(E e1, E e2) {
        return map.containsKey(e1) && map.containsKey(e2) ? //check if map contains keys
                map.get(e1).equals(map.get(e2)) //true: get their values and check
                : e1.equals(e2); //false: check if they are equal by key
    }
}