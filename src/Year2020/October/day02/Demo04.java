package Year2020.October.day02;

public class Demo04 {

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1, int num2) {
        //不能使用+ -法，那么只能使用& | ~
        //only正数加法
        int bitCarry = 0;
        int answer = 0, bit = 0;
        while (Math.abs(num1) > 0 || Math.abs(num2) > 0) {
            int bit1 = num1 & 0x01;
            int bit2 = num2 & 0x01;
            int bitAnswer = bit1 ^ bit2;
            if (bitCarry > 0)
                bitAnswer = bitAnswer ^ bitCarry;
            if (bitCarry == 1 && bitAnswer == 0) {
                bitCarry = 1;
            } else
                bitCarry = 0;
            if (bit1 == 1 && bit2 == 1) {
                bitCarry = 1;
            }
            answer |= (bitAnswer << bit);
            bit++;
            num1 >>>= 1;
            num2 >>>= 1;
        }
        if (((long) bitCarry << bit) < Integer.MAX_VALUE)
            answer |= (bitCarry << bit);
        return answer;
    }

    // 11111 00010 ==>  1 00001
    //only正数减法
    public int sub(int num1, int num2) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Demo04().Add(0, -2));
    }
}
