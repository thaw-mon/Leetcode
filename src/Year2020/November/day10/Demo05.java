package Year2020.November.day10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Demo05 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo05 demo05 = new Demo05();
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(demo05.getTwentyFour(s));
        }
        scanner.close();
    }

    /**
     * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24
     * 类型： 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     */
    public String getTwentyFour(String s) {
        if (s.contains("joker") || s.contains("JOKER")) {
            return "ERROR";
        }
        String[] arr = s.split("\\s");
        int[] value = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            value[i] = getValue(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        Deque<String> queue = new ArrayDeque<>();
        if (isFitAnswer(value, new boolean[arr.length], 0, queue)) {
            for (String s1 : queue) {
                sb.append(s1);
            }
        } else {
            sb.append("NONE");
        }

        return sb.toString();
    }

    public boolean isFitAnswer(int[] value, boolean[] visited, int currentVal, Deque<String> queue) {
        //循环终止条件
        if (queue.size() == 7) {
            return currentVal == 24;
        }
        for (int i = 0; i < value.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            //选择value[i]分别进行运算
            if (queue.isEmpty()) {
                queue.addLast(getString(value[i]));
                if (isFitAnswer(value, visited, value[i], queue)) {
                    return true;
                }
                queue.pollLast();
            } else {
                //分别进行加减乘除
                queue.addLast("+");
                queue.addLast(getString(value[i]));
                if (isFitAnswer(value, visited, currentVal + value[i], queue)) {
                    return true;
                }
                queue.pollLast();
                queue.pollLast();
                queue.addLast("-");
                queue.addLast(getString(value[i]));
                if (isFitAnswer(value, visited, currentVal - value[i], queue)) {
                    return true;
                }
                queue.pollLast();
                queue.pollLast();
                queue.addLast("*");
                queue.addLast(getString(value[i]));
                if (isFitAnswer(value, visited, currentVal * value[i], queue)) {
                    return true;
                }
                queue.pollLast();
                queue.pollLast();
                if (currentVal % value[i] == 0) {
                    queue.addLast("/");
                    queue.addLast(getString(value[i]));
                    if (isFitAnswer(value, visited, currentVal / value[i], queue)) {
                        return true;
                    }
                    queue.pollLast();
                    queue.pollLast();
                }

            }
            visited[i] = false;
        }
        return false;
    }

    private String getString(int k) {
        if (k >= 2 && k <= 9) return (String.valueOf(k));
        else if (k == 11) return "J";
        else if (k == 12) return "Q";
        else if (k == 13) return "K";
        else if (k == 1) return "A";
        return "";
    }

    private int getValue(String s) {
        int value1 = 0;
        if (s.equals("J")) value1 = 11;
        else if (s.equals("Q")) value1 = 12;
        else if (s.equals("K")) value1 = 13;
        else if (s.equals("A")) value1 = 1;
        else value1 = Integer.parseInt(s);
        return value1;
    }

    private int getValue(char c1) {
        int value1 = 0;
        if (c1 >= '2' && c1 <= '9') value1 = c1 - '0';
        else if (c1 == '1') value1 = 10;
        else if (c1 == 'J') value1 = 11;
        else if (c1 == 'Q') value1 = 12;
        else if (c1 == 'K') value1 = 13;
        else if (c1 == 'A') value1 = 1;
        return value1;
    }
}
