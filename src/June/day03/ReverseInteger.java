package June.day03;

/**
 * @Data 19/5/31
 * @题目描述： 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @示例： 1_exp
 * 输入: 123
 * 输出: 321
 * @示例： 2_exp
 * 输入: -123  120
 * 输出: -321  21
 * 注意： 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(x);
        System.out.println(reverse(x));
//        System.out.println(reverse2(-12));

    }

    public static int reverse(int x) {
        if(x==-2147483648)
            return 0;
        if(x < 0)
            return -reverse(-x);
        String s = String.valueOf(x);
        String reverseRes = new StringBuilder(s).reverse().toString();
        int res;
        try {
            res = Integer.parseInt(reverseRes);
        }catch (Exception e){
            res = 0;
        }
        return res;

    }

    //标准答案，采用 弹出和推入数字 & 溢出前进行检查
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
