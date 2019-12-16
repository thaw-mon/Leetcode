package June.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Data 19/6/4
 * @题目描述： 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * @示例： 输入: nums = [-1, 0, 1, 2, -1, -4]，
 * 输出: [   [-1, 0, 1],  [-1, -1, 2]  ]
 */

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, -2, 0, 0, -1};
        System.out.println(new ThreeSum().threeSum1(nums));
    }

    //1. 暴力法(超时)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (tmp == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!res.contains(list)) {
                            res.add(list);
                        }
                    }
                    if (tmp > 0) {
                        break;
                    }
                }
            }
        }
        return res;
    }

    //分割策略（超时）
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> num1 = new ArrayList<>();  //负数
        List<Integer> num2 = new ArrayList<>();  //0
        List<Integer> num3 = new ArrayList<>();  //正数
        for (int num : nums) {
            if (num < 0) {
                num1.add(num);
            } else if (num > 0) {
                num3.add(num);
            } else {
                num2.add(num);
            }
        }
        //res = 2负数+1正数   1负数+2正数   1负数+1正数+1零  3零
        int max = 0;
        int min = 0;
        if (!num3.isEmpty()) {
            max = num3.get(num3.size() - 1);
        }
        if (!num1.isEmpty()) {
            min = num1.get(0);
        }

        for (int i = num1.size() - 1; i >= 1; i--) {
            //剪枝
            if (num1.get(i) + num1.get(i - 1) + max < 0) {
                break;
            }
            for (int j = i - 1; j >= 0; j--) {
                int tmp = num1.get(i) + num1.get(j);
                if (num3.contains(-tmp)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num1.get(i));
                    list.add(num1.get(j));
                    list.add(-tmp);
                    if (!res.contains(list)) {
                        res.add(list);
                    }
                }
            }

        }
        for (int i = 0; i < num3.size() - 1; i++) {
            //剪枝
            if (num3.get(i) + num3.get(i + 1) + min > 0) {
                break;
            }
            for (int j = i + 1; j < num3.size(); j++) {
                int tmp = num3.get(i) + num3.get(j);
                if (num1.contains(-tmp)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(-tmp);
                    list.add(num3.get(i));
                    list.add(num3.get(j));
                    if (!res.contains(list)) {
                        res.add(list);
                    }
                }
            }
        }
        if (!num2.isEmpty()) {
            for (int i = 0; i < num1.size(); i++) {
                if (num3.contains(-num1.get(i))) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num1.get(i));
                    list.add(0);
                    list.add(-num1.get(i));
                    if (!res.contains(list)) {
                        res.add(list);
                    }
                }
            }
        }
        if (num2.size() >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            res.add(list);

        }
        return res;
    }

    //大佬思路 ：双指针策略
    //    作者：ba-qiu-gei-wo
    //    链接：https://leetcode-cn.com/problems/two-sum/solution/pai-xu-shuang-zhi-zhen-yi-chu-pan-duan-by-ba-qiu-g/
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tuples = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue; //去重

            int l = i + 1, r = nums.length - 1;
            if (nums[l] < 0 && Integer.MIN_VALUE - nums[l] > nums[i]) continue; //如果溢出最小值则跳过
            if (nums[i] > 0 && Integer.MAX_VALUE - nums[l] < nums[i]) break; //溢出最大值直接结束，不可能会有新的三元组出现了

            while (l < r) {
                if (nums[r] > -nums[i] - nums[l]) {
                    while (l < r && nums[r - 1] == nums[r]) r--; //右指针去重
                    r--;
                } else if (nums[r] < -nums[i] - nums[l]) {
                    while (l < r && nums[l + 1] == nums[l]) l++; //左指针去重
                    l++;
                } else {
                    tuples.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r - 1] == nums[r]) r--; //左指针去重
                    while (l < r && nums[l + 1] == nums[l]) l++; //右指针去重
                    r--;
                    l++;
                }
            }
        }
        return tuples;
    }


}
