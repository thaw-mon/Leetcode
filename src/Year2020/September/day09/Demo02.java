package Year2020.September.day09;

public class Demo02 {

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        //f(n) = f(n-1) + f(n-2)
        if (target == 1) return 1;
        if (target == 2) return 2;

        return RectCover(target - 1) + RectCover(target - 2);
    }

    public int RectCover2(int target) {
        if(target ==0 ) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        //f(n) = f(n-1) + f(n-2)
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];
    }

    public static void main(String[] arggs) {
        System.out.println(new Demo02().RectCover(5));
    }
}
