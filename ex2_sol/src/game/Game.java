package game;

import java.util.Scanner;

public class Game extends Board {
    protected Player[] players;
    protected final Scanner s = new Scanner(System.in);

    public Game(int n, int m, Player p1, Player p2) {
        super(n, m); //send n, m to Board constructor
        this.players = new Player[2]; //players array
        this.players[0] = p1; //fill player 1
        this.players[1] = p2; //fill player 2
    }

    protected boolean doesWin(int i, int j) {
    	if (!this.isEmpty(0, 0)) {
    		System.out.println(super.get(i, j).toString()+" Won!\n");
    		return true;
    	}
    	else return false; //if 0, 0 is empty no winner
    }

    protected boolean onePlay(Player p) {
        System.out.print(p.toString() + ", please enter x and y: ");
        int i = s.hasNextInt() ? s.nextInt() : -1; //get first number if exist
        int j = s.hasNextInt() ? s.nextInt() : -1; //get second number if exist
        System.out.println(i + ", " + j);
        if (i != -1 && j != -1)
            return this.set(i, j, p) ? this.doesWin(i, j) : this.onePlay(p); //try to set and returns
        else return false;
    }

    public Player play() {
        while(!super.isFull()) { //if board doesn't full
            if (this.onePlay(this.players[0])) return this.players[0]; //onePlay for player1
            if (this.onePlay(this.players[1])) return this.players[1]; //onePlay for player2
        }
        return null; //return 0
    }

}
