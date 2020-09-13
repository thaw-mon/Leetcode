package Year2020.September.day01;
//测试多线程模块

/**
 * 1114. 按序打印
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 作者：LeetCode
 *         链接：https://leetcode-cn.com/problems/print-in-order/solution/an-xu-da-yin-by-leetcode/
 *         来源：力扣（LeetCode）
 *         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Demo01 {

    public static void main(String[] args){
        int[] order = {3,2,1};
        Foo foo = new Foo();
        for (int num : order) {
            if (num == 1) {
                new Thread(() -> {
                    try {
                        foo.first(new PrintFuction("first"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (num == 2) {
                new Thread(() -> {
                    try {
                        foo.second(new PrintFuction("second"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else {
                new Thread(() -> {
                    try {
                        foo.third(new PrintFuction("third"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }


}
class PrintFuction implements Runnable {
    String outPutStr;

    PrintFuction(String str) {
        outPutStr = str;
    }

    @Override
    public void run() {
        System.out.println(outPutStr);
    }
}


class Foo {

    //1.添加两个原子信号量
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }
}




