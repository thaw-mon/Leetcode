package June.day02;

/**
 * @Data 19/5/30
 * @题目描述： 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * @示例： 1_exp
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * @示例： 2_exp
 * 输入: "cbbd"  abcba  caba
 * 输出: "bb"  abcba   aba
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";

//        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome2(s));
    }

    //1. 暴力搜索法
    //超时了
    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] arrays = s.toCharArray();
        int resIndex = 0;
        int resLen = 1;
        for (int i = 0; i < arrays.length; i++) {
            int index = i;
            while (index != -1) {
//                int preindex = index;
                index = s.indexOf(arrays[i], index + 1);
                // s.substring(preindex,index);
                if (index != -1 && isPalindrome(s, i, index)) {
                    int len = index - i + 1;
                    if (len > resLen) {
                        resIndex = i;
                        resLen = len;
                    }
                }
            }
        }
        return s.substring(resIndex, resIndex + resLen);
    }

    public static boolean isPalindrome(String s, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    //动态规划策略
    public static String longestPalindrome2(String s) {
        int n = s.length();
        if (n == 0)
            return s;
        //定义数组
        //P(i,j)=(P(i+1,j−1) and S[i]==S[j]
        int fromIndex = 0;
        int endIndex = 0;
        int[][] map = new int[n][n];
        //初始化为1字母类型，全为true
        //初始化为2字母类型
        for (int i = 0; i < n; i++) {
            map[i][i] = 1;
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                map[i][i + 1] = 1;
                endIndex = i + 1;
                fromIndex = i;
            }
        }

        //循环要是从字母3到字母4  。。。。。
        for (int j = 2; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                if (map[i + 1][i + j - 1] == 1 && s.charAt(i) == s.charAt(i + j)) {
                    map[i][i + j] = 1;
                    if (j > endIndex - fromIndex) {
                        endIndex = j + i;
                        fromIndex = i;
                    }
                }
            }
        }
        return s.substring(fromIndex, endIndex + 1);
    }

    //标准答案
    //中心镜像法  66666666
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
