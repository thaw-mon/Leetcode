package September.day06;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * @题目 ： 225. Implement Stack using Queues
 * @Data 19/9/09
 * @题目描述： Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * @题目地址： 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * @示例1: ######
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * @示例2: ###
 * @示例3: ###
 */

public class ImplementStackByQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.pop();
        stack.pop();
    }


    static class MyStack {

        private Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        //TODO 这个pop有问题，当存在元素和栈顶元素重复，就会出现问题
        //解决办法:使用两个队列或者类似循环队列的方法
        public int pop() {
            int res = top();
            queue.remove(top());
            return res;
        }

        /**
         * Get the top element.
         */
        public int top() {
            int res = 0;
            for (Integer integer : queue) {
                res = integer;
            }
            return res;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
