package Year2020.January.day04;

import java.util.Arrays;

/**
 * @题目 ：473. Matchsticks to Square
 * @Data 20/01/11
 * @题目描述： Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 * <p>
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * @题目链接： 链接：https://leetcode-cn.com/problems/matchsticks-to-square
 * @示例1: ######
 * Input: [1,1,2,2,2]
 * Output: true
 * <p>
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * @示例2: ######
 * Input: [3,3,3,3,4]
 * Output: false
 * <p>
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * @示例3: ###
 */

public class MatchsticksToSquare {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2};
        System.out.println(new MatchsticksToSquare().makesquare(nums));
    }

    public boolean makesquare(int[] nums) {
        int sum = 0, edge = 0;
        //1.求和，判断是否是4的倍数
        for (int num : nums)
            sum += num;
        if (sum % 4 > 0 || nums.length < 4) return false;
        edge = sum / 4;
        //2.判断是否可以获得4条边
        Arrays.sort(nums);
        //简单剪枝
        if (nums[nums.length - 1] > edge) return false;
        int[] edges = new int[4];
        return dfs(nums, edges, edge, nums.length - 1);
    }

    //直接DFS会超时的，考虑同时给四个数组添加火柴
    boolean dfs(int[] nums, int[] edges, int avg, int index) {
        if (index < 0) return true; //全部火柴放置完成
        //将第index根火柴放入第i条边
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] + nums[index] <= avg) {
                edges[i] += nums[index];
                if (dfs(nums, edges, avg, index - 1)) return true;
                edges[i] -= nums[index];
            }
        }
        return false;
    }
}
