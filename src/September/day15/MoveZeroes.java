package September.day15;

/**
 * @题目 ： 283. Move Zeroes
 * @Data 19/9/28
 * @题目描述： Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * @题目地址： 链接：https://leetcode-cn.com/problems/move-zeroes
 * @示例1: ######
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * @示例2: ###
 * @示例3: ###
 */

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        //
        int index = -1; //指向第一个0位置,默认-1
        for (int i = 0; i < n; i++) {
            //没有找到0
            if (index == -1) {
                //找到第一个0的位置
                if (nums[i] == 0)
                    index = i;
                continue;
            }
            // index != -1 即找到了0
            if (nums[i] != 0) {
                //index上的0和i交换
                nums[index] = nums[i];
                nums[i] = 0;
                index++;
            }
        }
    }
}
