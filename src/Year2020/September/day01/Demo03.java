package Year2020.September.day01;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Demo03 {
    public static void main(String[] args){
        int n = 10;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        //创建三个线程
        new Thread(() -> {
            try {
                zeroEvenOdd.even(new Consumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(new Consumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(new Consumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

//打印结果为01020304 .... 0n
class ZeroEvenOdd {
    private int n;
    //1.使用同步锁加计数
    private boolean isZero = true;
    private Object lock = new Object();
    //使用信号量进行交替打印奇数偶数
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!isZero) {
                    lock.wait();
                }
                printNumber.accept(0);
                isZero = false;
                lock.notifyAll();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            synchronized (lock){
                while (isZero){
                    lock.wait();
                }
                printNumber.accept(i);
                isZero = false;
                lock.notifyAll();
            }
            odd.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            synchronized (lock){
                while(isZero){
                    lock.wait();
                }
                printNumber.accept(i);
                isZero = false;
                lock.notifyAll();
            }
            even.release();
        }
    }
}

class Consumer implements IntConsumer{

    @Override
    public void accept(int value) {
        System.out.print(value + " ");
    }
}
