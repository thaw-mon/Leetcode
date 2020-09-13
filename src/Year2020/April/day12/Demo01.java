package Year2020.April.day12;

public class Demo01 {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean flag = false; //标识位
        if (x < 0) {
            x = -x;
            flag = true;
        }
        long ret = 0;
        while (x > 0) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        //判定是否会溢出了
        if (flag)
            ret = -ret;
        if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)
            ret = 0;
        return (int) ret;
    }
}
