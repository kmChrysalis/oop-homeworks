package graph;

import java.util.*;

public class Graph<V> {

    private Set<V> vertices = new HashSet<>();
    private Map<V, Set<V>> edges = new HashMap<>();
    private HashSet<V> visited;

    public void addVertex(V v) throws GraphException {
        if (vertices.contains(v)) //check if graph contains vertex v
            throw new GraphException("Vertex already exist.");
        else vertices.add(v); //add if not
    }

    public void addEdge(V v1, V v2) throws GraphException {
        if (!vertices.contains(v1) || !vertices.contains(v2)) //check if vertices in graph
            throw new GraphException("Can't add edge, vertex doesn't exist");

        if (hasEdge(v1, v2)) //maybe they are already connected
            throw new GraphException("Edge already exist");
        /* try to connect them in both directions */
        helpAddEdge(v1, v2);
        helpAddEdge(v2, v1);
    }

    private void helpAddEdge(V v1, V v2) {
        try { //trying add regular edge
            edges.get(v1).add(v2);
        } catch (NullPointerException e) { //vertex doesn't have edges
            Set<V> set = new HashSet<>(); //create set of edges
            set.add(v2); //add v2 to set
            edges.put(v1, set); //put new edge to Map
        }
    }

    public boolean hasEdge(V v1, V v2) {
        /* check if edges contains both vertices */
        boolean ver1 = edges.containsKey(v1);
        boolean ver2 = edges.containsKey(v1);
        return (ver1 && ver2 && //edges must contain them
                edges.get(v1).contains(v2) && //and v1 must be neighbour of v2
                edges.get(v2).contains(v1));  //and v2 must be neighbour of v1
    }

    public boolean connected(V v1, V v2) throws GraphException {
        visited = new HashSet<>();
        /* if v1 equals to v2, dont need to be checked */
        if (v1.equals(v2)) return true;
        /* check if vertex in the graph, and throw exception if not*/
        if (!vertices.contains(v1) || !vertices.contains(v2))
            throw new GraphException("Vertices doesn't connected");
        /* check if vertices has edges */
        if (!edges.containsKey(v1) || !edges.containsKey(v2))
            return false;
        /* check if vertices are not exist or not connected */

        /* if they are neighbours it's easy */
        return hasEdge(v1, v2) || BFS(v1, v2);
        /* but we have to travel the graph, if they are not */
    }

    private boolean BFS(V v1, V v2) {
        if (visited.contains(v1)) return false; //fast check if v1 was visited
        if (v1.equals(v2)) return true; //check if vertices are equal
        if (edges.get(v1).contains(v2)) return true; //or maybe neighbours
        else visited.add(v1); //add vertex to visited set
        for (V next : edges.get(v1)) { //and for each
            if (BFS(next, v2)) return true;//check him
        }
        return false;
    }
}