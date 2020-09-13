package Year2020.March.day04;

import java.util.*;

public class Demo02 {

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] words = {"cat", "cats", "and", "sand", "dog"};
        System.out.println(new Demo02().wordBreak(s, Arrays.asList(words)));
    }

    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
     * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
     * 返回所有这些可能的句子。
     *
     * @param s        给一个非空字符串
     * @param wordDict 一个包含非空单词列表的字典
     * @return 返回所有这些可能的句子。
     */
    //TODO 结果超时了：需要使用记忆法进行保存递归结果
    public List<String> wordBreak(String s, List<String> wordDict) {

        Map<Character, Set<Integer>> firstWordLen = new HashMap<>();
        for (String word : wordDict) {
            char tmp = word.charAt(0);
            if (!firstWordLen.containsKey(tmp)) {
                firstWordLen.put(tmp, new HashSet<>());
            }
            firstWordLen.get(tmp).add(word.length());
        }
        helper(s, 0, wordDict, firstWordLen, new StringBuffer());
        return ret;
    }

    List<String> ret = new ArrayList<>();

    public void helper(String s, int start, List<String> wordDict, Map<Character, Set<Integer>> firstWordLen, StringBuffer sb) {
        //完全匹配的结果
        if (start == s.length()) {
            sb.deleteCharAt(sb.length() - 1); //删除最后多出的空格
            ret.add(sb.toString());
            return;
        }

        char c = s.charAt(start);
        if (!firstWordLen.containsKey(c)) {
            return;
        }
        Set<Integer> set = firstWordLen.get(c);
        //多种可能
        for (Integer i : set) {
            if (start + i > s.length()) break;
            String str = s.substring(start, start + i);
            if (wordDict.contains(str)) {
                int index = sb.length();
                sb.append(str).append(" ");
                helper(s, start + i, wordDict, firstWordLen, sb);
                sb.delete(index, sb.length());
            }
        }
    }


//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/word-break-ii/solution/dan-ci-chai-fen-ii-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<String> wordBreak(String s, Set<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }


}
