import java.util.Scanner;

public class ErezIr {
    private char letter = 'A';

    private synchronized void incLetter() {
            if (letter == 'Z') {
                letter = 'A';
            }
            else letter++;
    }

    private synchronized char getLetter() {
            return letter;
    }

    private class Counter implements Runnable {
        public void run() {
            try {
                while (true) {
                    System.out.print(letter);
                    Thread.sleep(250);
                    incLetter();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void runExample() {
        Thread t = new Thread(new Counter());
        t.start();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        t.interrupt();
        System.out.println("STOP. Enter is pressed");
        System.out.println(("Letter is " + letter));
    }

    public static void main(String[] args) {
        new ErezIr().runExample();
    }
}
/*ABCDEFGHIJKLMNOPQRSTUVWXYZ
STOP. Enter is pressed
Letter is Z*/