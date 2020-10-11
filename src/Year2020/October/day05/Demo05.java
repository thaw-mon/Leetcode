package Year2020.October.day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo05 {

    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 窗口大于数组长度的时候，返回空
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        int n = num.length;
        if (size > n || size <= 0) return null;
        ArrayList<Integer> ret = new ArrayList<>();
        //使用优先队列维护窗口
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //第一个窗口
        for (int i = 0; i < size - 1; i++) {
            priorityQueue.add(num[i]);
        }
        int pollIndex = 0;
        for (int i = size - 1; i < n; i++) {
            priorityQueue.add(num[i]);
            ret.add(priorityQueue.peek());
            priorityQueue.remove((Object) num[pollIndex++]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int size = 0;
        System.out.println(new Demo05().maxInWindows(nums, size));
    }
}
