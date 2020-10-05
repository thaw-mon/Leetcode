package Year2020.October.day01;

import java.util.ArrayList;

public class Demo04 {

    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int left = 0, right = array.length - 1;
        if (right < 1) return new ArrayList<>();
        int multiResult = Integer.MAX_VALUE;
        int num1 = array[0] - 1, num2 = array[0] - 1;
        while (left < right) {
            //fit result
            if (array[left] + array[right] == sum) {
                if (array[left] * array[right] < multiResult) {
                    multiResult = array[left] * array[right];
                    num1 = array[left];
                    num2 = array[right];
                }
                left++;
                right--;
            } else if (array[left] + array[right] > sum) {
                right--;
            } else {
                left++;
            }

        }
        ArrayList<Integer> ret = new ArrayList<>();
        if (num1 >= array[0]) {
            ret.add(num1);
            ret.add(num2);
        }
        return ret;
    }
}
