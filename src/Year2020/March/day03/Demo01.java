package Year2020.March.day03;

import java.util.*;

public class Demo01 {

    /**
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     * @param words : 单词列表
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
       //1.对单词进行统计归并
        Map<String,Integer> wordMaps = new HashMap<>();
        for(String word : words){
            wordMaps.put(word,wordMaps.getOrDefault(word,0) + 1);
        }
        //2.按照value值进行排序，相同value的则按照字母顺序排序:改为降序
        Map<Integer,List<String>> vMaps = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(String word : wordMaps.keySet()){
            int value = wordMaps.get(word);
            if(!vMaps.containsKey(value))
                vMaps.put(value,new ArrayList<>());
            vMaps.get(value).add(word);
        }
        //3.输出前k个单词
        List<String> ret = new ArrayList<>();
        for(Integer num : vMaps.keySet()) {
            List<String> tmp = vMaps.get(num);
            //对tmp结果进行排序
            Collections.sort(tmp);
            if(tmp.size() <= k){
                ret.addAll(tmp);
                k -= tmp.size();
            }else {
                for(int i=0;i<k;i++)
                    ret.add(tmp.get(i));
                k = 0;
            }
            if(k==0) break;
        }

        return ret;
    }
}
