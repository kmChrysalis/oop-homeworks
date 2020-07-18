package game;

public class FourInARow extends Game {

    public FourInARow(String player1, String player2) { //constructor for Game with our players
        super(6, 7, new Player(player1, 'W'),
                new Player(player2, 'B'));
        System.out.println("Welcome "+player1+" and "+player2+" to Four In a Row game");
    }

    @Override
    protected boolean doesWin(int i, int j) {//check if one of a players get line >= 4
        if (this.maxLineContaining(i, j) >= 4) {
            System.out.println(super.get(i, j).toString()+" Won!\n");
            return true;
        }
        else return false;
    }

    @Override
    protected boolean onePlay(Player p) {
        int i = 5, j;
        if (s.hasNextInt()) { //check if string has something
            System.out.print(p.toString() + ", please enter column: ");
            j = s.nextInt(); //get column
            System.out.println(i + ", " + j);
            while (i > -1) { //while i in borders
                if (super.set(i, j, p)) //try to set
                    return this.doesWin(i, j); //if set return true
                else i--; //else repeat with i--
            }
        }
       return false; //return false in any other case
    }
}