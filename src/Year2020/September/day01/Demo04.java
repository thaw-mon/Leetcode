package Year2020.September.day01;

import java.util.concurrent.Semaphore;

public class Demo04 {
}

class H2O {

    private Semaphore oxygenSemaphore = new Semaphore(2);
    private Semaphore hydrogenSemaphore = new Semaphore(0);
   // private AtomicInteger hydrogenNumber = new AtomicInteger(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        //hydrogenNumber.incrementAndGet();
        oxygenSemaphore.release();
        /*if (hydrogenNumber.get() % 2 == 0) {
            oxygenSemaphore.release();
        }*/
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        oxygenSemaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hydrogenSemaphore.release(2);
    }
}