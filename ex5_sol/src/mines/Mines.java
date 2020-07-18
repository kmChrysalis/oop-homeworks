package mines;

import java.util.HashSet;
import java.util.Random;

public class Mines {

    private Place[][] field; //places array for mine field
    private int numMines, opens; //counters for mines and opened cells
    private int height, width; //size variables
    private boolean showAll = false; //showAll trigger, false by default

    private class Place { //nested class Place for our field with default variables
        private boolean flag = false;
        private boolean mine = false;
        private boolean opened = false;
        private int counter = 0;

        private Place() {} //default builder
    }

    public Mines(int height, int width, int numMines) {
        //create and fill the field with default places
        field = new Place[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = new Place();
            }
        }
        this.height = height;
        this.width = width;
        this.numMines = numMines;
        if (numMines > 0) { //filling field with mines if constructor got some number bigger then 0
            HashSet<Integer> Set = new HashSet<>(); //hash set is for random sets we create to exclude multiplying
            Random rand = new Random(); //for random cells for mines
            for (int i = 0; i < numMines; i++) {
                int y = Math.abs(rand.nextInt(height)); //randomize Y value
                int x = Math.abs(rand.nextInt(width)); //randomize X value
                if (Set.isEmpty()) { //my set is saving HashCode of each random combination
                    addMine(y, x); //add mine to game
                    Set.add(y * height + x); //save this HashCode
                    this.numMines--;
                } else if (Set.contains(y * height + x)) {
                    i--; //we got same value, so got back for one step in loop
                } else {//set wasn't empty, but we got new value
                    addMine(y, x); //so add this mine
                    Set.add(y * height + x); //and save HashCode
                    this.numMines--;
                }
            }
        }
    }


    public void addMine(int i, int j) {
        try { //trying to add mine, but care about exception
            if (!field[i][j].mine) { //check if not mine yet
                field[i][j].mine = true; //set flag on
                numMines++; //count mines
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
        /* call for function that will add counter to place that mine is neighbour */
        addMineHelper(i, j - 1); //left
        addMineHelper(i - 1, j - 1); //left up
        addMineHelper(i - 1, j); //up
        addMineHelper(i - 1, j + 1); //up right
        addMineHelper(i, j + 1); //right
        addMineHelper(i + 1, j + 1); //right down
        addMineHelper(i + 1, j); //down
        addMineHelper(i + 1, j - 1); //down left
    }

    private void addMineHelper(int i, int j) {
        try { //check if this cell not mine, and counter less then maximum possible
            if (!field[i][j].mine && field[i][j].counter < 8)
                field[i][j].counter++;
        } catch (ArrayIndexOutOfBoundsException ignored) { } //ignore this exception because of bounds of array
    }

    public boolean open(int i, int j) {
        try { //trying open cell, if it's mine, return false
            if (field[i][j].mine) return false;
            else {
                opens++; //if opening succeed, count
                field[i][j].opened = true; //make this flag = true
                if (field[i][j].counter == 0) { //if there's no mine at neighbours. try to open neighbours
                    openNeighbours(i, j - 1); //left
                    openNeighbours(i - 1, j - 1); //left up
                    openNeighbours(i - 1, j); //up
                    openNeighbours(i - 1, j + 1); //up right
                    openNeighbours(i, j + 1); //right
                    openNeighbours(i + 1, j + 1); //right down
                    openNeighbours(i + 1, j); //down
                    openNeighbours(i + 1, j - 1); //down left
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
            return false; //return false if there's no cell with those index
        }
        return true; //if everything good, return true
    }

    private void openNeighbours(int i, int j) {
        try {//check if it's not mine, and not opened yet, so will try to open it
            if (!field[i][j].mine && !field[i][j].opened) open(i, j);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public boolean toggleFlag(int x, int y) {
        field[x][y].flag = !field[x][y].flag; //switch flag to opposite state
        return field[x][y].flag;
    }

    public boolean isDone() {
        /* check if (num of cells - num of mines - opened cells) equal zero and return answer */
        return height * width - numMines - opens == 0;
    }

    public String get(int i, int j) {
        if (!showAll) { //if we are not showing all
            if (!field[i][j].opened) { //check if cell is not opened
                if (field[i][j].flag) return "F"; //or it's flag
                else return "."; //or it's closed one
            }
        }
        //in any other case this:
        return (field[i][j].mine) ? "X" :
                (field[i][j].counter == 0) ? " " : field[i][j].counter+"";
    }

    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }

    public boolean isOpened(int i, int j) {
        return field[i][j].opened;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                out.append(get(i, j));
            }
            out.append("\n");
        }
        return out.toString();
    }
}