package October.day09;

import java.util.Arrays;

/**
 * @题目 ： 322. Coin Change
 * @Data 19/10/17
 * @题目描述： Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * @示例1: ######
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * @示例2: ######
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * @示例3: ###
 */
public class WiggleSortII {

//    作者：heator
//    链接：https://leetcode-cn.com/problems/wiggle-sort-ii/solution/javaxiang-xi-ti-jie-shuo-ming-by-heator/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    /**
     * 先排序再穿插
     * O(nlogn)+O(n)=O(nlogn)
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        //排序
        Arrays.sort(nums);
        int len=nums.length,i = 0;
        int[] smaller=new int[len%2==0?len/2:(len/2+1)],bigger=new int[len/2];
        //复制
        System.arraycopy(nums,0,smaller,0,smaller.length);
        System.arraycopy(nums,smaller.length,bigger,0,len/2);
        //穿插
        for (; i < len / 2; i++) {
            nums[2*i]=smaller[smaller.length-1-i];
            nums[2*i+1]=bigger[len/2-1-i];
        }
        if (len%2!=0) nums[2*i]=smaller[smaller.length-1-i];
    }

    //大佬的O(N)解法
//    void wiggleSort(vector<int>& nums) {
//        int n = nums.size();
//        std::nth_element(nums.begin(), nums.begin() + n/2, nums.end());
//        int mid = nums[n/2];
//
//        // 3-way-partion
//        int i = 0;
//        int j = 0;
//        int k = n - 1;
//
//        #define a(i) nums[(2*(i)+1)%(n|1)]
//
//        while (j <= k) {
//            if (a(j) > mid) {
//                swap(a(i), a(j));
//                ++i;
//                ++j;
//            } else if (a(j) < mid) {
//                swap(a(j), a(k));
//                --k;
//            } else {
//                ++j;
//            }
//        }
//    }


}
