package Year2019.July.day01;

import java.util.regex.Pattern;

/**
 * @题目 ：65. 有效数字
 * @题目描述： 验证给定的字符串是否可以解释为十进制数字。
 * 例如:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 * @Date:19/7/1
 **/
public class ValidNumber {

    public static void main(String[] args) {
        String s = "1.30e-3";
        System.out.println(new ValidNumber().isNumber(s));
    }

    //1. 提示使用自动机
    //特例：  true :   .0  -.0也是true  1.也是true
    public boolean isNumber(String s) {
        //去除开头和结尾的空格
        s = s.trim();
        //定义状态机
        int[][] d = {
                {1, 2, 3, -1, -1},
                {1, -1, 5, 4, -1},
                {1, -1, 3, -1, -1},
                {5, -1, -1, -1, -1},
                {6, 7, -1, -1, -1},
                {5, -1, -1, 4, -1},
                {6, -1, -1, -1, -1},
                {6, -1, -1, -1, -1}
        };
        int[] succ = {1, 5, 6};
        int start = 0;
        for (Character c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                start = d[start][0];
            } else if (c == '+' || c == '-') {
                start = d[start][1];
            } else if (c == '.') {
                start = d[start][2];
            } else if (c == 'e') {
                start = d[start][3];
            } else {
                start = d[start][4];
            }
            if (start == -1) {
                break;
            }
        }
        if (start == 1 || start == 5 || start == 6) {
            return true;
        } else {
            return false;
        }

    }


    //2. 使用Pattern构造模式
    public boolean isNumber2(String s) {
        String pattern = "^\\s*[+-]?(\\d+\\.?\\d*|\\.\\d+)(e[+-]?\\d+)?\\s*$";
        return Pattern.matches(pattern, s);
    }

}
