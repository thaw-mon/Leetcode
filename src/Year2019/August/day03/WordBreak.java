package Year2019.August.day03;

import java.util.*;

/**
 * @题目 : 139. 单词拆分
 * @Data: 19/8/08
 * @题目描述： 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * @说明： ####
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * @题目地址： https://leetcode-cn.com/problems/word-break/
 * @示例1: ######
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * @示例2: ###
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * @示例3: ###
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 **/

public class WordBreak {

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    //尽管通过了，但是效率太低了
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //dp[i][j] = true if s.subString(i,j) in wordDict
        //dp[i][j] = dp[i][k] && dp[k][j]
        //return dp[0][n];
        int[][] dp = new int[n + 1][n + 1]; //默认为false
        helper(s, wordDict, dp, 0, n);
        return dp[0][n] == 1;
    }

    private void helper(String s, List<String> wordDict, int[][] dp, int start, int end) {
        //空串为1
        if (start == end) {
            dp[start][end] = 1;
            return;
        }
        //符合条件的字串
        if (wordDict.contains(s.substring(start, end)) || dp[start][end] == 1) {
            dp[start][end] = 1;
            return;
        }
        //不符合直接条件的字串
        dp[start][end] = -1;

        //寻找是否存在word组合匹配
        for (int i = start + 1; i <= end; i++) {
            if (dp[start][i] == 0)
                helper(s, wordDict, dp, start, i);
            if (dp[i][end] == 0)
                helper(s, wordDict, dp, i, end);

            if (dp[start][i] == 1 && dp[i][end] == 1) {
                dp[start][end] = 1;
                break;
            }
        }

    }

    //动态规划 ： 优化为一维数组
    //TODO 优化方法 把wordDict转换为set
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();

        //dp[i]表示前i个字符是否可以匹配
        //dp[i] = dp[k] + s.subString(k,i+1)
        boolean[] dp = new boolean[n + 1]; //默认为false
        dp[0] = true;
        //O(N^2)
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    //有意思的宽度优先策略
//     作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/dan-ci-chai-fen-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }



}
