package September.day08;

import java.util.Stack;

/**
 * @题目 ： 232. Implement Queue using Stacks
 * @Data 19/9/15
 * @题目描述： Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * @题目地址： 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * @示例1: ######
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * @示例2: ###
 * @示例3: ###
 */

public class ImplementQueueByStacks {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();
        queue.pop();
        queue.empty();
    }

    public static class MyQueue {

        private Stack<Integer> stack;
        private Stack<Integer> tmp;
        private Integer head;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
            tmp = new Stack<>();
            head = null;
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (stack.isEmpty()) head = x;
            stack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            int n = stack.size();
            for (int i = 0; i < n; i++)
                tmp.push(stack.pop());
            int res = tmp.pop();
            head = tmp.isEmpty() ? null : tmp.peek();
            for (int i = 0; i < n - 1; i++)
                stack.push(tmp.pop());

            return res;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return head;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return head == null;
        }
    }
}
