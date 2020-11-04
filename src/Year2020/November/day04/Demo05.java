package Year2020.November.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Demo05 {

    //15929 ==> 2952 + 244 + 18 + 1 + 4 * 244 +
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Year2020/November/day04/exp05_01"));
        //Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int myAnswer = selectSeven(N);
            int right = travelAll(N);
            if (myAnswer != right) {
                System.out.println("N = " + N + "," + myAnswer + ":" + right);
            }
            // System.out.println(selectSeven(N));
        }
    }

    /**
     * 输出7有关数字的个数，包括7的倍数，还有包含7的数字
     * （如17，27，37...70，71，72，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
     */
    public static int selectSeven(int N) {
        int count = 0;

        //1.选择包含数字7的数字
        //1-1 判断N的位数
        int bit = 0;
        int num = N;
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            bit++;
            stack.push(num % 10);
            num /= 10;
        }
        int[] dp = new int[bit + 1];
        dp[0] = 0;
        //  dp[1] = 1;//个位数只有1个
        int base = 1;
        for (int i = 1; i <= bit; i++) {
            // count += dp[i - 1]; //注意不要添加最高位的
            dp[i] = 9 * dp[i - 1] + base;
            base *= 10;
        }
        //    count += dp[bit - 1]; //添加
        for (int i = bit - 1; i >= 0; i--) {
            int val = stack.pop(); //获取最高位的数字
            count += val * dp[i];
            if (val == 7) {
                //获取后序全部数字
                if (!stack.isEmpty()) {
                    int temp = stack.pop();
                    while (!stack.isEmpty()) {
                        temp *= 10;
                        temp += stack.pop();
                    }
                    count += temp;
                }
                count++;
                break;
            } else if (val > 7) {
                count -= dp[i];
                //eg 8234
                count += (int) Math.pow(10, i);
            }
        }
        //2.选择7的倍数，且不包含数字7
        int current = 7;
        while (current <= N) {
            if (!isContainSeven(current)) {
                count++;
            }
            current += 7;
        }
        return count;
    }

    private static boolean isContainSeven(int num) {
        while (num > 0) {
            if (num % 10 == 7) return true;
            num /= 10;
        }
        return false;
    }

    public static int travelAll(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 7 == 0 || isContainSeven(i)) count++;
        }
        return count;
    }
}
