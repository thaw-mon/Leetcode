package Year2020.September.day01;

import java.util.concurrent.Semaphore;

public class Demo02 {
}
class FooBar {
    private int n;
    //1.使用同步锁加计数
    private int fooCount = 0;
    private int barCount = 0;
    private Object lock = new Object();
    //2. 使用信号量
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock){
                // printFoo.run() outputs "foo". Do not change or remove this line.
                //添加判定条件
                while(barCount < fooCount){
                    lock.wait();
                }
                printFoo.run();
                fooCount++;
                lock.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock){
                // printFoo.run() outputs "foo". Do not change or remove this line.
                //添加判定条件
                while(barCount >= fooCount){
                    lock.wait();
                }
                printBar.run();
                barCount++;
                lock.notifyAll();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        }
    }

//     作者：KevinBauer
//    链接：https://leetcode-cn.com/problems/print-foobar-alternately/solution/java-bing-fa-gong-ju-lei-da-lian-bing-by-kevinbaue/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public void foo2(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar2(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }


}
