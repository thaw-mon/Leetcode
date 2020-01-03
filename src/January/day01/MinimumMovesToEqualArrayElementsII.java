package January.day01;


import java.util.Arrays;

/**
 * @题目 ：462. Minimum Moves to Equal Array Elements II
 * @Data 20/01/02
 * @题目描述： Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * <p>
 * You may assume the array's length is at most 10,000.
 * @题目链接： 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii
 * @示例1: ######
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * @示例2: ######
 * @示例3: ###
 */

public class MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args){
        int[] array = {1,2,3};
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(array));
    }
    //每次只能对一个元素进行加1或减少1操作，判断最少的次数使得全部元素相等。
    //应该是中间数字(确实只需要考虑中位数就行了：可以证明)
    //因此可以不必完全排序：只要找到中位数就行了--》快排思路
    public int minMoves2(int[] nums) {
        //1.先排序
        Arrays.sort(nums);
        int i = 0,j = nums.length - 1, res = 0;
        while (i < j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }
}
