package Year2020.February.day02;

public class Demo01 {

    /**
     * @param s 输入字符串 A:1 Z:26 AA 27 AB:28
     * @return 输入字符串代表的数字
     * @title 给定一个Excel表格中的列名称，返回其相应的列序号。
     */
    public int titleToNumber(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 'A' + 1;
            ret *= 26;
            ret += tmp;
        }
        return ret;
    }
}
