package Year2020.November.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Demo06 {

    public static void main(String[] args) {
        //用例没有（A op B）op (C op D)的情形
        // System.out.println(1.0 * 19 * 9 / 7);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = new int[4];
            for (int i = 0; i < 4; i++) {
                nums[i] = scanner.nextInt();
            }
            Stack<String> stack = new Stack<>();
            System.out.println(twentyFour(nums, new boolean[4], 0, 0,stack));
          //    System.out.println(stack);
            // System.out.println(OP);
        }

        scanner.close();
    }

    /**
     * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
     */
    public static boolean twentyFour(int[] nums, boolean[] visited, int current, int level, Stack<String> stack) {
        if (level == 4) {
            return current == 24;
        }
        boolean flag = false;
        if (level == 0) {
            for (int i = 0; i < 4; i++) {
                visited[i] = true;
                stack.push(String.valueOf(nums[i]));
                flag = twentyFour(nums, visited, current + nums[i], level + 1,stack);
                if (flag) break;
                visited[i] = false;
            }
            return flag;
        }
        for (int i = 0; i < 4; i++) {

            if (visited[i]) continue;
            visited[i] = true;
            stack.push("+");
            stack.push(String.valueOf(nums[i]));
            flag = twentyFour(nums, visited, current + nums[i], level + 1,stack);
            if (flag) break;
            stack.pop();
            stack.pop();

            stack.push("-");
            stack.push(String.valueOf(nums[i]));
            flag = twentyFour(nums, visited, current - nums[i], level + 1,stack);
            if (flag) break;
            stack.pop();
            stack.pop();

            stack.push("*");
            stack.push(String.valueOf(nums[i]));
            flag = twentyFour(nums, visited, current * nums[i], level + 1,stack);
            if (flag) break;
            stack.pop();
            stack.pop();
            if (current % nums[i] == 0) {
                stack.push("/");
                stack.push(String.valueOf(nums[i]));
                flag = twentyFour(nums, visited, current / nums[i], level + 1,stack);
                if (flag) break;
                stack.pop();
                stack.pop();
            }
            visited[i] = false;
        }
        return flag;
    }
}
