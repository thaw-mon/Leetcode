package July.day04;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：76. 最小覆盖子串
 * @题目描述： 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * @Date:19/7/4
 * @示例 1: 输入: S = "ADOBECODEBANC", T = "ABC"
 * ADOBEC  CODEBA BANC
 * 输出: "BANC"
 **/

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "axaba";
        String t = "ab";
        String res = new MinimumWindowSubstring().minWindow(s, t);
        System.out.println(res);
    }

    //思路和双指针差不多，但是写法有待优化
    public String minWindow(String s, String t) {
        String str = "";
        if (t.length() == 0) {
            return str;
        }
        //1. 把t转换为map
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!tMap.containsKey(c)) {
                tMap.put(c, 1);
            } else {
                int value = tMap.get(c);
                tMap.put(c, value + 1);
            }
        }
        //2. 找到s中符合条件的所有字串
        int n = s.length();
        Map<Character, Integer> sMap = new HashMap<>(tMap);
        //2-1 找到第一个符合条件的字串
        int start = -1, end = -1, i = 0;
        int size = sMap.size();
        for (; i < n; i++) {
            if (sMap.containsKey(s.charAt(i))) {
                if (start == -1) {
                    start = i;
                }
                int value = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), value - 1);
                if (value == 1)
                    size--;

            }
            //找到第一个匹配字串
            if (size == 0) {
                end = i;
                i++;
                break;
            }
        }

        int tmpStart = start;
        if (end != -1) {
            //增加一次去重，防止i==n时直接返回
            for (int j = tmpStart; j < i; j++) {
                Integer valueStart = sMap.get(s.charAt(j));
                if (valueStart != null) {
                    tmpStart = j;
                    if (valueStart == 0) {
                        break;
                    }
                    valueStart++;
                    sMap.put(s.charAt(j), valueStart);
                }
            }
            if (i - 1 - tmpStart < end - start) {
                start = tmpStart;
                end = i - 1;
            }
        }

        for (; i < n; i++) {
            Integer value = sMap.get(s.charAt(i));
            if (value != null) {
                //去重操作
                sMap.put(s.charAt(i), value - 1);
                if (sMap.get(s.charAt(tmpStart)) <= 0) {
                    //找到第二条符合条件字串
                    for (int j = tmpStart; j <= i; j++) {
                        Integer valueStart = sMap.get(s.charAt(j));
                        if (valueStart != null) {
                            tmpStart = j;
                            if (valueStart == 0) {
                                break;
                            }
                            valueStart++;
                            sMap.put(s.charAt(j), valueStart);
                        }
                    }
                    if (i - tmpStart < end - start) {
                        start = tmpStart;
                        end = i;
                    }
                }
            }
        }

        if (end != -1) {
            str = s.substring(start, end + 1);
        }
        return str;
    }

    //

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //滑动窗口法
    public String minWindow2(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one CombineTwoTables.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and co***act the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done co***acting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }


}
