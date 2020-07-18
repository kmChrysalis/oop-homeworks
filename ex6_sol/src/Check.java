public class Check {

    private boolean[] a;
    private java.lang.Thread mainThread;

    public Check(boolean[] a) {
        this.a = a;
    }

    private class Searcher implements Runnable {
        private int from, to;
        public Searcher(int from, int to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public void run() {
            for (int i = from; i < to; i++)
                if (java.lang.Thread.interrupted())
                    return;
                else if (a[i])
                    mainThread.interrupt();
        }
    }

    public void check(int n) {
        java.lang.Thread[] threads = new java.lang.Thread[n];
        mainThread = java.lang.Thread.currentThread();
        int range = a.length / n;
        for (int i = 0; i < n; i++) {
            threads[i] = new java.lang.Thread(new Searcher(range * i,
                    (i == n - 1) ? a.length : range * (i + 1)));
            threads[i].start();
        }
        try {
            for (java.lang.Thread t : threads)
                t.join();
        } catch (InterruptedException e) {
            for (java.lang.Thread t : threads)
                t.interrupt();
            System.out.println("found it!");
            return;
        }
        if (java.lang.Thread.interrupted())
            System.out.println("found it!");
        else
            System.out.println("Not there.");
    }

    public static void main(String[] args) {
        boolean[] a = new boolean[100000000];
        a[a.length - 1] = true;
        long time = System.currentTimeMillis();
        new Check(a).check(2);
        System.out.println(System.currentTimeMillis() - time);
    }
}
