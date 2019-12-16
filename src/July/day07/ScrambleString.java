package July.day07;

import java.util.Arrays;

/**
 * @题目 ：87. 扰乱字符串
 * @题目描述： 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * 同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，将会产生另一个新的扰乱字符串 "rgtae" 。
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * @Date:19/7/9
 * @示例 1: 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * @示例 2: 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 **/
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;

        //1. 判断s1和s2字符是否相等  --> 不相等直接为false
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!String.valueOf(c1).equals(String.valueOf(c2)))
            return false;
        //递归判断
        for (int i = 1; i < s1.length(); i++) {
            String left1 = s1.substring(0, i);
            String right1 = s1.substring(i);
            String left2 = s2.substring(0, i);
            String right2 = s2.substring(i);
            if (isScramble(left1, left2) && isScramble(right1, right2))
                return true;
            //在该层扰乱
            left2 = s2.substring(s1.length() - i);
            right2 = s2.substring(0, s1.length() - i);
            if (isScramble(left1, left2) && isScramble(right1, right2))
                return true;
        }
        return false;
    }
    //动态规划解法
//    我们用 dp [ len ][ i ] [ j ] 来表示 s1[ i, i + len ) 和 s2 [ j, j + len ) 两个字符串是否满足条件
//    作者：windliang
//    链接：https://leetcode-cn.com/problems/two-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean isScramble4(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        int length = s1.length();
        boolean[][][] dp = new boolean[length + 1][length][length];
        //遍历所有的字符串长度
        for (int len = 1; len <= length; len++) {
            //S1 开始的地方
            for (int i = 0; i + len <= length; i++) {
                //S2 开始的地方
                for (int j = 0; j + len <= length; j++) {
                    //长度是 1 无需切割
                    if (len == 1) {
                        dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        //遍历切割后的左半部分长度
                        for (int q = 1; q < len; q++) {
                            dp[len][i][j] = dp[q][i][j] && dp[len - q][i + q][j + q]
                                    || dp[q][i][j + len - q] && dp[len - q][i + q][j];
                            //如果当前是 true 就 break，防止被覆盖为 false
                            if (dp[len][i][j]) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[length][0][0];
    }


}
