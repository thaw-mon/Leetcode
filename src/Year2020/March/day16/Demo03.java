package Year2020.March.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo03 {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //找到三个数相加为0的三元组
        //1.对num进行排序
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int index = N - 1;
            for (int j = i + 1; j < N; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int current = nums[i] + nums[j];
                while (index > j) {
                    if (current + nums[index] <= 0) break;
                    index--;
                }
                if (index > j && current + nums[index] == 0) {
                    List<Integer> zeroAnswer = new ArrayList<>();
                    zeroAnswer.add(nums[i]);
                    zeroAnswer.add(nums[j]);
                    zeroAnswer.add(nums[index]);
                    ret.add(zeroAnswer);
                }
            }
        }


        return ret;
    }
}
