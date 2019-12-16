package November.day03;

import java.util.*;

/**
 * @题目 ： 347. Top K Frequent Elements
 * @Data 19/11/10
 * @题目描述： Given a non-empty array of integers, return the k most frequent elements.
 * @题目链接： 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @示例1: ######
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * @示例2: ######
 * Input: nums = [1], k = 1
 * Output: [1]
 * @示例3: ###
 */
public class TopKFrequentElements {
    public static void main(String[] args){
        int k = 2;
        int[] nums = {1,1,1,2,2,3};
        System.out.println(new TopKFrequentElements().topKFrequent(nums,k));
    }
    //按频率排序，返回前k个最大频率的数值
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            int value = map.getOrDefault(num,0) + 1;
            map.put(num,value);
        }
        //数字数量--对于的数组
        Map<Integer,List<Integer>> valueMap = new TreeMap<>();
        for(int key : map.keySet()){
            if(!valueMap.containsKey(map.get(key))){
                valueMap.put(map.get(key),new ArrayList<>());
            }
            valueMap.get(map.get(key)).add(key);
        }
        List<Integer> res = new ArrayList<>();
        Integer[] values = new Integer[valueMap.keySet().size()];
        valueMap.keySet().toArray(values);
        Arrays.sort(values);
        for(int i= values.length-1;i>=0;i--){
            res.addAll(valueMap.get(values[i]));
            if(res.size() == k)
                break;
        }

        return res;
    }
}
