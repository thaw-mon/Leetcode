package Year2020.May.day01;

public class Demo02 {

    /**
     * 非递减数列
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，总满足 array[i] <= array[i + 1]。
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                //需要修改值了(无法判定是为nums[i-1],还是nums[i+1]啊)
                if (i == 0) {
                    nums[i] = nums[i + 1];
                    count++;
                } else if (nums[i - 1] > nums[i + 1]) { //逆序情形
                    nums[i + 1] = nums[i];
                    count++;
                } else {
                    nums[i] = nums[i + 1];
                    count++;
                }

            }
            if (count > 1)
                return false;
        }
        return true;
    }
}
