package Year2020.November.day07;

import sun.jvm.hotspot.tools.soql.SOQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo06 {
    /**
     * 在命令行输入如下命令：
     * xcopy /s c:\ d:\，
     * 各个参数如下：
     * 参数1：命令字xcopy
     * 参数2：字符串/s
     * 参数3：字符串c:\
     * 参数4: 字符串d:\
     * <p>
     * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
     */
    public static void main(String[] args) {
//        System.out.println("xxxasa".indexOf(' '));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            List<String> result = parseParam(s);
            System.out.println(result.size());
            for(String str : result){
                System.out.println(str);
            }
        }
    }

    public static List<String> parseParam(String str) {
        str = str.trim(); //去除头部和尾部的空格
        List<String> ret = new ArrayList<>();
        int N = str.length();
        int index = 0;
        while (index < N) {
            char c = str.charAt(index);
            if (c == '"') {
                int next = str.indexOf('"', index + 1);
                ret.add(str.substring(index + 1, next));
                index = next + 1;
            } else if (c == ' ') {
                //  continue;
                index++;
            } else {
                int next = str.indexOf(' ', index);
                if (next == -1) next = N;
                ret.add(str.substring(index, next));
                index = next + 1;
            }
        }
        return ret;
    }
}
