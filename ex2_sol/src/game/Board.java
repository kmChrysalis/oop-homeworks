package game;

public class Board {
    protected Player[][] board;
    protected int n, m;

    public Board(int n, int m) { //board constructor
        this.board = new Player[n][m];
        this.n = n;
        this.m = m;
    }

    protected boolean set(int i, int j, Player p) {
        System.out.println(p.toString()+" turn " + i + "," + j);
        if (this.isEmpty(i, j)) { //if i, j is empty
            this.board[i][j] = p; //then put player to this place
            System.out.println(this.toString());
            return true; //and return true
        } else return false; //if wasn't empty
    }

    public boolean isEmpty(int i, int j) { //check if empty and return
    	if (this.board[i][j] == null) return true;
    	else {
            System.out.println("Oops, " + i + "," + j + " is taken by " + this.get(i, j).toString() + "\n");
    	    return false;
        }
    }

    public Player get(int i, int j) { //typical getter for player at place i, j
        return this.board[i][j];
    }

    public boolean isFull() { //check if board is full
        for (Player[] i : this.board) //i[] = board
            for (Player j : i) //j = i[c];
                if (j == null) return false; //return false if there's at least one free space
        return true; //else return true at the end of loops
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                if (this.board[i][j] != null) //if i, j not null
                    out.append(this.board[i][j].getMark()); //get mark from there and append
                else out.append("."); //if null append .
            }
            out.append("\n"); //for each line append \n
        }
        return out.toString(); //return String
    }

    protected int maxLineContaining(int i, int j) {
        int[] count = new int[4]; //counters array
        int max = 0;

        if (board[i][j] == null) return 0;
        else {
            for (int k = 0; k < 4; k++) //just count main position for each counter
                count[k] += (board[i][j] != null) ? 1 : 0;

            //count positive vertical
            for (int k = i + 1; k < this.board.length; k++) {
                if (board[k][j] == board[i][j])
                    count[0]++;
                else break;
            }

            //count negative vertical
            for (int k = i - 1; k >= 0; k--) {
                if (board[k][j] == board[i][j]) {
                    count[0]++;
                } else break;
            }

            //count positive horizontal
            for (int k = j + 1; k < this.board[0].length; k++) {
                if (board[i][k] == board[i][j]) {
                    count[1]++;
                } else break;
            }

            //count negative horizontal
            for (int k = j - 1; k >= 0; k--) {
                if (board[i][k] == board[i][j]) {
                    count[1]++;
                } else break;
            }
            //count positive main diagonal
            for (int k = i + 1, l = j + 1; k < this.board.length && l < this.board[0].length; k++, l++) {
                if (board[k][l] == board[i][j]) {
                    count[2]++;
                } else break;
            }

            //count negative main diagonal
            for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
                if (board[k][l] == board[i][j]) {
                    count[2]++;
                } else break;
            }

            //count positive second diagonal
            for (int k = i - 1, l = j + 1; k >= 0 && l < this.board[0].length; k--, l++) {
                if (board[k][l] == board[i][j]) {
                    count[3]++;
                } else break;
            }

            //count negative second diagonal
            for (int k = i + 1, l = j - 1; k < this.board.length && l >= 0; k++, l--) {
                if (board[k][l] == board[i][j]) {
                    count[3]++;
                } else break;
            }

            for (int k : count) //for each k = count[i]
                max = Math.max(max, k); //get maximum
            return max; //return it
        }
    }
}