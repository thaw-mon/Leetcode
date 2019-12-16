package October.day05;

/**
 * @题目 ： 306. Additive Number
 * @Data 19/10/11
 * @题目描述： Additive number is a string whose digits can form additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * @题目地址： 链接：https://leetcode-cn.com/problems/additive-number
 * @示例1: ######
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * @示例2: ######
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199. 
 *              1 + 99 = 100, 99 + 100 = 199
 * @示例3: ###
 */

public class AdditiveNumber {
    public static void main(String[] args) {
        String s = "101";
        System.out.println(new AdditiveNumber().isAdditiveNumber(s));
    }

    //转换为整数时，当长度太大时无法转换
    //注意 101 为true 1 + 0 = 1
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n; i++) {
            if (num.charAt(i) == '0') {
                String preNum = num.substring(0, i);
                String currentNum = "0";
                int length = preNum.length();
                if (i + 1 + length <= num.length() && num.substring(i + 1, i + 1 + length).equals(preNum)) {
                    if (helper(num.substring(i + 1 + length), currentNum, preNum)) {
                        return true;
                    }
                }
                continue;
            }
            for (int j = i + 1; j <= n; j++) {
                String preNum = num.substring(0, i);
                String currentNum = num.substring(i, j);
                String nextNum = addString(preNum, currentNum);
                int length = nextNum.length();
                if (j + length <= num.length() && num.substring(j, j + length).equals(nextNum)) {
                    if (helper(num.substring(j + length), currentNum, nextNum)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean helper(String num, String preNum, String currentNum) {
        if (num.isEmpty()) return true;
        String nextNum = addString(preNum, currentNum);
        int length = nextNum.length();
        //下一个数字字符匹配
        if (num.length() >= length && num.substring(0, length).equals(nextNum)) {
            return helper(num.substring(length), currentNum, nextNum);
        }
        return false;
    }

    //直接对String做加法操作
    private String addString(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int n = Math.max(n1, n2);
        StringBuilder sb = new StringBuilder();
        int carryBit = 0;
        for (int i = 0; i < n; i++) {
            int c = 0;
            if (n1 - i - 1 >= 0) {
                c += num1.charAt(n1 - i - 1) - '0';
            }
            if (n2 - 1 - i >= 0) {
                c += num2.charAt(n2 - 1 - i) - '0';
            }
            c += carryBit;
            carryBit = c / 10;
            c %= 10;
            sb.append(c);
        }
        if (carryBit == 1) sb.append(1);

        return sb.reverse().toString();
    }
}
