package November.day01;

import java.util.*;

/**
 * @题目 ： 336. Palindrome Pairs
 * @Data 19/11/06
 * @题目描述： YGiven a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * @题目链接： 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * @示例1: ######
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * @示例2: ######
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * @示例3: ###
 */

public class PalindromePairs {

    public static void main(String[] args){
        String[] words = {"s",""};
        System.out.println(new PalindromePairs().palindromePairs2(words));
    }

    //找出可以构成回文序列的两个单词
    //way1 :暴力遍历法 勉强通过
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (isPalindrome(words[i], words[j])) {
                    List<Integer> oneAnswer = new ArrayList<>(2);
                    oneAnswer.add(i);
                    oneAnswer.add(j);
                    res.add(oneAnswer);
                }
            }
        }
        return res;
    }

    //判断两个字符 s1 + s2 是否可以构成回文序列
    private boolean isPalindrome(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len = len1 + len2;
        //从中间向两边进行判断
        int left = len / 2 - 1;
        int right = len % 2 == 0 ? left + 1 : left + 2;
        while (left >= 0 && right < len) {
            char c1 = left >= len1 ? s2.charAt(left - len1) : s1.charAt(left);
            char c2 = right >= len1 ? s2.charAt(right - len1) : s1.charAt(right);
            if (c1 != c2) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    //way2 : 分割字符进行判断:时间较少至 1 / 10，空间增加了20%
    public List<List<Integer>> palindromePairs2(String[] words) {
        Set<List<Integer>> res = new HashSet<>();
        int n = words.length;
        //1. 把words转换为map<String,Integer>
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            wordMap.put(words[i], i);
        }
        //防止出现 A + B 重复，res改为set
        for (int i = 0; i < n; i++) {
            for(int j=0;j<=words[i].length();j++){
                //words[i]的后缀为回文,且map中存在和前缀反转字符相同 words[i] = str1 + str2; str3 = wordMap.contain(str1.reverse)
                //ans = str1 + str2 + str3
                if(isPalindromeStr(words[i].substring(j)) && wordMap.containsKey(new StringBuilder(words[i].substring(0,j)).reverse().toString())){
                    //防止words本身是回文出现 i+i
                    if(wordMap.get(new StringBuilder(words[i].substring(0,j)).reverse().toString())!= i){
                        List<Integer> oneAnswer = new ArrayList<>(2);
                        oneAnswer.add(i);
                        oneAnswer.add(wordMap.get(new StringBuilder(words[i].substring(0,j)).reverse().toString()));
                        res.add(oneAnswer);
                    }

                }
                //words[i]的前缀为回文
                if(isPalindromeStr(words[i].substring(0,j)) && wordMap.containsKey(new StringBuilder(words[i].substring(j)).reverse().toString())){
                    //防止words本身是回文出现 i+i
                    if(wordMap.get(new StringBuilder(words[i].substring(j)).reverse().toString())!= i){
                        List<Integer> oneAnswer = new ArrayList<>(2);
                        oneAnswer.add(wordMap.get(new StringBuilder(words[i].substring(j)).reverse().toString()));
                        oneAnswer.add(i);
                        res.add(oneAnswer);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    //判断s是否为回文串
    private boolean isPalindromeStr(String s) {
        int len =s.length();
        if(len <= 1) return true;
        int left = 0,right =len-1;
        while (left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else
                return false;
        }
        return true;
    }
}
