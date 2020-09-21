package Year2020.September.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo03 {

    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     *
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        //思路就是找到1出现的规律
        //1: 1 2:20 3 :300 4:4000;
        int bit = 1, p = 1;
        List<Integer> bitCount = new ArrayList<>();
        bitCount.add(0); //占据0
        Stack<Integer> numStack = new Stack<>(); //保存之前的数据
        numStack.push(0); //
        int count = 0;
        while (n > 0) {
            int tmp = n % 10;
            bitCount.add(bit * p);
            if (tmp > 0) {
                if (tmp == 1) {
                    count += (numStack.peek() + 1) + bitCount.get(bit - 1);
                } else {
                    count += tmp * bitCount.get(bit - 1) + p; //p-1计算的是首位数字为1数目
                }
            }
            numStack.push(numStack.peek() + tmp * p);
            n /= 10;
            bit++;
            p *= 10;

        }
        return count;
    }

    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        System.out.println(demo03.NumberOf1Between1AndN_Solution(13));
    }
}
