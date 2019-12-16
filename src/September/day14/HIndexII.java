package September.day14;

/**
 * @题目 ： 275. H-Index II
 * @Data 19/9/25
 * @题目描述： Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * @题目地址： 链接：https://leetcode-cn.com/problems/h-index-ii
 * @示例1: ######
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * @示例2: ###
 * @示例3: ###
 */
public class HIndexII {

    //和前一题相比更简单了，因为citations保证升序
    public int hIndex(int[] citations) {
        int n = citations.length;
        int h = 0;
        for (; h < n; h++) {
            if (citations[n - 1 - h] <= h)
                break;
        }
        return h;
    }
}
