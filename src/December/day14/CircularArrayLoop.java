package December.day14;

import java.util.HashSet;
import java.util.Set;

/**
 * @题目 ：457. Circular Array Loop
 * @Data 19/12/30
 * @题目描述： You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.
 * <p>
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.
 * @题目链接： 链接：https://leetcode-cn.com/problems/circular-array-loop
 * @示例1: ######
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 * @示例2: ######
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
 * @示例3: ###
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 */

public class CircularArrayLoop {

    public static void main(String[] args) {
        int[] nums = {-2, -3, -9};
        System.out.println(-5 % 3);
        System.out.println(new CircularArrayLoop().circularArrayLoop(nums));
    }

    //正数表示前进吗，负数表示后退，判断是否存在一个序列保持一致的方向（前进或后退），形成一个闭环,序列长度至少为2
    //使用了set，勉强通过
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length; //定义数组长度
        if (n < 2) return false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            //对i进行循环判断
            boolean move = nums[i] > 0; //判断前进方向
            int step = 0; //记录移动次数
            int j = (i + nums[i] + n) % n;
            if (j < 0) j = (j + n) % n; //两次取模后必然是正数
            Set<Integer> set = new HashSet<>();
            set.add(i);
            while (j != i) {
                if (nums[j] < 0 == move) { //移动方向改变跳出循环
                    step = 0;
                    break;
                }
                if (set.contains(j))
                    break;
                step++;
                set.add(j);
                j = (j + nums[j] + n) % n; //走向下一步
                if (j < 0) j = (j + n) % n; //两次取模后必然是正数
            }
            if (step > 0 && j != (j + nums[j] + n) % n) return true; //如果set存在循环
        }
        return false;
    }
//    作者：mian-zhao-da-hai-7
//    链接：https://leetcode-cn.com/problems/circular-array-loop/solution/shuang-zhi-zhen-java-beat-100-by-mian-zhao-da-hai-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //优化方法：使用快慢指针解决该类问题
    private void setZero(int[] nums, int i){
        int j;
        while (true) { // !(nums[j] == 0 || nums[i]*nums[j]<0)
            j = (i + nums[i] + 5000*nums.length) % nums.length;
            if (nums[j] == 0 || nums[i]*nums[j]<0) {
                nums[i] = 0;
                break;
            }
            nums[i] = 0;
            i = j;
        }
    }

    // beat 100%
    public boolean circularArrayLoop2(int[] nums) {
        if (nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int lastJ, lastK;
            int j=i, k=i;

            while (true) {
                lastJ = j;
                j = (j + nums[j] + 5000*nums.length) % nums.length;
                if (nums[lastJ]*nums[j] < 0 || nums[j] == 0 || lastJ == j) {
                    setZero(nums, i);
                    break;
                }
                lastK = k;
                k = (k + nums[k] + 5000*nums.length) % nums.length;
                if (nums[lastK]*nums[k] < 0 || nums[k] == 0 || lastK == k){
                    setZero(nums, i);
                    break;
                }
                lastK = k;
                k = (k + nums[k] + 5000*nums.length) % nums.length;
                if (nums[lastK]*nums[k] < 0 || nums[k] == 0 || lastK == k){
                    setZero(nums, i);
                    break;
                }
                if (j == k)
                    return true;
            }
        }
        return false;
    }


}
