package Year2020.September.day11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Demo02 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
     * TODO 优化策略使用两个栈，其中一个是辅助栈
     */
    class myStack {
        List<Integer> list = new LinkedList<>();
        int size = 0;
        //O(1)获取最小元素,可以使用小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        public void push(int node) {
            list.add(node);
            queue.add(node);
            size++;
        }

        public void pop() {
            if (size > 1) {
                queue.remove(list.get(size - 1));
                list.remove(--size);
            }
        }

        public int top() {
            if (size < 1) return 0;
            return list.get(size - 1);
        }

        public int min() {
            return queue.peek();
        }
    }

}
