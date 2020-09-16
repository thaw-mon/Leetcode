package Year2020.September.day09;

public class Demo03 {

    /**
     * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        //补码等于正数的源码取反加1
        int count = 0;
        while (n != 0) {
            if ((n & 0x01) == 1) count++;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Demo03().NumberOf1(-1));
    }
}
