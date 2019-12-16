package July.day16;

import java.util.*;

/**
 * @题目 ：126. 单词接龙 II
 * @Data: 19/7/30
 * @题目描述： 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
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
 * 输出: []
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 **/

public class WordLadderII {

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dot";
        List<String> wordList = new LinkedList<>();
//        ["hot","cog","dog","tot","hog","hop","pot","dot"]
        wordList.add("hot");
//        wordList.add("cog");
        wordList.add("dog");

//        wordList.add("lot");
//        wordList.add("log");


//        wordList.add("tot");
//        wordList.add("hog");
//        wordList.add("hop");
//        wordList.add("pot");
        wordList.add("dot");

        new WordLadderII().findLadders(beginWord, endWord, wordList);

        System.out.println(res);
    }

    //定义返回值
    private static List<List<String>> res = new LinkedList<>();

    //当wordList特别长时，直接将wordList转换为hash表会产生超时
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //判断wordList是否存在endWord
        if (!wordList.contains(endWord)) return res;
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
        int length = 0;
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
        if (!flag) return res;

        //找到了匹配序列，获得长度length,进行DFS
        List<String> ans = new LinkedList<>();
        ans.add(beginWord);
        DFS(endWord, ans, wordTree, 0, distance);
        return res;
    }

    //深度优先遍历
    private void DFS(String endWord, List<String> ans, Map<String, List<String>> wordTree, int level, Map<String, Integer> distance) {
        String lastWord = ans.get(ans.size() - 1);
        if (lastWord.equals(endWord)) res.add(new LinkedList<>(ans));
        for (String word : wordTree.get(lastWord)) {
            ans.add(word);
            if (distance.get(word) != null && distance.get(word) == level + 1)
                DFS(endWord, ans, wordTree, level + 1, distance);
            ans.remove(ans.size() - 1);
        }
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


    //大佬的优化策略
//    作者：powcai
//    链接：https://leetcode-cn.com/problems/two-sum/solution/bfs-dfs-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordList_set = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        Map<String, ArrayList<String>> next_word_map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, next_word_map, distance, wordList_set);
        dfs(beginWord, endWord, next_word_map, 0, res, new ArrayList<String>(Arrays.asList(beginWord)), distance);
        return res;
    }

    private void dfs(String beginWord, String endWord, Map<String, ArrayList<String>> next_word_map, int step, List<List<String>> res, ArrayList<String> tmp, Map<String, Integer> distance) {

        if (tmp.get(tmp.size() - 1).equals(endWord)) res.add(new ArrayList<>(tmp));
        for (String word : next_word_map.get(tmp.get(tmp.size() - 1))) {
            tmp.add(word);
            if (distance.get(word) == step + 1) dfs(word, endWord, next_word_map, step + 1, res, tmp, distance);
            tmp.remove(tmp.size() - 1);
        }
    }

    private void bfs(String beginWord, String endWord, Map<String, ArrayList<String>> next_word_map, Map<String, Integer> distance, Set<String> wordList_set) {
        for (String s : wordList_set) next_word_map.put(s, new ArrayList<String>());
        next_word_map.put(beginWord, new ArrayList<>());
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        boolean flag = false;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String word = queue.poll();
                for (String nw : next_word(word, wordList_set)
                ) {
                    next_word_map.getOrDefault(word, new ArrayList<>()).add(nw);
                    if (nw.equals(endWord)) flag = true;
                    if (!distance.containsKey(nw)) {
                        distance.put(nw, step);
                        queue.offer(nw);
                    }

                }
            }
            if (flag) break;
        }
    }

    private ArrayList<String> next_word(String word, Set<String> wordList_set) {
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String tmp = new String(chars);
                if (!tmp.equals(word) && wordList_set.contains(tmp)) ans.add(tmp);
            }
        }
        return ans;
    }

}
