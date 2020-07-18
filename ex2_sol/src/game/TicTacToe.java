package game;

public class TicTacToe extends Game {

    public TicTacToe(String player1, String player2) { //Game constructor
        super(3, 3, new Player(player1, 'X'),
                            new Player(player2, 'O'));
        System.out.println("Welcome "+player1+" and "+player2+" to TicTacToe game");
    }

    @Override
    protected boolean doesWin(int x, int y) { //doesWin override function
        if (this.maxLineContaining(x, y) >= n) {
            System.out.println(super.get(x, y).toString()+" Won!\n");
            return true;
        }
        else return false;
    }
}
