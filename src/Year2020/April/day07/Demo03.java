package Year2020.April.day07;

public class Demo03 {


    /**
     * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {

        //从1开始获取第n个数字
        int loop = 9, bit = 1;
        //判定数字为几位的
        while (n - loop * bit > 0) {
            n -= loop * bit;
            loop *= 10;
            bit++;
        }
        //2 计算这个数是多少
        int index = n % bit;
        if (index == 0) //表示数字最后一位
            index = bit;
        long num = 1;
        for (int i = 1; i < bit; i++) {
            num *= 10;
        }
        num += (index == bit) ? n / bit - 1 : n / bit;
        //3 找到这个数的第几位是我们想要的
        for (int i = index; i < bit; i++)
            num /= 10;
        return (int) num % 10;
    }

    public static void main(String[] args){
        System.out.println(new Demo03().findNthDigit(1000));
    }
}
