package lazyguy.yyf.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    ai.addAndGet(2);
                }
            }
        };
        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);
        threadA.start();
        threadB.start();


        threadA.join();
        threadB.join();

        System.out.println(ai.get());
    }
}