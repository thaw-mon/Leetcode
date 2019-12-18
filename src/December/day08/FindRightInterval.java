package December.day08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @题目 ：436. Find Right Interval
 * @Data 19/12/18
 * @题目描述： GGiven a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 * <p>
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.
 * <p>
 * Note:
 * <p>
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 * @题目链接： 链接：https://leetcode-cn.com/problems/find-right-interval
 * @示例1: ######
 * Input: [ [1,2] ]
 * <p>
 * Output: [-1]
 * <p>
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * @示例2: ######
 * Input: [ [3,4], [2,3], [1,2] ]
 * <p>
 * Output: [-1, 0, 1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * @示例3: ###
 * Input: [ [1,4], [2,3], [3,4] ]
 * <p>
 * Output: [-1, 2, -1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 */

public class FindRightInterval {

    //寻找每个区间的右区间的最小起点:不能直接排序，否则顺序就打乱了

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length; //记录区间的数目
        int[] res = new int[n];
        int[][] sortIntervals = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++)
                sortIntervals[i][j] = intervals[i][j];
            sortIntervals[i][2] = i; //记录原来区间的位置信息
        }
        Arrays.sort(sortIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            int end = sortIntervals[i][1];
            //二分查找end再后续节点的位置
            int l = i + 1, r = n - 1, mid;
            while (l <= r) {
                mid = (l + r) / 2;
                if (sortIntervals[mid][0] >= end) {
                    r = mid - 1;
                } else
                    l = mid + 1;
            }
            //结果为l
            res[sortIntervals[i][2]] = l < n ? sortIntervals[l][2] : -1;
        }
        return res;
    }

    //使用树图的解法
//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/find-right-interval/solution/er-fen-cha-zhao-hong-hei-shu-by-liweiwei1419/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] findRightInterval2(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0];
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            treeMap.put(intervals[i][0], i);
        }
        for (int i = 0; i < len; i++) {
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i][1]);
            if (entry == null) {
                res[i] = -1;
            } else {
                res[i] = entry.getValue();
            }
        }
        return res;
    }


}
