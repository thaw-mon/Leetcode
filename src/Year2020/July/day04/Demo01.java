package Year2020.July.day04;

import java.util.Scanner;
import java.util.Stack;

public class Demo01 {
    //TODO 超时了，待优化
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        //相邻差值绝对值大于1
        boolean[] visited = new boolean[N];
        //1.暴力递归法
        int[] answer = new int[N];
        Demo01 demo01 = new Demo01();
        demo01.dp(0, visited, answer);

    }

    private void dp(int level, boolean[] visited, int[] answer) {
        if (level == visited.length) {
            //打印结果
            for (int i = 0; i < answer.length; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println(); //换行操作

        }
        for (int i = 1; i <= visited.length; i++) {
            if (!visited[i - 1] && (level == 0 || Math.abs(answer[level - 1] - i) > 1)) {
                answer[level] = i;
                visited[i - 1] = true;
                dp(level + 1, visited, answer);
                visited[i - 1] = false;
            }
        }
    }
}
