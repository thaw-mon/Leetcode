package Year2020.April.day11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Demo04 {
    //功能 : 使用两个栈实习队列
    static class MyQueue {
        public Stack<Integer> stack1;
        public Stack<Integer> stack2;

        MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        //1.add操作 :向队尾添加数字
        public void add(int x) {
            stack1.add(x);
        }

        //2.poll操作 :弹出头部数据
        public int poll() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }

        //2.peek操作 :查询头部数据
        public int peek() {
            if (!stack2.isEmpty()) {
                return stack2.peek();
            }
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            return stack2.peek();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //表示操作数
        Map<String, Integer> operator = new HashMap<>();
        operator.put("add", 1);
        operator.put("poll", 2);
        operator.put("peek", 3);
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < N; i++) {
            String op = in.next();
            switch (operator.get(op)) {
                case 1:
                    myQueue.add(in.nextInt());
                    break;
                case 2:
                    myQueue.poll();
                    break;
                case 3:
                    System.out.println(myQueue.peek());
                    break;
                default:
                    break;
            }
        }
    }
}
