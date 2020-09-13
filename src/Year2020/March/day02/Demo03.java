package Year2020.March.day02;

public class Demo03 {

    public static void main(String[] args){
        System.out.println(new Demo03().integerBreak(10));
    }
    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * @param n : 给定一个正整数
     * @return 可以获得的最大乘积
     */
    public int integerBreak(int n) {

        //动态规划
        int[] dp = new int[n];
        dp[0] = 1;
        //从2开始
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int tmp = Math.max(dp[j],j+1);
                dp[i] = Math.max(tmp * (i-j),dp[i]);
            }
        }
        return dp[n-1];
    }
}
