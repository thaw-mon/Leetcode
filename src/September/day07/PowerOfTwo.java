package September.day07;

/**
 * @题目 ： 231. Power of Two
 * @Data 19/9/11
 * @题目描述： Given an integer, write a function to determine if it is a power of two.
 * @题目地址： 链接：https://leetcode-cn.com/problems/power-of-two/
 * @示例1: ######
 * Input: 1
 * Output: true
 * Explanation: 2^0 = 1
 * @示例2: ###
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 * @示例3: ###
 * Input: 218
 * Output: false
 */

public class PowerOfTwo {
    public static void main(String[] args) {
        for (int i = 0; i < 32; i++)
            System.out.println(1 << i);
        System.out.println(Integer.MAX_VALUE);
        int n = 2147483647;
        System.out.println(new PowerOfTwo().isPowerOfTwo(n));
    }

    //int 最大值为32次方-1
    public boolean isPowerOfTwo(int n) {
        int ans = 1;
        int i = 0;
        while (i < 32 && ans <= n) {
            if (ans == n)
                return true;
            ans <<= 1;
            i++;
        }
        return false;
    }



//     作者：jyd
//    链接：https://leetcode-cn.com/problems/power-of-two/solution/power-of-two-er-jin-zhi-ji-jian-by-jyd/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//大佬思路
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


}
