package December.day01;

/**
 * @题目 ： 397. Integer Replacement
 * @Data 19/12/02
 * @题目描述： Given a positive integer n and you can do operations as follow:
 * <p>
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 * @题目链接： 链接：https://leetcode-cn.com/problems/integer-replacement
 * @示例1: ######
 * Input:
 * 8
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * @示例2: ######
 * Input:
 * 7
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 * @示例3: ###
 */

public class IntegerReplacement {

    //由n转换1的最小次数
    //1.递归思路（栈溢出）
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return integerReplacement(n / 2) + 1;

        return Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
    }

    //动态规划(超出内存限制)
    public int integerReplacement2(int n) {
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0)
                dp[i] = dp[i / 2] + 1;
            else
                dp[i] = Math.max(dp[i - 1] + 1, dp[(i + 1) / 2] + 2);
        }

        return dp[n - 1];
    }

    //     作者：noobhan
//    链接：https://leetcode-cn.com/problems/integer-replacement/solution/java-0ms-100-shuang-o1-wei-yun-suan-by-noobhan/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int integerReplacement3(int n) {
        int count = 0;
        while (n != 1) {
            //与运算判断最后一位来区分奇偶
            if ((n & 1) == 0) {
                //偶数直接无符号右移，
                //2147483647 会被奇数处理算法加一溢出为负数，
                //若选用带符号右移将无法回到1.
                n >>>= 1;
                count++;
            } else {
                //识别奇数的上一位是否为1，即 以 01 结尾(xxxx01)还是以11结尾(xxxx11)
                if ((n & 2) == 0) {
                    //01结尾最优则应当 用 n -1 取代 n
                    n -= 1;
                    count++;
                } else {
                    //11结尾除3这个特殊情况外，其余选用 n + 1取代 n，原因如上
                    if (n == 3) {
                        //3的特殊性处理，原因如上
                        count += 2;
                        break;
                    } else {
                        n += 1;
                    }
                    count++;
                }
            }
        }
        return count;
    }


}
