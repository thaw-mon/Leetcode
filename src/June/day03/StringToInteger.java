package June.day03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Data 19/5/31
 * @题目描述： 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 注意： 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * @示例： 1_exp
 * 输入: "42"
 * 输出: 42
 * @示例： 2_exp
 * 输入: "   -42"   "4193 with words"  "words and 987"  "-91283472332"
 * 输出:      -42         4193              0             -2147483648
 * 注意： 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class StringToInteger {

    public static void main(String[] args) {
        String res = "  xx211 ";
        System.out.println(new StringToInteger().myAtoi2(res));

    }

    //可能出错点
    // 1. 空串 或只有空字符的串
    // 2. 包含+符号未考虑
    // 3. 负数 -2147483648
    public int myAtoi(String str) {
        int index = 0;
        Boolean isNegativeNum = false;
        //找到第一个非空字符
        char[] array = str.toCharArray();
        for (char c : array) {
            if (c != ' ')
                break;
            index++;
        }
        if (index == array.length) {
            return 0;
        }
        if (array[index] == '-' || array[index] == '+') {
            if (array[index] == '-') {
                isNegativeNum = true;
            }
            index++;
        }

        int endIndex = index;   // [index,endIndex)
        for (int i = index; i < array.length; i++) {
            if (array[i] < '0' || array[i] > '9') {
                break;
            }
            endIndex++;
        }
        //没有找到num
        if (endIndex == index) {
            return 0;
        }
        int res = 0;

        while (index != endIndex) {
            int temp = 0;
            if (isNegativeNum) {
                temp -= array[index] - '0';
            } else {
                temp += array[index] - '0';
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) return Integer.MAX_VALUE;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) return Integer.MIN_VALUE;
            res = res * 10 + temp;
            index++;
        }
        return res;
    }

    //没有标准答案 ，学习一下大佬的正则方式
    public int myAtoi2(String str) {
        str = str.trim();

        String pattern = "^[\\+\\-\\d]\\d*";//正则表达式，表示以正号或负号或数字开头，且后面是0个或多个数字
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);

        String res = "";
        if (m.find()) {//能匹配到
            res = str.substring(m.start(), m.end());
        } else {//不能匹配到
            return 0;
        }

        //能匹配到但只有一个+-号，也返回0
        if (res.length() == 1 && (res.charAt(0) == '+' || res.charAt(0) == '-')) {
            return 0;
        }

        try {
            int r = Integer.parseInt(res);
            return r;
        } catch (Exception e) {
            return res.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }


}
