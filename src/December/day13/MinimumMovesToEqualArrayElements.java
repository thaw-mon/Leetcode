package December.day13;

/**
 * @题目 ：453. Minimum Moves to Equal Array Elements
 * @Data 19/12/27
 * @题目描述： Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * @题目链接： 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * @示例1: ######
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * @示例2: ######
 * @示例3: ###
 */

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args){
        int[] nums = {-100,0,100};
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));
    }
    //每次给n-1元素加1，求需要多少次使得全部元素相等。
    //直接求差值是否是倍数，有问题 eg [-100,0,100]
    //TODO error answer : [-100,0,100]
    public int minMovesX(int[] nums) {
        //1.获取最大值，sum和 n
        int n = nums.length;
        if(n < 2) return 0;
        long sum = 0;
        long max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        //2.计算全部值到max的差值是否是n-1的倍数 注意溢出的可能
        long less = n * max - sum; //记录差值
        //如果不是倍数的化，全部数字加1
        while (less % (n - 1) > 0) {
            less += n;
        }
        less /= (n - 1);
        return (int)less;
    }

    //该方法基于以下思路：将除了一个元素之外的全部元素+1，等价于将该元素-1
    //和前面错误答案刚好反过来就ok了
//      作者：LeetCode
//        链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-yi-dong-ci-shu-shi-shu-zu-yuan-su-xiang-d/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }
        return moves - min * nums.length;
    }
}
