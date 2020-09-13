package Year2020.September.day01.CountDownExample;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {

    private CountDownLatch downLatch;
    private String name;
    private int workNumber;

    public Worker(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
        workNumber = 0;
    }

    public void run() {
        this.doWork();
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            } catch (InterruptedException ie) {
            }
            System.out.println(this.name + "活干完了一份！");
            workNumber++;
            this.downLatch.countDown();
            synchronized (downLatch) {
                if (downLatch.getCount() == 0) break;
            }
        }


    }

    private void doWork() {
        System.out.println(this.name + "正在干活!");
    }

}