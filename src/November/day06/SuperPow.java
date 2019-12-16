package November.day06;

/**
 * @题目 ： 372. Super Pow
 * @Data 19/11/15
 * @题目描述： Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * @题目链接： 链接：https://leetcode-cn.com/problems/super-pow
 * @示例1: ######
 * Input: a = 2, b = [3]
 * Output: 8
 * @示例2: ######
 * Input: a = 2, b = [1,0]
 * Output: 1024
 * @示例3: ###
 */

public class SuperPow {
    //a^b mod 1337:显然不能直接求次方，必然会溢出
    //数学中有个欧拉公式：
//    作者：SHU_YKC
//    链接：https://leetcode-cn.com/problems/super-pow/solution/jiang-mi-gong-shi-kuai-su-mi-shi-jian-fu-za-du-gan/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int superPow(int a, int[] b) {
        int c = ol(1337);
        int sum = 0;
        for (int i = 0; i < b.length; i++)
            sum = (sum * 10 + b[i]) % c;
        sum += c;
        return q((long) a, sum, 1337);
    }

    private int q(long x, int y, int M) {
        long res = 1;
        while (y > 0) {
            if (y % 2 > 0)
                res = res % M * x % M;
            x = x % M * x % M;
            y /= 2;
        }
        return (int) res;
    }

    private int ol(int x) {
        int res = x;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                res = res - res / i;
                while (x % i == 0)
                    x /= i;
            }
        }
        if (x > 1) res = res - res / x;
        return res;
    }


}
