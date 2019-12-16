package July.day08;

/**
 * @题目 ：91. 解码方法
 * @题目描述： 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * @Date: 19/7/10
 * @示例 1: 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * @示例 2: 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 **/
public class DecodeWays {

    public static void main(String[] args) {
        String s = "123400";
        System.out.println(new DecodeWays().numDecodings5(s));
    }

    //明显的动态规划 : 判断写的很麻烦
    //dp[n] = dp[n-1]+ if(s[-2] < 26 )dp[n-2]
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (n == 1) return s.charAt(0) == '0' ? 0 : 1;

        int[] dp = new int[3];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        if (dp[0] == 0)
            return 0;
        if (s.charAt(1) == 0) {
            if (s.charAt(0) <= 2)
                dp[1] = 1;
        } else {
            dp[1] = 1;
            if (s.charAt(1) - '0' + (s.charAt(0) - '0') * 10 <= 26)
                dp[1]++;
        }
        if (dp[1] == 0)
            return 0;
        dp[2] = dp[1];
        for (int i = 2; i < n; i++) {
            int num = s.charAt(i) - '0';
            if (num == 0) {
                num += (s.charAt(i - 1) - '0') * 10;
                if (num > 20 || num == 0)
                    return 0;
                dp[2] = dp[0];
            } else {
                num += (s.charAt(i - 1) - '0') * 10;
                if (num <= 26 && num > 10)
                    dp[2] += dp[0];
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }

//    作者：windliang
//    链接：https://leetcode-cn.com/problems/two-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int numDecodings5(String s) {
        int len = s.length();
        int end = 1;
        int cur = 0;
        if (s.charAt(len - 1) != '0') {
            cur = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                end = cur;//end 前移
                cur = 0;
                continue;
            }
            int ans1 = cur;
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = end;
            }
            end = cur; //end 前移
            cur = ans1 + ans2;

        }
        return cur;
    }

}
