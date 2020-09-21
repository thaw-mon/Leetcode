package Year2020.September.day13;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();

        int[] array = {4,5,1,6,2,7,3,8};
        List<Integer> ret = demo01.GetLeastNumbers_Solution(array, 4);
        System.out.println(ret);
    }

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        //1.第一想法就是排序获取前k个字符
        //2.优化策略其实可以采用快排思路
        ArrayList<Integer> ret = new ArrayList<>();
        if (k <= 0) return ret;
        if (k >= input.length) {
            for (int num : input) ret.add(num);
            return ret;
        }
        spilt(input, k - 1, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    public void spilt(int[] input, int k, int l, int r) {
        //对left,right的数据进行QuickSort
        int left = l, right = r;

        int tmp = input[left];
        while (left < right) {
            //1.首先从右边开始
            while (left < right && input[right] > tmp) {
                right--;
            }
            //此时input[right] <= tmp || left == right
            if (left == right) {
                input[left] = tmp;
                break;
            }
            input[left] = input[right];
            left++;
            //2.然后从左边进行遍历
            while (left < right && input[left] <= tmp) {
                left++;
            }
            //此时input[left]> tmp || left == right
            if (left == right) {
                input[right] = tmp;
                break;
            }
            input[right] = input[left];
            right--;
        }
        input[left] = tmp; //防止为赋值
        //Left值与k值比较
        if (left > k) {
            spilt(input, k, l, left - 1);
        } else if (left < k) {
            spilt(input, k, left + 1, r);
        }
        //left == k符合添加终止循环
    }
}
