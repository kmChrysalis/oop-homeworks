
public class Deck {
    private Card[] cards;
    private int deckSize;

    public Deck(int num) { //First constructor of deck
        deckSize = num*4; //calculate size of deck
        cards = new Card[deckSize]; //create new array of cards ( deck )
        for (int i = 0, k = 0; i < num; i++) { //repeat untill k < size of deck same as i < num
            for (int j = 0; j < 4; j++) { //repeat four times for each suit
                cards[k++] = new Card(i, j); //fill array
            }
        }
    }

    public Deck(Deck from, int num) { //Second constructor of deck
        cards = new Card[num]; //create new array of cards ( deck )
        for (int i = 0; i < from.deckSize && i < num; i++) {
            cards[i] = from.takeOne(); //take one card from deck "from"
            deckSize++; //increase size of new deck
        }
    }

    public Deck(Deck first, Deck second) { //Third constructor of deck
        deckSize = first.getNumCards() + second.getNumCards(); //calculate size of deck
        cards = new Card[deckSize]; //create new deck with new size
        for (int i = 0;  i < deckSize;) { //fill new deck one by one
            if (first.deckSize > 0) cards[i++] = first.takeOne();
            if (second.deckSize > 0) cards[i++] = second.takeOne();
        }
    }

    public int getNumCards() { //getter for deck size
        return this.deckSize;
    }

    public Card takeOne() {
        Card out;
        if (deckSize > 0) {
            out = cards[--deckSize];
            return out;
        }
        else return null;
    }

    public String toString() {
        if (cards.length > 0) { //check if there's any card in deck
            StringBuilder ret = new StringBuilder(cards[0].toString()); //put first card to offset
            for (int i = 1; i < deckSize; i++) { //repeat for each other card
                ret.append(", ").append(cards[i].toString());
            }
            return "[" + ret + "]"; //return our string
        }
        else return null;
    }

    public void sort() { //simple bubble sort
        Card temp;
        for (int i = 0; i < deckSize - 1; i++) {
            for (int j = 0; j < deckSize - i - 1; j++) {
                if (cards[j].compareTo(cards[j+1]) > 0) {
                    temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;

                }
            }
        }
    }
}
