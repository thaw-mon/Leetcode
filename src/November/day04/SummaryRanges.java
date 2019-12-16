package November.day04;

import java.util.*;
/**
 * @题目 ： 352. Data Stream as Disjoint Intervals
 * @Data 19/11/12
 * @题目描述： Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * @题目链接： 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * @示例1: ######
 * @示例2: ######
 * @示例3: ###
 */


/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */

public class SummaryRanges {
    /**
     * Initialize your data structure here.
     */
    //非负数数据流
    Set<Integer> sets;
    List<int[]> lists;

    public SummaryRanges() {
        sets = new TreeSet<>();
        lists = new LinkedList<>();
    }

    public void addNum(int val) {
        if (sets.contains(val)) return;
        sets.add(val);
        //将left和right相连
        if (sets.contains(val - 1) && sets.contains(val + 1)) {
            //二分查找 find val-1 in lists
            int index = findIndex(val - 1, 1);
            lists.get(index)[1] = lists.get(index + 1)[1];
            lists.remove(index + 1);
        } else if (sets.contains(val - 1)) {
            int index = findIndex(val - 1, 1);
            lists.get(index)[1] = val;
        } else if (sets.contains(val + 1)) {
            int index = findIndex(val + 1, 0);
            lists.get(index)[0] = val;
        } else {
            //val不存在与其相连的数字，单独存在
            int index = findIndex(val, 0);
            lists.add(index, new int[]{val, val});
        }
    }

    private int findIndex(int val, int i) {
        int l = 0, r = lists.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (lists.get(mid)[i] < val - 1) {
                l = mid + 1;
            } else if (lists.get(mid)[i] > val - 1)
                r = mid - 1;
            else {
                l = mid;
                break;
            }
        }
        return l;
    }

    public int[][] getIntervals() {
        int[][] res = new int[lists.size()][];
        for(int i=0;i<lists.size();i++){
            res[i] = lists.get(i);
        }
        return res;
    }
}
