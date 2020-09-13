package Year2020.March.day17;

public class Demo01 {

    /**
     * 「无零整数」是十进制表示中 不含任何 0 的正整数。
     * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
     * A 和 B 都是无零整数
     * A + B = n
     *
     * @param n
     * @return
     */
    public int[] getNoZeroIntegers(int n) {

        //把n拆分为两个整数，且两个整数都属于无零整数
        int l = 0, r = n - 1;
        while (true) {
            //判定l,r是否为非0整数
            //r不是非0整数
            while (isZeroInteger(r)) {
                r--;
            }
            l = n - r;
            if (!isZeroInteger(l))
                break;
            r--;
        }
        return new int[]{l, r};
    }

    //判定第几位是0，如果是非0整数，返回-1

    private boolean isZeroInteger(int n) {
        if(n < 10) return false;
        while (n > 0) {
            int tmp = n % 10;
            //当前位为0
            if (tmp == 0) {
                break;
            }
            n /= 10;
        }
        return n > 0;
    }


}
