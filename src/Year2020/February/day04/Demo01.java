package Year2020.February.day04;

import java.util.*;

public class Demo01 {

    /**
     * @param A
     * @return 返回使 A 中的每个值都是唯一的最少操作次数。
     * @title 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1
     */

    public int minIncrementForUnique(int[] A) {
        //两种思路：1、排序； 2、使用map或set保存结果(超时了)
        //Map结果超时了，排序反而通过了
        int ret = 0;
        if (A.length <= 1) return ret;
        Arrays.sort(A); //数组排序
        int r = A[0]; //记录右边界位置
        for (int i = 1; i < A.length; i++) {
            //当前数字在右边界内部，右边界扩展1
            if (A[i] <= r) {
                r = r + 1;
                ret += (r - A[i]);
            } else
                r = A[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = {3, 2, 1, 2, 1, 7};
        Demo01 demo01 = new Demo01();
        System.out.println(demo01.minIncrementForUnique(num));
    }
}
