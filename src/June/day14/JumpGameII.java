package June.day14;

/**
 * @题目 ：45. 跳跃游戏 II
 * @题目描述： 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * @Date:19/6/26
 * @说明: 假设你总是可以到达数组的最后一个位置。
 * @示例 1: 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 */
public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new JumpGameII().jump2(nums));
    }


    //1.暴力算出所有可能性-->超时
    public int jump(int[] nums) {
        int n = nums.length;
        //array 默认为0
        int[] array = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int step = nums[i];
            for (int j = 1; j <= step; j++) {
                int nextStep = i + j;
                if (nextStep >= n) {
                    break;
                }
                //更新下一步的最短步数
                array[nextStep] = array[nextStep] == 0 ? (array[i] + 1) : Math.min(array[nextStep], array[i] + 1);
            }
        }
        return array[n - 1];
    }

    //计算每一步的范围：当到达终点停止
    public int jump2(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return 0;
        }
        //array 默认为0
        int[] array = new int[n];
        //第一步的范围
        array[1] = nums[0];
        if(array[1]>=n-1){
            return 1;
        }
        int step = 1;
        for (int i = 1; i < n - 1; i++) {
            //当前在上一步的范围内
            if (i <= array[step]) {
                array[step + 1] = Math.max(nums[i] + i,array[step+1]);
            }else {
                step++;
                array[step+1] = Math.max(nums[i] + i,array[step+1]);
            }
            //走到终点
            if(array[step+1]>=n-1){
                break;
            }
        }
        return step+1;
    }

    //思路差不多，写法更优
//    作者：windliang
//    链接：https://leetcode-cn.com/problems/two-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int jump3(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
