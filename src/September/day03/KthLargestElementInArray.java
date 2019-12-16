package September.day03;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @题目 ： 215. Kth Largest Element in an Array
 * @Data 19/9/04
 * @题目描述： Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * @题目地址： 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * @示例1: ######
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * @示例2: ###
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * @示例3: ###
 */

public class KthLargestElementInArray {

    //1. 直接排序法 -- 本来以为会超时，结果居然过了
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-k];
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //采用小根堆写法
    public int findKthLargest2(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>();

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    //3. 快排思想: 略


}
