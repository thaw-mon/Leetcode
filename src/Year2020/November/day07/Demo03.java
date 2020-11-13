package Year2020.November.day07;

import java.util.Scanner;

public class Demo03 {

    /**
     * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
     * 要求：
     * 实现如下2个通配符：
     * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
     * ？：匹配1个字符
     * 思路 ： 字符匹配问题， 递归解决
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String A = scanner.next();
            String B = scanner.next();
            boolean ret = dp(A, B);
            System.out.println(ret);
            ;
        }
    }

    /**
     * @param origin : 带有通配符的字符串
     * @param target ： 需要匹配的字符串
     * @return
     */
    public static boolean dp(String origin, String target) {
        if (target.isEmpty()) {
            return origin.isEmpty() || origin.matches("\\**");
        }
        if (origin.isEmpty()) return false;
        char o = origin.charAt(0);
        if (o == '?') {
            return dp(origin.substring(1), target.substring(1));
        } else if (o == '*') {
            for (int i = 0; i <= target.length(); i++) {
                if (dp(origin.substring(1), target.substring(i))) {
                    return true;
                }
            }
        } else {
            char t = target.charAt(0);
            if (o == t) {
                return dp(origin.substring(1), target.substring(1));
            }
        }
        return false;
    }
}
