package graph;

import java.util.Collection;

public interface GraphInterface<V> {
    Collection<V> neighbours(V v);
}

