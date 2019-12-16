package August.day06;

/**
 * @题目 ：152. 乘积最大子序列
 * @Data: 19/8/11
 * @题目描述： 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * @题目地址： https://leetcode-cn.com/problems/maximum-product-subarray/
 * @示例1: ######
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * @示例2: ###
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * @示例3: ###
 **/

public class MaximumProductSubarray {

    //注意:负负得正
    //动态规划 但是只需要常数级别的变量
    //TODO 写得太冗余了，没有完全理清关系
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int res = nums[0];

        int current = nums[0];
        int preNum = nums[0];
        //保留最小负值 若为正数则设为0
        int minus = Math.min(0, nums[0]);
        for (int i = 1; i < n; i++) {
            //current = num[i]   preNum * num[i];  minus * nums[i]
            current = Math.max(nums[i], preNum * nums[i]);
            if (minus != 0)
                current = Math.max(current, minus * nums[i]);

            //minus = nums[i] , nums[i] * preNum , minus * nums[i] , 0
            //前面最小值为非负数==》 preNum >= 0
            int tmp = minus;
            minus = Math.min(nums[i], nums[i] * tmp);
            minus = Math.min(minus, nums[i] * preNum);
            minus = Math.min(minus, 0);
            preNum = current;

            res = Math.max(res, current);
        }
        return res;
    }

    //  作者：guanpengchn
    //    链接：https://leetcode-cn.com/problems/two-sum/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //思路是一样的，但是我的代码更加冗余。
    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }


}
