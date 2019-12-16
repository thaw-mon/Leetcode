package July.day02;

/**
 * @题目 ：70. 爬楼梯
 * @题目描述： 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @Date:19/7/2
 * @示例 1: 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * @示例 2: 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 **/
public class ClimbingStairs {

    //动态规划
    //本质上就是求斐波那契数
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] statirs = {1, 2};
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = statirs[0] + statirs[1];
            statirs[0] = statirs[1];
            statirs[1] = tmp;
        }
        return statirs[1];
    }

    //公式法
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/pa-lou-ti-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int climbStairs2(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

}
