package June.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Data 19/6/5
 * @题目描述： 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * 注意：答案中不可以包含重复的四元组。
 * @示例： 输入:nums = [1, 0, -1, 0, -2, 2] target = 0
 * 输出: [  [-1,  0, 0, 1],  [-2, -1, 1, 2],  [-2,  0, 0, 2]  ]
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(new FourSum().fourSum(nums, 0));
    }

    //和之前的三数和差不多 双指针
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break; //最小值大于target
            if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue; //最大值小于target
            if (i > 0 && nums[i - 1] == nums[i]) continue; //去重
            for (int j = i + 1; j < n - 2; j++) {
                //同理剪枝
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break; //最小值大于target
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue; //最大值小于target
                if (j > i + 1 && nums[j - 1] == nums[j]) continue; //去重
                int l = j + 1, r = n - 1;
                while (l < r) {
                    if (nums[r] + nums[l] + nums[i] + nums[j] > target) {
                        while (l < r && nums[r - 1] == nums[r]) r--; //右指针去重
                        r--;
                    } else if (nums[r] + nums[l] + nums[i] + nums[j] < target) {
                        while (l < r && nums[l + 1] == nums[l]) l++; //左指针去重
                        l++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[r - 1] == nums[r]) r--; //左指针去重
                        while (l < r && nums[l + 1] == nums[l]) l++; //右指针去重
                        r--;
                        l++;
                    }
                }
            }
        }
        return res;
    }

}
