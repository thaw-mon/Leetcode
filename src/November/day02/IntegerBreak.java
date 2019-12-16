package November.day02;

/**
 * @题目 ： 343. Integer Break
 * @Data 19/11/09
 * @题目描述： Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/integer-break
 * @示例1: ######
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * @示例2: ######
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * @示例3: ###
 */
public class IntegerBreak {

    //这是一道找规律题目:
    // 2: 1+1 1*1 = 1
    // 3: 1+2 1*2 = 2
    // 4: 2+2 2*2 = 4
    // 5: 2+3 2*3 = 6
    // 6: 3+3 3*3 = 9
    // 7: 3+4       12
    // 8: 3+3+2     18
    // 10: 3+3+4    36
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        int k = n / 3;
        int c = n % 3;
        if(c == 1){
            k--;
            c += 3;
        }
        if(c==0) c++;
        return (int)Math.pow(3,k) * c;
    }
}
