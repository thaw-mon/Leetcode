package Year2020.March.day12;

import java.util.HashMap;
import java.util.Map;

public class Demo03 {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
     * 你需要让组成和的完全平方数的个数最少。
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        //dp方法 : 结果超时了
        //优化方程 ：dp[i] = MIN(dp[i], dp[i - j * j] + 1)
        int[] dp = new int[n + 1];
        //把自身为平方数赋值为1
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            //判定自身是否为平方数
            if (dp[i] == 1) continue;
            dp[i] = i; //初始为最大值
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
            }
        }
        return dp[n];
    }

    Map<Integer, Integer> record = new HashMap<>();

    public int numSquares2(int n) {
        //使用DFS方法
        //0. 判定n是否计算过了
        if (record.containsKey(n)) {
            return record.get(n);
        }
        int ret = 1;
        //1.获取离n最近的平方数
        int num = (int) Math.sqrt(n);
        record.put(num * num, 1);
        //n本身为平方数
        if (num * num == n) {
            return ret;
        }
        ret = Integer.MAX_VALUE;
        for (int i = num; i > 0; i--) {
            int tmp = numSquares2(n - i * i);
            ret = Math.min(tmp + 1, ret);
        }
        record.put(n, ret);
        return ret;
    }

    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        int n = 12;
        System.out.println(demo03.numSquares2(n));
    }
}
