package July.day04;

/**
 * @题目 ：75. 颜色分类
 * @题目描述： 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * @Date:19/7/4
 * @示例 1: 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 **/

public class SortColors {

    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0};
        new SortColors().sortColors2(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    //两趟排序思路
    public void sortColors(int[] nums) {
        int n = nums.length;
        int red = 0;
        //排序红色
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int tmp = nums[red];
                nums[red] = nums[i];
                nums[i] = tmp;
                red++;
            }
        }
        for (int i = red; i < n; i++) {
            if (nums[i] == 1) {
                int tmp = nums[red];
                nums[red] = nums[i];
                nums[i] = tmp;
                red++;
            }
        }
    }

    //一趟排序思路 0移动到左边，2移动到右边
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int red = 0;
        int blue = n - 1;
        //排序红色
        int i = 0;
        while (i <= blue) {
            if (nums[i] == 0) {
                if(i==red){
                    i++;
                    red++;
                    continue;
                }
                int tmp = nums[red];
                nums[red] = nums[i];
                nums[i] = tmp;
                red++;
            } else if (nums[i] == 2) {
                int tmp = nums[blue];
                nums[blue] = nums[i];
                nums[i] = tmp;
                blue--;
            }else {
                i++;
            }
        }

    }
}
