package Year2020.September.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo02 {

    /**
     * 你将得到一个字符串数组 A。
     * 每次移动都可以交换 S 的任意两个偶数下标的字符或任意两个奇数下标的字符。
     * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是 特殊等价 的。
     *
     * @param A
     * @return
     */
    public int numSpecialEquivGroups(String[] A) {
        List<String> stringGroup = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            boolean flag = true;
            for (String str : stringGroup) {
                if (isSpecialEqual(A[i], str)) {
                    flag = false;
                    break;
                }
            }
            if (flag) stringGroup.add(A[i]);
        }
        return stringGroup.size();
    }

    //1.判定两个字符串是否为特殊等价
    public boolean isSpecialEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false; //长度不等
        //1.获取奇数索引所有字符
        int[] wordNum = new int[26];
        int n = s1.length();
        for (int i = 1; i < n; i += 2) {
            wordNum[s1.charAt(i) - 'a']++;
            wordNum[s2.charAt(i) - 'a']--;
        }
        //判定wordNum是否全部为0
        for (int i = 0; i < 26; i++) {
            if (wordNum[i] != 0) return false;
        }
        //2.获取偶数索引所有字符
        for (int i = 0; i < n; i += 2) {
            wordNum[s1.charAt(i) - 'a']++;
            wordNum[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (wordNum[i] != 0) return false;
        }
        return true;
    }
}
