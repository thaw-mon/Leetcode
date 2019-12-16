package June.day04;


/**
 * @Data 19/6/3
 * @题目描述： 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 说明：
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * @示例： 输入:
 * s = "aa"     s = "aa"  "ab"  "aab"    "mississippi"
 * p = "a"      p = "a*"  ".*"  "c*a*b"  "mis*is*p*."
 * 输出: false   true     true   true    false
 * <p>
 * 思路：对于*类型数据进行堆栈处理
 * 注意，
 * eg aab == c*a*b true 因为 c可以为0个
 * 最开始理解为 c* == c(c...)括号内的c可以为0个，也就是说c至少存在一个
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aaab";
        String p = "a*a*a*ab";  //.*c*d  //.*bccd
        System.out.println(new RegularExpressionMatching().isMatch2(s, p));
        System.out.println(new RegularExpressionMatching().isMatch2_C(s, p));

    }

    //
    public boolean isMatch(String s, String p) {

        return true;
    }

    //官方标准答案1 ：递归思路 比较好理解
    //如果存在*号，它必然在第二个位置==> 匹配方法 1.pattern消除前两个字符X* 匹配  2.第一个字母匹配 消除text的第一个字符继续匹配
    // 不存在*号，直接消除 text，pattern的第一个字符继续匹配
    public boolean isMatch2(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch2(text, pattern.substring(2)) ||
                    (first_match && isMatch2(text.substring(1), pattern)));
        } else {
            return first_match && isMatch2(text.substring(1), pattern.substring(1));
        }
    }

    //改一下题目 * 代表至少存在一个前面的那一个元素
    public boolean isMatch2_C(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (first_match && (isMatch2_C(text.substring(1), pattern.substring(2)) || isMatch2_C(text.substring(1), pattern)));
        } else {
            return first_match && isMatch2_C(text.substring(1), pattern.substring(1));
        }
    }

    //官方标准答案2 ：动态规划思路
    enum Result {
        TRUE, FALSE
    }

    Result[][] memo;


    public boolean isMatch_3(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    //自顶向下的方法
    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (dp(i, j + 2, text, pattern) ||
                        first_match && dp(i + 1, j, text, pattern));
            } else {
                ans = first_match && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    //自底向上的方法
    //这个方法时间和空间比递归优化
    public boolean isMatch_4(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
