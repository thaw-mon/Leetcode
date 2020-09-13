package Year2019.November.day07;

import java.util.*;

/**
 * @题目 ： 373. Find K Pairs with Smallest Sums
 * @Data 19/11/18
 * @题目描述： You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * @题目链接： 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * @示例1: ######
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * @示例2: ######
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * @示例3: ###
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */

public class FindKPairsSmallestSums {

    private int getSum(List<Integer> data) {
        int res = 0;
        for (int num : data) {
            res += num;
        }
        return res;
    }

    //找前k个和为最小的元素
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //1.使用大根堆逆序策略
        Queue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return getSum(o2) - getSum(o1);
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums1[i]);
                tmp.add(nums2[j]);
                if (maxHeap.size() < k)
                    maxHeap.add(tmp);
                else if (getSum(tmp) < getSum(maxHeap.peek())) {
                    maxHeap.poll();
                    maxHeap.add(tmp);
                }
                else
                    //跳出内层循环
                    break;
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        while(!maxHeap.isEmpty()){
            res.add(maxHeap.poll());
        }
        return res;
    }
}
