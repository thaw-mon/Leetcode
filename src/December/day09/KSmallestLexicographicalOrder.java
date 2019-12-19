package December.day09;

/**
 * @题目 ：440. K-th Smallest in Lexicographical Order
 * @Data 19/12/19
 * @题目描述： Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 * <p>
 * Note: 1 ≤ k ≤ n ≤ 109.
 * @题目链接： 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * @示例1: ######
 * Input:
 * n: 13   k: 2
 * <p>
 * Output:
 * 10
 * <p>
 * Explanation:
 * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 * @示例2: ######
 * @示例3: ###
 */

public class KSmallestLexicographicalOrder {
    public static void main(String[] args) {
        int n = 13, k = 2;
        System.out.println(new KSmallestLexicographicalOrder().findKthNumber(n, k));
    }

    //没想出来，参考了大佬的解法
    //获取1-n的第k个字典序数字：要把题目考虑位十叉链表的先序排列
    public int findKthNumber(int n, int k) {
        long prefix = 1;
        long p = 1;
        while (p < k) {
            //1. 获取以prefix为前缀的数字个数
            long num = getCount(prefix, n);
            if (p + num > k) {
                prefix *= 10;
                p++;
            } else if (p + num <= k) {
                prefix++;
                p += num;
            }
        }
        return (int)prefix;
    }

    private long getCount(long prefix, int n) {
        long cur = prefix;
        long next = cur + 1;
        long count = 0;
        while (cur <= n) {
            count += Math.min(next, n + 1) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
