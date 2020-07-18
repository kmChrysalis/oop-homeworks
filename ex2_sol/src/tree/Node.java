
package tree;

public class Node {
    private Node[] children;
    private int count;

    public Node() { //Node constructor
        this.children = new Node[26];
        this.count = 0;
    }

    public int num(String s) { //
        return (s.length() != 0) ? //if it's end of string or no string here
                (children[s.charAt(0) - 'a'] != null) ? //if there's another node after this
                    children[s.charAt(0) - 'a'].num(s.substring(1)) : 0 : //then go deeper, else return 0
                        count; //end of string is true? so return count
    }

    public void add(String s) {
        int l = s.length(); //get string length
        if (l != 0) { //string not null
            if (children[s.charAt(0) - 'a'] == null) { //but have no children at this character
                this.children[s.charAt(0) - 'a'] = new Node(); //create children here
                this.children[s.charAt(0) - 'a'].add(s.substring(1, l)); //go deeper
            }
            else this.children[s.charAt(0) - 'a'].add(s.substring(1, l)); //there's already children, just go deeper
        }
        else this.count++; //count full word only, when string is null
    }
}