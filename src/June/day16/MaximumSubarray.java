package June.day16;

/**
 * @题目 ：53. 最大子序和
 * @题目描述： 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Date:19/6/28
 * @示例 1: 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 **/
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int preMax = nums[0];
        //pre > 0
        for (int i = 1; i < n; i++) {
            if(preMax <=0){
                preMax = nums[i];
            }else
                preMax +=nums[i];
            max = Math.max(max,preMax);
        }
        return max;
    }
}
