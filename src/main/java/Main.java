import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        CountDownLatch cd1 = new CountDownLatch(10);
        CountDownLatch cd2 = new CountDownLatch(10);
        CountDownLatch cd3 = new CountDownLatch(10);
        CountDownLatch cd4 = new CountDownLatch(10);
        CountDownLatch cd5 = new CountDownLatch(10);
        CountDownLatch cd6 = new CountDownLatch(10);
        CountDownLatch cd7 = new CountDownLatch(10);
        CountDownLatch cd8 = new CountDownLatch(10);
        CountDownLatch cd9 = new CountDownLatch(10);
        CountDownLatch cd10 = new CountDownLatch(10);
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.execute(new MyThread(cd1,"A"));
        es.execute(new MyThread(cd2,"B"));
        es.execute(new MyThread(cd3,"C"));
        es.execute(new MyThread(cd4,"D"));
        es.execute(new MyThread(cd5,"E"));
        es.execute(new MyThread(cd6,"F"));
        es.execute(new MyThread(cd7,"G"));
        es.execute(new MyThread(cd8,"H"));
        es.execute(new MyThread(cd9,"I"));
        es.execute(new MyThread(cd10,"J"));
        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
            cd5.await();
            cd6.await();
            cd7.await();
            cd8.await();
            cd9.await();
            cd10.await();
        }catch (InterruptedException e){
            System.out.println(e);
        }

        es.shutdown();
    }
}
