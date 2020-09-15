package Year2020.September.day08;

public class Demo04 {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 第一眼就是动态规划
     *
     * @param target
     * @return
     */
    //TODO 优化策略，dp数组实际上只需要3个变量就ok
    public int JumpFloor(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1; //初始化操作
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
