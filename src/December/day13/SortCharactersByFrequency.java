package December.day13;

import java.util.*;

/**
 * @题目 ：451. Sort Characters By Frequency
 * @Data 19/12/27
 * @题目描述： Given a string, sort it in decreasing order based on the frequency of characters.
 *
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * @示例1: ######
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * @示例2: ######
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * @示例3: ###
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 */

public class SortCharactersByFrequency {

    //降序排序
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDescending(Map<K, V> map)
    {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>()
        {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    //按照字符频率的降序进行排序
    public String frequencySort(String s) {
        Map<Character,Integer> maps= new HashMap<>();
        for(char c : s.toCharArray()){
            if(!maps.containsKey(c)){
                maps.put(c,1);
            }
            else
                maps.put(c,maps.get(c) + 1);
        }
        //按照maps value 降序输出
        StringBuffer sb = new StringBuffer();
        maps = sortByValueDescending(maps);
        for(Map.Entry<Character,Integer> entry : maps.entrySet()){
            char c = entry.getKey();
            int num = entry.getValue();
            for(int i=0; i< num;i++){
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
