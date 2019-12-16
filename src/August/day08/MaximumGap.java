package August.day08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：164. Maximum Gap
 * @Data: 19/8/14
 * @题目描述： Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Return 0 if the array contains less than 2 elements.
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @题目地址： https://leetcode-cn.com/problems/maximum-gap/
 * @Note: ###
 * You may assume all elements in the array are non-negative integers
 * and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 * @示例1: ######
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 * @示例2: ###
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * @示例3: ###
 **/
public class MaximumGap {

    public static void main(String[] args) {
        int[] nums = {1,4,6,6,34,7,12,34,12,56};
        new MaximumGap().maximumGap2(nums);
    }

    //最简单方法是进行排序，但是时间复杂度非线性
    public int maximumGap(int[] nums) {
//        if (nums == null) throw new NullPointerException("数组输入null");
        int n = nums.length;
        if (n < 2) return 0;
        Arrays.sort(nums);
        int res = -1;
        for (int i = 1; i < n; i++)
            res = Math.max(nums[i] - nums[i - 1], res);
        return res;
    }

    //想要达到线性复杂度，需要空间换时间
    //鸽笼原理 :n 个物品放入 m 个容器中，如果 n > m 那么一定有一个容器装有至少两个物品。
    // 简单来说，使用桶排序方法
    public int maximumGap2(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        //找到数组中的最大最小值
        for (int num : nums) {
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }

        //构建bucket
        int bucketSize = Math.max(1, (maxi - mini) / ((int) nums.length - 1));        // bucket size or capacity
        int bucketNum = (maxi - mini) / bucketSize + 1;
//        System.out.println("桶大小为：" + bucketNum);
//        System.out.println("数组长度为：" + n);

        Bucket[] buckets = new Bucket[bucketNum];

        for(int num : nums){

            int bucketIdx = (num - mini) / bucketSize;                          // locating correct bucket
            //和C++不同的是，这里需要重新new一下
            if(buckets[bucketIdx] == null)
                buckets[bucketIdx] = new Bucket();
            buckets[bucketIdx].used = true;
            buckets[bucketIdx].minval = Math.min(num, buckets[bucketIdx].minval);
            buckets[bucketIdx].maxval = Math.max(num, buckets[bucketIdx].maxval);
        }

        int prevBucketMax = mini, maxGap = 0;
        for (Bucket bucket : buckets) {
            if (bucket == null || !bucket.used)
                continue;
            maxGap = Math.max(maxGap, bucket.minval - prevBucketMax);
            prevBucketMax = bucket.maxval;
        }


        return 0;
    }

    class Bucket {
        public boolean used = false;
        public int minval  = Integer.MAX_VALUE;
        public int maxval  = Integer.MIN_VALUE;

    }

    //基数排序法
//       作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zui-da-jian-ju-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int maximumGap3(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int exp = 1;                                 // 1, 10, 100, 1000 ...
        int radix = 10;                              // base 10 system
        int[] aux = new int[nums.length];
        /* LSD Radix Sort */
        while (maxVal / exp > 0) {  // Go through all digits from LSD to MSD
            int[] count = new int[radix];
            for (int i = 0; i < nums.length; i++)
                count[(nums[i] / exp) % 10]++;

            for (int i = 1; i < count.length; i++)   // you could also use partial_sum()
                count[i] += count[i - 1];

            for (int i = nums.length - 1; i >= 0; i--)
                aux[--count[(nums[i] / exp) % 10]] = nums[i];

            for (int i = 0; i < nums.length; i++)
                nums[i] = aux[i];

            exp *= 10;

        }
        int maxGap = 0;

        for (int i = 0; i < nums.length - 1; i++)
            maxGap = Math.max(nums[i + 1] - nums[i], maxGap);

        return maxGap;

    }


}
