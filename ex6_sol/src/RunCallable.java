public class RunCallable<U, V> {
    private U result = null;
    private final Object monitor  = new Object();
    public U getResult() { return result; }
    public void start(Callable<U, V> c, V val) {
        new Thread(() -> {
            U res = c.call(val);
            synchronized (monitor) {
                result = res;
                monitor.notifyAll();
            }
        }).start();
    }
    public U waitForResult() {
        synchronized(monitor) {
            if (result == null) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        RunCallable<String, Integer> rc = new RunCallable<>();
        rc.start(val -> {
            justSleep(1000);
            return "Result" + val;
        }, 45);
        for (int i = 0; rc.getResult() == null; i++) {
            System.out.println(i++ + ". Result = " + rc.getResult());
            justSleep(300);
        }
        System.out.println("Result = " + rc.waitForResult());
    }
    private static void justSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}