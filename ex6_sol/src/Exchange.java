public class Exchange<E> {
    private E e1 = null;
    private E e2 = null;
    private synchronized void justWait() {
        try {
            wait();
        }catch (InterruptedException ignored) {}
    }
    public synchronized E give1(E e) {
        this.e1 = e;
        while (e2 == null) {
            justWait();
        }
        notify();
        return e2;
    }
    public synchronized E give2(E e) {
        this.e2 = e;
        while (e1 == null) {
            justWait();
        }
        notify();
        return e1;
    }
}
/*Runner1
Runner2
Runner1 got: Hi2
Runner2 got: Hi1
Runner1
Runner1 got: Hi2
Runner2
Runner2 got: Hi1
Runner2
Runner2 got: Hi1*/