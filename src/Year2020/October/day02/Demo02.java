package Year2020.October.day02;

import java.util.LinkedList;
import java.util.Queue;

public class Demo02 {

    /**
     * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
     * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
     * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     * 如果没有小朋友，请返回-1
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) return -1;
        //1.暴力法使用一个链表进行模拟报数
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.add(i);
        while (queue.size() > 1) {
            //模拟报数一轮
            int k = (m - 1) % queue.size(); //使用m-1是因为第m个数字需要poll
            for (int i = 0; i < k; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            queue.poll();
        }
        return queue.poll();
    }

    //使用递归策略进行
    //  x = f(n - 1, m) ==> f(n, m) = (m % n + x) % n = (m + x) % n
    public int LastRemaining_Solution2(int n, int m) {
        if (n == 1) return 0;
        int x = LastRemaining_Solution2(n - 1, m);
        return (x + m) % n;
    }

    //使用迭代法
    //f[n] = (f[n-1] + m) % n
    public int LastRemaining_Solution3(int n, int m) {
        if (n <= 0) return -1;
        int index = 0;
        for (int i = 2; i <= n; ++i) {
            index = (index + m) % i;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Demo02().LastRemaining_Solution(5, 3));

    }
}
