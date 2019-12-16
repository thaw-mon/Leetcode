package October.day09;

/**
 * @题目 ： 322. Coin Change
 * @Data 19/10/17
 * @题目描述： Given an integer, write a function to determine if it is a power of three.
 * @示例1: ######
 * Input: 27
 * Output: true
 * @示例2: ######
 * Input: 0
 * Output: false
 * Input: 45
 * Output: false
 * @示例3: ###
 */

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //比较有趣的思路
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //获取Int类型最大为3^19
    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


}
