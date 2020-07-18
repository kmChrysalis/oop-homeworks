package tree;

import java.util.Scanner;

public class ReversedWords {
    public static int checkReversed() {
        int count = 0;
        Node n = new Node();
        Scanner scan = new Scanner(System.in);
        StringBuilder pmet = new StringBuilder(); //string builder for reversed words (pmet is revers to temp)
        String temp = scan.next(); //get first word to temp
        while (!temp.equals("X")) { //while temp not getting X
            pmet.append(temp); //append temp to pmet
            pmet.reverse();//reverse temp
            count += (n.num(pmet.toString()) != 0) ? 1 : 0; //count++ if num returns not null
            n.add(temp); //add word to tree
            pmet.delete(0, pmet.length()); //delete pmet
            temp = scan.next(); //scan next word
        }
        scan.close(); //close scanner
        return count; //return count
    }
}
