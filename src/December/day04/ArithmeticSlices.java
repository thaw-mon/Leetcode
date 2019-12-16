package December.day04;

/**
 * @题目 ：413. Arithmetic Slices
 * @Data 19/12/09
 * @题目描述： WA sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * @题目链接： 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * @示例1: ######
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * @示例2: ######
 * @示例3: ###
 */

public class ArithmeticSlices {
    //获取等差数列的数量
    //dp[i][j]表示i到j是等差数列
    //优化为一维数组
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int[] dps = new int[n];
        int res = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; j + i < n; i++) {
                if (j == 1) {
                    dps[i] = 1;
                    continue;
                }
                if (dps[i] > 0 && A[i + j] + A[i + j - 2] == 2 * A[i + j - 1]){
                    dps[i] = 1;
                    res++;
                }else {
                    dps[i] = 0;
                }
            }
        }
        return res;
    }


    //再优化：一次遍历
//      作者：LeetCode
//    链接：https://leetcode-cn.com/problems/arithmetic-slices/solution/deng-chai-shu-lie-hua-fen-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int numberOfArithmeticSlices2(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }



}
