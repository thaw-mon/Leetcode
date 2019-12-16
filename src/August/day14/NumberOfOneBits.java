package August.day14;

/**
 * @题目 ：191. Number of 1 Bits
 * @Data 19/8/29
 * @题目描述： Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * @题目地址： 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * @示例1: ######
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * @示例2: ###
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * @示例3: ###
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 */

public class NumberOfOneBits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i <= 31; i++) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

//        作者：LeetCode
//    链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //优化小技巧 : n & n-1 能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }


}
