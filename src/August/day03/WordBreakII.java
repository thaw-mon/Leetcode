package August.day03;

import java.util.*;

/**
 * @题目 : 140. 单词拆分II
 * @Data: 19/8/08
 * @题目描述： 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * @说明： ####
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * @题目地址： https://leetcode-cn.com/problems/word-break-ii/
 * @示例1: ######
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * @示例2: ###
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * @示例3: ###
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 **/

public class WordBreakII {

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");

        System.out.println(new WordBreakII().wordBreak(s, wordDict));
    }

    //思路和上一题差不多，直接使用dfs策略
    // 当面临大量重复字母时，结果产生超时
    private List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);

        DFS(s, wordDictSet, 0, new StringBuilder());
        return res;
    }


    public void DFS(String s, Set<String> wordDictSet, int start, StringBuilder ans) {
        //匹配成功字符串
        if (start == s.length()) {
            res.add(ans.toString());
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDictSet.contains(s.substring(start, i))) {
                int len = ans.length();
                if (len == 0)
                    ans.append(s, start, i);
                else
                    ans.append(" ").append(s, start, i);

                DFS(s, wordDictSet, i, ans);
                ans.delete(len, ans.length());
            }
        }

    }

    //由于dfs中存在大量的子问题重复计算，因此采用map记录下来，优化时间
//   作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/dan-ci-chai-fen-ii-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        return word_Break(s, wordDictSet, 0);
    }

    private Map<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }


    //前面复用写法
    public List<String> wordBreak3(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        if(wordBreak_check(s,wordDict)){
            add(list, wordList, s, wordDict);
        }
        return list;
    }
    private void add(List<String> list,List<String> wordList,String s,List<String> wordDict){
        for(String str : wordDict){
            if(s.startsWith(str)){
                if(s.length() == str.length()){
                    StringBuilder b = new StringBuilder();
                    for(String word : wordList){
                        b.append(word).append(" ");
                    }
                    b.append(str);
                    list.add(b.toString());
                }else{
                    wordList.add(str);
                    add(list, wordList, s.substring(str.length()), wordDict);
                    wordList.remove(wordList.size()-1);
                }
            }
        }
    }

    public boolean wordBreak_check(String s, List<String> wordDict) {
        int maxWordLength = 0;//字典中单词最长长度
        for(int i=0;i<wordDict.size();i++){
            maxWordLength = Math.max(maxWordLength,wordDict.get(i).length());
        }
        boolean[] dp = new boolean [s.length()+1];
        dp[0] = true;
        for(int i=1;i<s.length()+1;i++){
            int x = i-maxWordLength>0?i-maxWordLength:0;
            for(int j=x;j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){//s存在以第j位为末尾的单词并且截取第j到i位的单词存在于字典中
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
