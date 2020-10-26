package Year2020.October.day11;

import java.util.Scanner;

public class Demo07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo07 demo07 = new Demo07();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (demo07.isValidPassWd(s)) {
                System.out.println("OK");
            } else
                System.out.println("NG");
        }

    }

    /**
     * 密码要求:
     * 1.长度超过8位
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * 3.不能有相同长度大于2的子串重复
     */
    public boolean isValidPassWd(String str) {
        //1.长度判定
        if (str.length() <= 8) return false;
        //2.类型判定
        int[] types = new int[4];
        int N = str.length();
        for (int i = 0; i < N; i++) {
            //1.获取当前字符类型
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                types[0]++;
            } else if (c >= 'a' && c <= 'z') {
                types[1]++;
            } else if (c >= '0' && c <= '9') {
                types[2]++;
            } else {
                types[3]++;
            }
            //2.判定子串是否存在
            if (i + 3 < N) {
                boolean ret = str.substring(i + 3).contains(str.substring(i, i + 3));
                if (ret) {
                    return false;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (types[i] > 0) cnt++;
        }
        return cnt >= 3;
    }
}
