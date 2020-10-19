package Year2020.October.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo01 {

    /**
     * 连续输入字符串(输入2次,每个字符串长度小于100)
     * 输出到长度为8的新字符串数组
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo01 demo01 = new Demo01();
        while (scanner.hasNext()) {
            String str = scanner.next();
            List<String> ret = demo01.spiltString(str);
            for (String s : ret) {
                System.out.println(s);
            }
        }
    }

    /**
     * @Title : 字符串分割
     * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     */
    public List<String> spiltString(String str) {
        List<String> ret = new ArrayList<>();
        if (str.isEmpty()) return ret;

        int n = str.length();
        for (int i = 0; i < n; i += 8) {
            if (i + 8 <= n)
                ret.add(str.substring(i, i + 8));
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(i));
                for (int k = sb.length(); k < 8; k++) {
                    sb.append(0);
                }
                ret.add(sb.toString());
            }
        }

        return ret;
    }
}
