package graph;

import java.util.Collection;
import java.util.HashSet;

public class Maze implements GraphInterface<Place> {

    private char[][] maze; //to save our points as chars
    private final Place[][] ways; //to save possible ways
    private final Place start, end; //start and end points
    private final int size; //size of maze
    private Graph<Place> ask; //Graph for isSolvable method
    
    public Maze(int size, int startx, int starty, int endx, int endy) {
            this.size = size; //define size
            maze = new char[size][size]; //create maze
            ways = new Place[size][size]; //create ways

        try { /* fill maze with point and create all ways*/
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    maze[i][j] = '.';
                    ways[i][j] = new Place(i, j, size);
                }
            }
            maze[startx][starty] = 'S'; //make start point 'S"
            start = ways[startx][starty]; //save to start variable

            maze[endx][endy] = 'E'; //make end point 'E'
            end = ways[endx][endy]; //save to end variable

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public boolean addWall(int x, int y) {
        try { /* set walls as '@', and delete from ways */
            maze[x][y] = '@';
            ways[x][y] = null;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        /* for each point in maze*/
        for (char[] i : maze) {
            for (char j : i) {
                output.append(j);
            } /* append to string builder*/
            output.append("\n"); // new line
        }
        return output.toString();
    }

    public boolean isSolvable() {
         ask = new Graph<>();
        /* for each possible way*/
        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (this.ways[i][j] != null) {
                        ask.addVertex(ways[i][j]);
                    }
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    /* connect points with edges if possible */
                    helper(i, j, i - 1, j);
                    helper(i, j, i, j + 1);
                    helper(i, j, i + 1, j);
                }
            }
            return ask.connected(start, end);
        } catch (GraphException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void helper(int i, int j, int k, int m) {
        try { /* instead of check bounds just catching and ignoring exception */
            ask.addEdge(ways[i][j], ways[k][m]);
        } catch (Exception ignored) {
        }
    }

    private void neighbourGet(Collection<Place> gipsy, int getX, int getY) {
        try { /* we will check if ways at specific place not null */
            if (ways[getX][getY] != null)
                gipsy.add(ways[getX][getY]);
        } catch (ArrayIndexOutOfBoundsException ignored) {
            /* but still ignore exception, just because it's useless */
        }
    }

    @Override
    public Collection<Place> neighbours(Place place) {
        Collection<Place> gipsy = new HashSet<>();
        /* get coordinates */
        int getX = place.getX();
        int getY = place.getY();
        /* get neighbours */
        neighbourGet(gipsy, getX - 1, getY);
        neighbourGet(gipsy, getX, getY + 1);
        neighbourGet(gipsy, getX + 1, getY);
        return gipsy; /* return our 'collector' */
    }
}