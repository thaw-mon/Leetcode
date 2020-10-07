package Year2020.October.day02;

public class Demo05 {

    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
     * 注意开头符号可能为+/-
     *
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        int n = str.length();
        if (n == 0) return 0;
        //1.判断正负数
        boolean flag = true; //指示value为正负值
        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            flag = str.charAt(0) == '+';
            i++;
        }
        if (i == n) return 0; //防止出现只有一个符号的情形
        int ret = 0;
        for (; i < n; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') return 0; //非法字符直接返回
            ret *= 10;
            ret += (c - '0');
        }
        if (!flag) ret = -ret;
        return ret;
    }
}
