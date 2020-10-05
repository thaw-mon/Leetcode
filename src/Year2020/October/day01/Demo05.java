package Year2020.October.day01;

public class Demo05 {

    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     *
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n) {
        int len = str.length();
        //add 增加判断防止len == 0
        if (len == 0) return str;
        n %= len; //防止出现n > len重复移动的操作
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(n));
        sb.append(str, 0, n);
        return sb.toString();

    }
}
