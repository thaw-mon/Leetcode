package Year2020.October.day06;

public class Demo03 {

    /**
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
     * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if(target <=0) return 0;
        int[] dp = new int[target + 1]; //dp[i]表示i的最大乘积
        //dp[0] =0 dp[1] =1
        for (int i = 2; i <= target; i++) {
            //dp[i] = i;
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[target];
    }

    public static void main(String[] args){
        System.out.println(new Demo03().cutRope(0));
    }

}
