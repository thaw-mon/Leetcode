package December.day08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @题目 ：435. Non-overlapping Intervals
 * @Data 19/12/18
 * @题目描述： Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * @题目链接： 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * @示例1: ######
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * @示例2: ######
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * @示例3: ###
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */

public class NonOverlappingIntervals {

    //移除部分区间，使得剩余的区间不在重叠：注意[1,2] [2,5]这两个区间不重叠  [1,3][2,4]这两个区间就重叠了
    //1.重叠定义 ：
    // 部分重叠 [1,3] [2,4] ==>  c1[0] < c2[0] < c1[1] && c2[1] > c1[1]
    // 完全重叠 [1,3] [1,4] ==>  c2[0] <= c1[0] && c2[1] >= c1[1]
    //2.如何选择要删除的区间
    //2-1 要对全部区间进行排序小的在前面大的在后面（排序规则:先排序第一位，再排序第二位）
    //2-2 要删除重叠区间中的c2
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length < 2) return 0;
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
        queue.addAll(Arrays.asList(intervals));
        //部分重叠，删除后者，全部重叠，删除后者（内部较小的那个）
        int start = 0,end = 0;
        int[] temp = queue.poll();
        start = temp[0]; end = temp[1];  //最后发现start不需要使用，因为排序后start时非降序的
        int res = 0;
        while (!queue.isEmpty()){
            temp = queue.poll();
            //判断是否重叠
            //1.全部重叠
            if(temp[1] <= end){
                end = temp[1];
                res++;
            }else if(temp[0] < end){ //部分重叠:直接删除
                res++;
            }else { //不重叠
                end = temp[1];
            }
        }
        return res;
    }
}
