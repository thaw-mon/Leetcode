package September.day01;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @题目 ： 212. Word Search II
 * @Data 19/9/02
 * @题目描述： Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * @题目地址： 链接：https://leetcode-cn.com/problems/word-search-ii
 * @示例1: ######
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 * @示例2: ###
 * @示例3: ###
 */


//思路 : 前缀树 + DFS
public class WordSearchII {

    //        作者：zhong-wu-qi
//        链接：https://leetcode-cn.com/problems/word-search-ii/solution/java-zi-dian-shu-shi-jian-17miao-ji-bai-98kong-jia/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<String> findWords(char[][] board, String[] words) {
        //1. 构造前缀树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        //2.
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> resultSet = new HashSet();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                search(board, visited, i, j, m, n, trie.root, resultSet);
        }

        return new LinkedList<String>(resultSet);


    }

    private void search(char[][] board, boolean[][] visited, int i, int j, int m, int n, TrieNode node, Set<String> result) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j])
            return;

        node = node.child[board[i][j] - 'a'];
        if (node == null)
            return;

        if (node.word != null)
            result.add(node.word);

        visited[i][j] = true;
        search(board, visited, i - 1, j, m, n, node, result);
        search(board, visited, i + 1, j, m, n, node, result);
        search(board, visited, i, j - 1, m, n, node, result);
        search(board, visited, i, j + 1, m, n, node, result);
        visited[i][j] = false;
    }

    // 以下为前缀数的实现
    class TrieNode {
        TrieNode[] child;//记录孩子节点
        boolean is_end;//记录当前节点是不是一个单词的结束字母
        String word = null;

        public TrieNode() {//
            child = new TrieNode[26];//子节点数组长度26，0：‘a’，1：‘b’.....
            is_end = false;
        }
    }


    // 作者：zjyDream
//        链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/javashi-xian-qian-zhui-shu-zi-dian-shu-by-zjydream/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Trie {

        TrieNode root;//记录前缀树的根

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode ptr = root;//从根出发
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);//对于每个单词
                if (ptr.child[c - 'a'] == null) {//如果c - 'a'为空，说明还没有存入
                    ptr.child[c - 'a'] = new TrieNode();//存入节点
                }
                ptr = ptr.child[c - 'a'];//指向当前节点
            }
            ptr.is_end = true;//最后的节点为单词的最后一个单词，is_end设置为true
            ptr.word = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode ptr = root;//从根出发
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);//对于每个字母
                if (ptr.child[c - 'a'] == null) {//如果不存在于前缀树中，返回false
                    return false;
                }
                ptr = ptr.child[c - 'a'];
            }
            return ptr.is_end;//如果所有字符都在前缀树中，那么判断最后一个字母结束标志是否为true，
            // 为true，返回true，说明单词找到，否则，false，没找到
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode ptr = root;//从根出发
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);//对于每个字母
                if (ptr.child[c - 'a'] == null) {//如果不存在于前缀树中，返回false
                    return false;
                }
                ptr = ptr.child[c - 'a'];
            }
            return true;
        }
    }
}
