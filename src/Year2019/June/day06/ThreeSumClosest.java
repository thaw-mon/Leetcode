package Year2019.June.day06;

import java.util.Arrays;

/**
 * @Data 19/6/5
 * @题目描述： 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * @示例： 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(new ThreeSumClosest().threeSumClosest2(nums, 1));
    }

    //暴力法 + 剪枝 (ok)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int close = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; //去重
                for (int k = j + 1; k < nums.length; k++) {
//                    if (k > j+1 && nums[k] == nums[k - 1]) continue; //去重
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (tmp - target >= 0) {
                        if(tmp-target < close){
                            close = tmp - target;
                            res = tmp;
                        }
                        break;
                    }
                    if(target - tmp < close){
                        close = target - tmp;
                        res = tmp;
                    }
                }
            }
            if(res == target){
                return res;
            }
        }
        return res;
    }

    //采用和三数和类似的双指针策略(时间减少很多 暴力剪枝 39ms 双指针 17ms 内存使用差不多)
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int ans = nums[i] + nums[l] + nums[r];
                if (Math.abs(ans - target) < Math.abs(res - target)) {
                    res = ans;
                }
                if(ans < target){
                    l++;
                }
                else if(ans > target){
                    r--;
                }
                else
                    return ans;
            }
        }
        return res;
    }
}
