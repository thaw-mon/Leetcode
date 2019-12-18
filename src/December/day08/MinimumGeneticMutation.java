package December.day08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @题目 ：433. Minimum Genetic Mutation
 * @Data 19/12/18
 * @题目描述： A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 * <p>
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 * <p>
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * <p>
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 * <p>
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * <p>
 * Note:
 * <p>
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * @题目链接： 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * @示例1: ######
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * <p>
 * return: 1
 * @示例2: ######
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * <p>
 * return: 2
 * @示例3: ###
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * <p>
 * return: 3
 */

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        String start = "AACCGGTT", end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(new MinimumGeneticMutation().minMutation(start, end, bank));
    }

    //基本思路：BFS
    //计算从start 到end 需要几次变化 每次变化的结果都需要在bank中找的到，切每次只会变化一个字母（基因）
    //注意，题目没有默认bank不为空
    //优化策略：使用双向BFS
    public int minMutation(String start, String end, String[] bank) {
        //1.把bank转换为map类型方便匹配value默认为0：表示start到key需要的步骤
        Map<String, Integer> maps = new HashMap<>();
        for (String str : bank) maps.put(str, 0);
        if(!maps.containsKey(end)) return -1;
        char[] baseChar = {'A', 'C', 'G', 'T'};//存储基本字符
        //使用队列记录每次变化后在基因库中的结果
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int round = 1; //记录轮次
        //类似与BFS
        while (!queue.isEmpty()) {
            //获取该轮对应的str size;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll(); //每个字符进行变化 总共要匹配8 * 4 = 32 次之多
                assert temp != null;
                char[] array = temp.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char c = array[j];
                    for (char base : baseChar) {
                        if (base == c) continue;
                        array[j] = base;
                        int value = maps.getOrDefault(new String(array), -1);
                        //0表示该str之前未使用
                        if (value == 0) {
                            maps.put(new String(array), round);
                            queue.add(new String(array));
                        }
                    }
                    array[j] = c; //修改后还原
                }
            }
            if (maps.get(end) > 0) {
                break;
            }
            round++;
        }
        return maps.get(end) > 0 ? maps.get(end) : -1;
    }
}
