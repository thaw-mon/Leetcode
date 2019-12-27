package December.day13;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @题目 ：452. Minimum Number of Arrows to Burst Balloons
 * @Data 19/12/27
 * @题目描述： There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
 * <p>
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 * @题目链接： 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * @示例1: ######
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 * @示例2: ######
 * @示例3: ###
 */

public class MinimumNumberOfArrowsBurstBalloons {

    //简单来说。就是计算区间重叠的最大数目
    //这道题是求射爆全部气球的最小数目
    public int findMinArrowShots(int[][] points) {

        //1.对point进行排序(升序)
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int res = 0;

        //进行贪心算法计算
        for (int i = 0; i < points.length; i++) {
            int start = points[i][0], end = points[i][1]; //记录重叠区间
            //计算包括i最多存在多少个重合区间
            int j = i + 1;
            for (; j < points.length; j++) {
                if (points[j][0] <= end) {
                    start = points[j][0];
                    end = Math.min(end, points[j][1]);
                } else {
                    break;
                }
            }
            //当前j不在重叠区间内
            res += 1;
            i = j - 1;
        }

        return res;
    }
}
