package July.day16;

import java.util.*;

/**
 * @题目 ：127. 单词接龙
 * @Data: 19/7/30
 * @题目描述： 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 1. 每次转换只能改变一个字母。
 * 2. 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * @示例1: ######
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * 5
 * [
 * ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * @示例2: ###
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 **/

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hog";
        String endWord = "cog";
        List<String> wordList = new LinkedList<>();
//        wordList.add("hot");
//        wordList.add("dot");
//        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
        wordList.add("cog");

        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
    }


    //和前一题相比，减少了DFS步骤,还是超时了
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //判断wordList是否存在endWord
        if (!wordList.contains(endWord)) return 0;
        //1. 把wordList转换为hash表
        Map<String, List<String>> wordTree = new LinkedHashMap<>();
        int n = wordList.size();
        for (int i = 0; i < n; i++) {
            String word = wordList.get(i);
            for (int j = i + 1; j < n; j++) {
                String tmp = wordList.get(j);
                //符合字典序转换规则
                if (isTransfer(word, tmp)) {
                    if (!wordTree.containsKey(word))
                        wordTree.put(word, new LinkedList<>());

                    if (!wordTree.containsKey(tmp))
                        wordTree.put(tmp, new LinkedList<>());
                    wordTree.get(word).add(tmp);
                    wordTree.get(tmp).add(word);
                }
            }
        }
        wordTree.put(beginWord, new LinkedList<>());
        for (int i = 0; i < n; i++) {
            String tmp = wordList.get(i);
            if (isTransfer(beginWord, tmp)) {
                wordTree.get(beginWord).add(tmp);
            }
        }

        //先BFS求最短距离-->要使用队列
        Map<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 0);
        int length = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean flag = false;
        //如果无法匹配会陷入死循环
        //解决办法：增加map distance作为计算 word 到beginWord的距离，防止存在重复递归。
        //例如 : bug --> big  big --> bug (原来版本会产生重复 begin->bug->big 和 begin->bug->big->bug的问题)
        while (!flag && !queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                //获取word对应的next_word
                for (String str : wordTree.get(word)) {
                    //找到了匹配字符串
                    if (str.equals(endWord))
                        flag = true;
                    if (!distance.containsKey(str)) {
                        queue.add(str);
                        distance.put(str, length);
                    }
                }

            }
        }
        //没有找到匹配序列
        if (!flag) return 0;

        return length;
    }


    //判断两个String是否只相差一个字符
    private boolean isTransfer(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }

        return count == 1;
    }



//    双指针BFS+优化寻找下一个word
//    作者：powcai
//    链接：https://leetcode-cn.com/problems/two-sum/solution/bfscong-wu-dao-you-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        int n = beginWord.length();
        int step = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            step++;
            if (s1.size() > s2.size()) {
                Set<String> tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            Set<String> s = new HashSet<>();
            for (String word : s1) {
                for (int i = 0; i < n; i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String tmp = new String(chars);
                        if (s2.contains(tmp)) return step + 1;
                        if (!wordSet.contains(tmp)) continue;
                        wordSet.remove(tmp);
                        s.add(tmp);
                    }
                }
            }
            s1 = s;
        }
        return 0;
    }



}
