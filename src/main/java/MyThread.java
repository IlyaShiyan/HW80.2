import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable{

    String name;
    CountDownLatch latch;

    public MyThread(CountDownLatch latch,String name) {
        this.name = name;
        this.latch = latch;

        new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(name+ ": " + i);
            latch.countDown();
        }
    }
}
