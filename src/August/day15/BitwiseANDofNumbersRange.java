package August.day15;

/**
 * @题目 ：201. Bitwise AND of Numbers Range
 * @Data 19/8/30
 * @题目描述： Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * @题目地址： 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * @示例1: ######
 * Input: [5,7]
 * Output: 4
 * @示例2: ###
 * Input: [0,1]
 * Output: 0
 * @示例3: ###
 */

public class BitwiseANDofNumbersRange {

    public static void main(String[] args) {
        int m = 7;
        int n = 9;
        System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd2(m, n));
    }

    // 超时了
    public int rangeBitwiseAnd(int m, int n) {
        int res = 1;
        for (int i = m; i <= n; i++) {
            res = res & i;
            if (res == 0)
                break;
        }
        return res;
    }

    //    作者：da-li-wang
//        链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/c-wei-yun-suan-4msti-jie-by-da-li-wang/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int rangeBitwiseAnd2(int m, int n) {
        int res = 0;
        int k = 1 << 30; // 非负整数的最大二次幂
        while (k > 0 && (m & k) == (n & k)) {
            res |= k & m;
            k >>= 1;
        }
        return res;


    }

    //    作者：powcai
//    链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/0he-shui-yu-du-shi-0-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//    此题其实就是寻找[m,n]范围内二进制数高位（左边）没有变化的数，后面补上0即为所求的结果。
    public int rangeBitwiseAnd3(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i += 1;
        }
        return m << i;
    }
}
