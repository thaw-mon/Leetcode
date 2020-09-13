package Year2020.January.day04;

/**
 * @题目 ：470. Implement Rand10() Using Rand7()
 * @Data 20/01/11
 * @题目描述： Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.
 * <p>
 * Do NOT use system's Math.random().
 * @题目链接： 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * @示例1: ######
 * Input: 1
 * Output: [7]
 * @示例2: ######
 * Input: 2
 * Output: [8,4]
 * @示例3: ###
 * Input: 3
 * Output: [8,1,10]
 */

public class implementRand10 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    public int rand7() {
        return (int) (1 + Math.random()) * (10 - 1 + 1);
    }

    //使用random7获取random10
    //1 2 3 4 5 6 7 ==> 1--10 显然需要多轮数字进行映射
    //方法一：拒绝采样
    public int rand10() {
        int a = rand7();
        int b = rand7();
        if (a > 4 && b < 4) return rand10();
        else return (a + b) % 10 + 1;
    }
}
