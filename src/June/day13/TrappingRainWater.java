package June.day13;

import java.util.Arrays;

/**
 * @题目 ：42. 接雨水
 * @题目描述： 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @Date:19/6/25
 * @示例 1: 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1,10};
        System.out.println(new TrappingRainWater().trap(nums));
    }

    //暴力法：按照高度一层层的遍历--结果超时
    //优化策略：最开始选择每层+1，当数字大太时，需要遍历很多次
    //所以：选择对数组排序，从小到大依次选择 还是超时了
    public int trap(int[] height) {

        int length = height.length;
        //对height做一份副本排序
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = height[i];
        }
        Arrays.sort(array);
        int water = 0;
        int i = 0;
        while (i < array.length) {
            //找到第一个非array[i]的数
            int baseHigh = array[i];
            int nextHigh = array[i];
            //找到下一个高度
            for (; i < array.length; i++) {
                if (array[i] > baseHigh) {
                    nextHigh = array[i];
                    break;
                }
            }

            int j = 0;
            while (j < length && height[j] == baseHigh) {
                height[j] = nextHigh;
                j++;
            }
            int k = length - 1;
            while (k > 0 && height[k] == baseHigh) {
                height[k] = nextHigh;
                k--;
            }
            for (; j <= k; j++) {
                if (height[j] == baseHigh) {
                    water += nextHigh - baseHigh;
                    height[j] = nextHigh;
                }
            }

        }
        return water;
    }

    //官方解答1
//    直接按问题描述进行。对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/jie-yu-shui-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //优化策略：提前存储左右两边的最大值，每次更新
    int trap2(int[] height)
    {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }

        return ans;
    }

    //way3:双指针法：只要O(n)时间和O(1)空间

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/jie-yu-shui-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int trap3(int[] height)
    {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= left_max){
                     left_max = height[left];
                }else {
                    ans += (left_max - height[left]);
                }
                ++left;
            }
            else {
                if(height[right] >= right_max){
                    right_max = height[right];
                }else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

}
