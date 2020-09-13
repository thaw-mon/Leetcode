package Year2019.July.day15;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：120. 三角形最小路径和
 * @Data: 19/7/18
 * @题目描述： 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * @示例 1：
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * @说明： 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * @示例 2: ###
 **/

public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> demo = new ArrayList<>();
        List<Integer> d1 = new ArrayList<>();
        d1.add(2);
        demo.add(d1);
        List<Integer> d2 = new ArrayList<>();
        d2.add(3);
        d2.add(4);
        demo.add(d2);
        List<Integer> d3 = new ArrayList<>();
        d3.add(6);
        d3.add(5);
        d3.add(7);
        demo.add(d3);
        List<Integer> d4 = new ArrayList<>();
        d4.add(4);
        d4.add(1);
        d4.add(8);
        d4.add(3);
        demo.add(d4);

        System.out.println(new Triangle().minimumTotal(demo));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != 0)
                dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j >= 1; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            res = Math.min(dp[i], res);
        return res;
    }
}
