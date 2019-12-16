package September.day10;

/**
 * @题目 ： 238. Product of Array Except Self
 * @Data 19/9/17
 * @题目描述：Write Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * @题目地址： 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * Note: Please solve it without division and in O(n).
 * @示例1: ######
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * @示例2: ###
 * @示例3: ###
 */

public class ProductOfArrayExceptSelf {

    //不能用除法的乘积
    //三遍遍历法
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                left[i] = nums[i];
            else
                left[i] = left[i - 1] * nums[i];
        }
        for (int j = n - 1; j >= 0; j--) {
            if (j == n - 1)
                right[j] = nums[j];
            else
                right[j] = right[j + 1] * nums[j];
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) nums[i] = right[i + 1];
            else if (i == n - 1)
                nums[i] = left[i - 1];
            else
                nums[i] = left[i - 1] * right[i + 1];
        }
        return nums;
    }

    //大佬的一遍遍历法
//          作者：ooolize-2
//        链接：https://leetcode-cn.com/problems/product-of-array-except-self/solution/yi-ci-bian-li-qiao-miao-cun-chu-he-ji-suan-zuo-ji-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int left = 1, right = 1;     //left：从左边累乘，right：从右边累乘
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = 1;

        for (int i = 0; i < n; ++i)    //最终每个元素其左右乘积进行相乘得出结果
        {
            res[i] *= left;       //乘以其左边的乘积
            left *= nums[i];

            res[n - 1 - i] *= right;  //乘以其右边的乘积
            right *= nums[n - 1 - i];
        }

        return res;

    }
}
