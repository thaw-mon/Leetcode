package June.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @题目 ：56. 合并区间
 * @题目描述： 给出一个区间的集合，请合并所有重叠的区间。
 * @Date:19/6/29
 * @示例 1: 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @示例 2: 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 **/
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] nums = {{3,2},{2,4}};
        System.out.println(new MergeIntervals().merge(nums));
    }

    //1 . 先排序，再判断
    public int[][] merge(int[][] intervals) {
        //sort写法有误，需要添加 Compare
        Arrays.sort(intervals);
        int[][] ans;
        int i = 0, n = intervals.length;
        while (i < n) {
            int j = i+1;
            //第i个和第j个比较
            if(intervals[i][1]<=intervals[j][0]){

            }
            i++;
        }
        return null;
    }

    //大佬思路：
    public int[][] merge2(int[][] intervals) {
        if(intervals == null || intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        int len = intervals.length;
        for(int i = 0 ; i < len  ; i ++) {
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];
            while(i < len - 1 &&temp[1] >= intervals[i + 1][0]) {//寻找本区间的可合并区间，有的话就合并
                temp[1] = Math.max(temp[1],intervals[i + 1][1]);
                i++;//标记到下一个待确认区间
            }
            res.add(temp);
        }
        int[][] arr = new int[res.size()][2];
        res.toArray(arr);
        return arr;
    }
}
