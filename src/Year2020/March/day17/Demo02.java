package Year2020.March.day17;

public class Demo02 {

    /**
     * 有两种形状的瓷砖：一种是 2x1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
     * 给定 N 的值，有多少种方法可以平铺 2 x N 的面板？返回值 mod 10^9 + 7。
     *
     * @param N
     * @return
     */
    // 作者：ccnuacmhdu
    //        链接：https://leetcode-cn.com/problems/domino-and-tromino-tiling/solution/zhao-gui-lu-by-ccnuacmhdu/
    //        来源：力扣（LeetCode）
    //        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int numTilings(int N) {
        int mod = 1000000007;
        //dp[n]=dp[n-1]*2+dp[n-3]
        int[] dp = new int[N + 3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= N; i++) {
            dp[i] = (2 * (dp[i - 1] % mod) % mod + dp[i - 3] % mod) % mod;
        }
        return dp[N] % mod;
    }
}
