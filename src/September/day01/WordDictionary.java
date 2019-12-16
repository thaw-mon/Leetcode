package September.day01;

/**
 * @题目 ： 211. Add and Search Word - Data structure design
 * @Data 19/9/02
 * @题目描述： Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * @题目地址： 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * @示例1: ######
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * @示例2: ###
 * @示例3: ###
 */

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary demo = new WordDictionary();
        demo.addWord("bad");
        demo.addWord("dad");
        demo.addWord("mad");
        System.out.println(demo.search("pad"));
        System.out.println(demo.search("bad"));
        System.out.println(demo.search(".ad"));
        System.out.println(demo.search("b.."));


    }

    class TrieNode {
        TrieNode[] child;//记录孩子节点
        boolean is_end;//记录当前节点是不是一个单词的结束字母

        public TrieNode() {//
            child = new TrieNode[26];//子节点数组长度26，0：‘a’，1：‘b’.....
            is_end = false;
        }
    }

    //可以使用之前的前缀数思想


    private TrieNode root;//记录前缀树的根

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode ptr = root;//从根出发
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);//对于每个单词
            if (ptr.child[c - 'a'] == null) {//如果c - 'a'为空，说明还没有存入
                ptr.child[c - 'a'] = new TrieNode();//存入节点
            }
            ptr = ptr.child[c - 'a'];//指向当前节点
        }
        ptr.is_end = true;//最后的节点为单词的最后一个单词，is_end设置为true
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode ptr = root;//从根出发
        return helper(word, 0, ptr);
    }

    private boolean helper(String word, int i, TrieNode ptr) {
        //如果所有字符都在前缀树中，那么判断最后一个字母结束标志是否为true，
        if (i == word.length()) {
            return ptr.is_end;
        }
        char c = word.charAt(i);
        // c == '.'情况，需要遍历所有子节点
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (ptr.child[j] != null && helper(word, i + 1, ptr.child[j]))
                    return true;
            }
            return false;
        } else if (ptr.child[c - 'a'] == null) {
            return false;
        }
        //如果不存在于前缀树中，返回false
        return helper(word, i + 1, ptr.child[c - 'a']);
    }

    //思路2 ：按长度存进单词队列，枚举同长度的单词，然后逐个字母的对比，能够匹配的就返回正常。
}
