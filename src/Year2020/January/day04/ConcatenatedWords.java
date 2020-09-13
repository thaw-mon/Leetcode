package Year2020.January.day04;

import java.util.*;

/**
 * @题目 ： 472. Concatenated Words
 * @Data 20/01/11
 * @题目描述： Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * @题目链接： 链接：https://leetcode-cn.com/problems/concatenated-words
 * @示例1: ######
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * <p>
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * <p>
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * @示例2: ######
 * @示例3: ###
 */

public class ConcatenatedWords {
    class Trie {
        public Boolean isEnd; //判断是否为单词的结尾
        public Trie[] next;

        Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        void insert(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (root.next[c - 'a'] == null) root.next[c - 'a'] = new Trie();
                root = root.next[c - 'a'];
            }
            root.isEnd = true;
        }

        boolean search(String word, int index, int count) {
            Trie root = this;   //每次从根节点开始寻找
            for (int i = index; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (root.next[c - 'a'] == null) return false;//word的某个字符不在前缀树中
                root = root.next[c - 'a'];
                if (root.isEnd) {//到达某个单词尾
                    if (i == word.length() - 1) return count >= 1;//count的数量至少为2个，若遍历到最后只有一个单词，则count的值还是为0
                    //已前count位的单词作为分解词继续匹配下一个单词,下个单词满足count才能返回ture,否则继续寻找下一个分界单词
                    if (search(word, i + 1, count + 1)) return true;
                }
            }
            return false;
        }

    }

    //判断单词是否为连接词：即为完全由其他单词组成。
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();

        if (words.length == 0)
            return res;
        //1.把word转换为map(可以构建字典树)
        Trie root = new Trie();
        for (String s : words) {
            if (!s.isEmpty()) //防止输入空串
                root.insert(s);
        }
        //2.一个个进行查询
        for (String word : words) {
            if(root.search(word, 0, 0))
                res.add(word);
        }

        return res;
    }

}
