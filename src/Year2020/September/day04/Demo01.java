package Year2020.September.day04;

public class Demo01 {

    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        if (c <= 2) return true;
        for (long i = 0; i * i <= c; i++) {
            int b = c - (int) (i * i);
            //判定b是否为平方数
            if (isSquare(b)) {
                return true;
            }
        }
        return false;
    }

    //判定是否为平方数 : 时间超时，需要二分搜索优化
    boolean isSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid > num) {
                right = (int) mid - 1;
            } else {
                left = (int) mid + 1;
            }
        }
        return false;
    }

    //思路2 费马定理: 一个非负整数 c能够表示为两个整数的平方和，当且仅当 c 的所有形如 4k+3 的质因子的幂次均为偶数
    public static void main(String[] args) {
        int num = 2147482647;
        System.out.println(new Demo01().judgeSquareSum(num));
    }
}
