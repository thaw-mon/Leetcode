package August.day11;

/**
 * @题目 ：172. Factorial Trailing Zeroes
 * @Data: 19/8/18
 * @题目描述： Given an integer n, return the number of trailing zeroes in n!.
 * @题目地址： 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * Note: Your solution should be in logarithmic time complexity.
 * @示例1: ######
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * @示例2: ###
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * @示例3: ###
 **/

public class FactorialTrailingZeroes {

    public static void main(String[] args){
        int n = 100;
        int res = 1;
        for(int i=1;i<=n;i++){
            res *= i;
            System.out.println( i + "的阶乘" + res);
        }
    }

    //返回n!中尾数中0包含的个数，显然不能暴力法。
    //应该和2 和 5 的数量有关 由于2 远大于5 因此和5的数量有关
    // 5! = 1个0  6 --1   7 --2
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0){
            n = n / 5;
            res +=n;
        }
        return res;
    }
}
