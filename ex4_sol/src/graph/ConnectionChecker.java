package graph;

import java.util.Collection;
import java.util.HashSet;

public class ConnectionChecker<V> {

    private GraphInterface<V> graph;
    private Collection<V> visited;
    
    public ConnectionChecker(GraphInterface<V> g) {
        graph = g;
        visited = new HashSet<>();
    }

    public boolean check(V v1, V v2) {
        if (visited.contains(v1)) return false; //fast check if v1 was visited
        if (v1.equals(v2)) return true; //check if vertices are equal
        if (graph.neighbours(v1).contains(v2)) return true; //or maybe neighbours
        else visited.add(v1); //make v1 visited
        for (V next : graph.neighbours(v1)) { //for each neighbour
            if (check(next, v2)) return true; //repeat check
        }
        return false;
    }
}