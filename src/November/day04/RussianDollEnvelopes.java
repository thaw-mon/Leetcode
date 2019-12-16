package November.day04;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @题目 ： 354. Russian Doll Envelopes
 * @Data 19/11/12
 * @题目描述： You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * @题目链接： 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * @示例1: ######
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * @示例2: ######
 * @示例3: ###
 */

public class RussianDollEnvelopes {

    public static void main(String[] aegs) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(envelopes));
    }

    class Node implements Comparable<Node> {
        public int width;
        public int height;

        public Node(int[] array) {
            width = array[0];
            height = array[1];
        }

        @Override
        public int compareTo(Node n) {
            if (this.width == n.width) {
                return this.height > n.height ? 1 : -1;
            }
            return this.width > n.width ? 1 : -1;
        }

        public boolean canPack(Node n) {
            return this.width > n.width && this.height > n.height;
        }
    }

    //动态规划思路:勉强通过
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;
        //对信封数组排序
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(envelopes[i]);
        }
        Arrays.sort(nodes);
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (nodes[i].canPack(nodes[j])) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            max = Math.max(dp[i], max);
        }
        return max + 1;
    }

//     作者：labuladong
//    链接：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/zui-chang-di-zeng-zi-xu-lie-kuo-zhan-dao-er-wei-er/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //大佬思路：转换为标准的LTS(最长递增子序列问题)
    //把width递增排序，width相同时，height则递减排序
    //选择height作为标准的LTS的输入
    public int maxEnvelopes2(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];

        return lengthOfLIS(height);
    }

    /* 返回 nums 中 LIS 的长度 */
    public int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            int left = 0, right = piles;
            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }


}
