package December.day13;

import java.util.Stack;

/**
 * @题目 ：456. 132 Pattern
 * @Data 19/12/27
 * @题目描述： Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * @题目链接： 链接：https://leetcode-cn.com/problems/132-pattern
 * @示例1: ######
 * Input: [1, 2, 3, 4]
 * <p>
 * Output: False
 * <p>
 * Explanation: There is no 132 pattern in the sequence.
 * @示例2: ######
 * Input: [3, 1, 4, 2]
 * <p>
 * Output: True
 * <p>
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * @示例3: ###
 * Input: [-1, 3, 2, 0]
 * <p>
 * Output: True
 * <p>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */

public class OneThreeTwoPattern {
    public static void main(String[] args){
        int[] nums = {6,12,3,4,6,11,10};
        System.out.println(new OneThreeTwoPattern().find132pattern(nums));
    }
    //是否可以找到一个序列满足 1 3 2大小排序
    //TODO error eg：[3,5,0,3,4]
    public boolean find132patternx(int[] nums) {
        Stack<Integer> stack = new Stack<>(); //维护递增栈
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.add(num);
                continue;
            }
            //维护递增栈序列
            if (num < stack.peek()) {
                //存在小于栈顶元素
                while (!stack.isEmpty() && num < stack.peek()) {
                    stack.pop();
                }
                //存在1 3 2 模式
                if (!stack.isEmpty()) return true;
            }
            stack.add(num);
        }
        return false;
    }

//       作者：LeetCode
//    链接：https://leetcode-cn.com/problems/132-pattern/solution/132mo-shi-by-leetcode-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack < Integer > stack = new Stack < > ();
        int[] min = new int[nums.length]; //维护最小数组
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }


}
