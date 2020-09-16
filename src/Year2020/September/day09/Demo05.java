package Year2020.September.day09;

import java.util.Stack;

public class Demo05 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        //最简单的思路是分两队，奇数为1队，偶数为1队。然后合并
        Stack<Integer> oodStack = new Stack<>();
        int n = array.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) {
                oodStack.push(array[i]);
            } else {
                array[p++] = array[i];
            }
        }
        //然后偶数插入数组
        p = n-1;
        while (!oodStack.isEmpty()){
            array[p--] = oodStack.pop();
        }
    }
}
