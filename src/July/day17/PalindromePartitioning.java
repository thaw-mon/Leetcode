package July.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：131. 分割回文串
 * @Data: 19/7/31
 * @题目描述： 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * @示例1: ######
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * @示例2: ###
 **/

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "AA";
        System.out.println(new PalindromePartitioning().partition(s));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        if(n==0) return res;
        boolean[][] dp = new boolean[n][n];
        //j表示间隔  i表示起始位置
        for (int j = 0; j < n; j++)
            for (int i = 0; i + j < n; i++) {
                //间隔为0 dp[i][i] 类型
                if (j == 0)
                    dp[i][i + j] = true;
                else if (j == 1)
                    dp[i][i + j] = s.charAt(i) == s.charAt(i + j);
                else
                    dp[i][i + j] = s.charAt(i) == s.charAt(i + j) && dp[i + 1][i + j - 1];

            }
        res = getPalindrome(s, 0, n, dp);

        return res;
    }

    //如果s是回文串，那么s的subString(0+i,n-i) 必然是回文
    //左闭右开区间[left,right)
    //找到最长的回文串，然后递归就好了
    // s="aab" res = [[a, a, b], [aa, b], [a, a, b]] 结果中产生了重复的list
    //解决办法：原来是对左右都进行分割，现在只对一侧进行分割
    //TODO 优化策略：空间换时间 -->将 S[left,right)产生的List保存在Map中
    private List<List<String>> getPalindrome(String s, int left, int right, boolean[][] dp) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        if (left >= right)
            return res;

        //判断字串是否为回文串
        if (dp[left][right - 1]) {
            ans.add(s.substring(left, right));
            res.add(new ArrayList<>(ans));
        }
        for (int i = left + 1; i < right; i++) {
//            List<List<String>> leftPalindrome = getPalindrome(s, left, i, dp);
            //左半部分属于回文序列
            if (dp[left][i-1]) {
                List<List<String>> rightPalindrome = getPalindrome(s, i, right, dp);
                for (List<String> rightList : rightPalindrome) {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(s.substring(left, i));
                    tmp.addAll(rightList);
                    res.add(tmp);
                }
            }
        }
        return res;
    }

}
