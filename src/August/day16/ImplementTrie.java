package August.day16;

/**
 * @题目 ：208. Implement Trie (Prefix Tree)
 * @Data 19/8/31
 * @题目描述： Implement a trie with insert, search, and startsWith methods.
 * @题目地址： 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * @示例1: ######
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * @示例2: ###
 * @示例3: ###
 */

public class ImplementTrie {

    class TrieNode {
        TrieNode[] child;//记录孩子节点
        boolean is_end;//记录当前节点是不是一个单词的结束字母

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
