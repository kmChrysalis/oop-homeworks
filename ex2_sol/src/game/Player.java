package game;

public class Player {
    private String name;
    private char mark;

    public Player(String name, char mark) { // player constructor
        this.name = name;
        this.mark = mark;
    }

    public String getName() { //name getter
        return name;
    }

    public char getMark() { //mark getter
        return mark;
    }

    @Override
    public String toString() { //new toString
       return (name+"("+mark+")");
    }
}
