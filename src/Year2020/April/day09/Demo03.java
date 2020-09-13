package Year2020.April.day09;

public class Demo03 {

    /**
     * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
     * 注意：1 ≤ k ≤ n ≤ 10^9。
     *
     * @param n
     * @param k
     * @return
     */
    // 作者：jason-2
    //        链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/wu-xu-jie-zhu-shi-cha-shu-ye-neng-rong-yi-li-jie-b/
    //        来源：力扣（LeetCode）
    //        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        int p = 1;
        while (p < k) {
            int cnt = getCount(prefix, n);
            if (p + cnt > k) {
                prefix *= 10;
                p++;
            } else if (p + cnt <= k) {
                prefix++;
                p += cnt;
            }
        }
        return prefix;
    }

    /**
     * 获取以prefix位前缀小于等于n的数字数目
     *
     * @param prefix ： 前缀
     * @param n      ： 最大值
     * @return
     */
    private int getCount(int prefix, int n) {
        int cnt = 0;
        for (int a = prefix, b = prefix + 1; a <= n; a *= 10, b *= 10) {
            cnt += Math.min(n + 1, b) - a;
        }
        return cnt;
    }
}
