package Year2020.November.day06;

import java.util.*;

public class Demo04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(getMaxCommonSubStr(a, b));
        }
    }

    /**
     * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
     */

    public static String getMaxCommonSubStr(String a, String b) {
        if (a.length() > b.length()) {
            return getMaxCommonSubStr(b, a);
        }
        //a < b
        int n1 = a.length(), n2 = b.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            char c = b.charAt(i);
            if (!map.containsKey(c)) map.put(c, new ArrayList<>());
            map.get(c).add(i);
        }
        int index = 0, maxLen = 0, currentLen = 0;
        for (int i = 0; i < n1; i++) {
            char c = a.charAt(i);
            List<Integer> list = map.getOrDefault(c, null);
            if (list == null) continue;
            for (int start : list) {
                int j = i;
                for (; j < n1 && start < n2; start++, j++) {
                    if (a.charAt(j) != b.charAt(start)) {
                        break;
                    }
                }
                currentLen = j - i;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    index = i;
                }
            }
        }
        return a.substring(index, index + maxLen);
    }
}
