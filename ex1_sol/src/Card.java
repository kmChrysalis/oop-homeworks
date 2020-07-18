
public class Card {
    private int rank;
    private int suit;

    public Card(int num, int suit) { //constructor for card
        rank = num;
        this.suit = suit;
    }

    public int getNum() { //getter for rank of card
        return rank;
    }

    public int getSuit() { //getter for suit of card
        return suit;
    }

    public String toString() {
        String[] str = {"C", "D", "H", "S"}; //array for possible suits
        if (suit >= 0 && suit < 4) { //check if suit is legal
            return rank + str[suit]; //return formatted string
        }
        else return null;
    }

    public int compareTo(Card other) {
        int rankDiff = getNum() - other.getNum(); // count difference between this and other ranks
        int suitDiff = getSuit() - other.getSuit(); // count difference between this and other suits
        if (rankDiff != 0) return rankDiff; //check if ranks are not equal
        else return suitDiff; //return si
    }
}