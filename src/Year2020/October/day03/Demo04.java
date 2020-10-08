package Year2020.October.day03;

import java.util.regex.Pattern;

public class Demo04 {

    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * Q : 001这种算不算？ 1.2e3算不算？
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        int type = 0; //0 整数，1小数， 2指数
        boolean flag = true;
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c == '.') {
                //判断之前是否为整数 且 i > 0
                if (i > 0 && type == 0) {
                    type = 1;
                } else
                    flag = false;
            } else if (c == '+' || c == '-') {
                if (i + 1 < str.length && (i == 0 || (type == 2 && (str[i - 1] == 'e' || str[i - 1] == 'E')))) {
                    continue;
                }
                flag = false;
            } else if (c == 'e' || c == 'E') {
                if (i > 0 && type < 2 && isNumber(str[i - 1]) && i + 1 < str.length) {
                    type = 2;
                } else
                    flag = false;
            } else if (isNumber(c)) {
                continue;
            } else
                flag = false;
            if (!flag) break;
        }
        return flag;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    //使用正则写法
    public static boolean isNumeric2(char[] str) {
        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern,s);
    }
    public static void main(String[] args) {
        System.out.println(new Demo04().isNumeric("+12.45E+1.".toCharArray()));
    }
}
