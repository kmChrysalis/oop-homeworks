import java.util.Scanner;

public class Cascade {
    private Thread[] threads;

    private static void justSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private class Runner implements Runnable {
        private final int Wake;

        public Runner (int i) {
            Wake = (i < threads.length - 1) ? i + 1 : 0;
        }
        @Override
        public void run() {
            while (true) {
                justSleep(Long.MAX_VALUE);
                System.out.println(String.format("I am thread number #%s inviting a thread #%s", Thread.currentThread().getName(), threads[Wake].getName()));
                justSleep(1000);
                threads[Wake].interrupt();
            }
        }
    }
    public void runExample(int n) {
        threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(new Runner(i));
            threads[i].start();
        }
        threads[0].interrupt();
    }
    public static void main(String[] args) {
        System.out.print("Enter number of threads: ");
        Scanner scan = new Scanner(System.in);
        new Cascade().runExample(scan.nextInt());
    }
}
/*Enter number of threads: 4
I am thread number #11 inviting a thread #12
I am thread number #12 inviting a thread #13
I am thread number #13 inviting a thread #14
I am thread number #14 inviting a thread #11
I am thread number #11 inviting a thread #12
I am thread number #12 inviting a thread #13
I am thread number #13 inviting a thread #14 */