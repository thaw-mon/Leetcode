package Year2020.September.day01;

import java.util.function.IntConsumer;

public class Demo05 {
}

//1195. 交替打印字符串
class FizzBuzz {
    private int n;
    //private AtomicInteger currentNumber = new AtomicInteger(0);
    int currentNumber = 1;
    private Object lock = new Object();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (lock) {
            while (currentNumber <= n) {
                if (currentNumber % 3 > 0 || currentNumber % 5 == 0) {
                    lock.wait();
                }
                if (currentNumber % 3 > 0 || currentNumber % 5 == 0) continue;
                if (currentNumber > n) return;
                printFizz.run();
                currentNumber++;
                lock.notifyAll();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (lock) {
            while (currentNumber <= n) {
                if (currentNumber % 5 > 0 || currentNumber % 3 == 0) {
                    lock.wait();
                }
                if (currentNumber % 5 > 0 || currentNumber % 3 == 0) continue;
                if (currentNumber > n) return;
                printBuzz.run();
                currentNumber++;
                lock.notifyAll();
            }

        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (lock) {
            while (currentNumber <= n) {
                if (currentNumber % 5 > 0 || currentNumber % 3 > 0) {
                    lock.wait();
                }
                if (currentNumber % 5 > 0 || currentNumber % 3 > 0) continue;
                if (currentNumber > n) return;
                printFizzBuzz.run();
                currentNumber++;
                lock.notifyAll();
            }

        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while (currentNumber <= n) {
                if (currentNumber % 5 == 0 || currentNumber % 3 == 0) {
                    lock.wait();
                }
                if (currentNumber % 5 == 0 || currentNumber % 3 == 0) continue;
                if (currentNumber > n) return;
                printNumber.accept(currentNumber);
                currentNumber++;
                lock.notifyAll();
            }

        }

    }
}