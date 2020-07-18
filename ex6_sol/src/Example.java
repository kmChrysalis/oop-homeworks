public class Example {
    Exchange<String> exchange = new Exchange<>();

    private class Runner1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Runner1");
            System.out.println("Runner1 got: " + exchange.give1("Hi1"));
        }
    }

    private class Runner2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Runner2");
            System.out.println("Runner2 got: " + exchange.give2("Hi2"));
        }
    }

    public void runExample() {
        while (true) {
            new Thread(new Runner1()).start();
            new Thread(new Runner2()).start();
        }
    }

    public static void main(String[] args) {
        new Example().runExample();
    }

}