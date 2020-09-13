package Year2019.September.day14;

import java.util.Arrays;

/**
 * @题目 ： 274. H-Index
 * @Data 19/9/25
 * @题目描述： Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * @题目地址： 链接：https://leetcode-cn.com/problems/h-index
 * @示例1: ######
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 * received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * @示例2: ###
 * @示例3: ###
 */

public class HIndex {

    //hIndex : 至多有h篇论文被引用至少h次
    //思路1:排序后计算
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;

    }

//     作者：LeetCode
//    链接：https://leetcode-cn.com/problems/h-index/solution/hzhi-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //O(N)算法--Hash桶策略
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // 计数
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // 找出最大的 k
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }


}
