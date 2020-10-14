package Year2020.October.day07;

import java.util.Arrays;

public class Demo01 {

    /**
     * 返回两次操作后，数组元素之和的最小值,每次操作把大于等于x的数字减少x
     * 思路1 ：每次选择减少值最大的x进行， 结果错误，局部最小不等于全局最小
     * 思路2：暴力遍历法：结果超时了
     *
     * @param nums int整型一维数组 这你你需要操作的数组
     * @return long长整型
     */
    public long minimumValueAfterDispel(int[] nums) {
        // write code here
        Arrays.sort(nums);  //首先对数组排好序
        int n = nums.length;
        //只有两次机会尽可能使得每次削减值最大
        long sum = 0;
        long maxCutNumber = 0;
        long dp = 0; //第一轮选择第i个值可以削减的值大小
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                // dp[i] = dp[i - 1];
                continue; //相同的数字优先选择前者
            }
            dp = nums[i] * (n - i);
            //模拟第二轮削减值
            //分为两部分，before i and after i
            long maxCut = 0;
            for (int j = 0; j < n; j++) {
                if (j > 0 && nums[j] == nums[j - 1]) continue;
                long currentCut = 0;
                if (j < i) { //选择数字为前半部分
                    currentCut += nums[j] * (i - j); //左半部分[0,i)
                    //考虑右半部分 [i+1,n) 使用二分查找
                    int index = binarySearch(nums, i, n - 1, nums[j] + nums[i]);
                    currentCut += nums[j] * (n - index);
                } else {
                    //选择数字为右半部分
                    currentCut += (nums[j] - nums[i]) * (n - j);
                    int index = binarySearch(nums, 0, i, nums[j] - nums[i]);
                    currentCut += (nums[j] - nums[i]) * (i - index);
                }
                maxCut = Math.max(maxCut, currentCut);
            }
            dp += maxCut;
            maxCutNumber = Math.max(dp, maxCutNumber);
        }

        return sum - maxCutNumber;
    }

    //思路：https://blog.nowcoder.net/n/6d0f616283964ae990658dcf8fee1056?f=comment
    public long minimumValueAfterDispel2(int[] nums) {
        // write code here
        Arrays.sort(nums);  //首先对数组排好序
        int n = nums.length;
        long maxCut = 0, sum = 0;

        for (int num : nums) sum += num;
        for (int i = 0; i < n; i++) {
            int h1 = nums[i];
            for (int j = i + 1; j < n; j++) { // 第二个高度为nums[j]
                int h2 = nums[j], h3 = nums[j] + nums[i];
                int index = binarySearch(nums, 0, n-1, h3);
                long currentCut = (j - i) * h1 + (index - j) * h2 + (n - index) * h3;
                maxCut = Math.max(currentCut, maxCut);
            }
            for (int j = n - 1; j > i && nums[j] - nums[i] > nums[i]; j--) { // 第三个高度为nums[j]
                int h3 = nums[j], h2 = nums[j] - nums[i];
                int index = binarySearch(nums, 0, n-1, h2);
                long currentCut = (index - i) * h1 + (j - index) * h2 + (n - j) * h3;
                maxCut = Math.max(currentCut, maxCut);
            }
        }

        for (int i = 0; i < n; i++) { // 第二个高度为 nums[i]
            int h2 = nums[i];
            for (int j = i + 1; j < n; j++) { // 第三个高度为 nums[j]
                int h3 = nums[j];
                if(h3 - h2 <= 0 || h3 - h2 >= h2)
                    continue;
                int h1 = h3 - h2;
                int index = binarySearch(nums, 0, n-1, h1);
                long currentCut = (i - index) * h1 + (j - i) * h2 + (n - j) * h3;
                maxCut = Math.max(currentCut, maxCut);
            }
        }

        return sum - maxCut;
    }

    //获取第一个大于等于 target的位置索引
    private int binarySearch(int[] array, int left, int right, int target) {
        if (array[left] >= target) return left;
        if (array[right] < target) return right + 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        System.out.println(new Demo01().minimumValueAfterDispel2(nums));
    }

}
