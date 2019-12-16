package June.day10;

import java.util.*;

/**
 * 题目描述：给定一个字符串 s 和一些长度相同的单词 words。
 * 找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意: 子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * Date:19/6/15
 * 示例 1:
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 示例 2:
 * 输入:  s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出: []
 * 示例 3 ：
 * 输入:  s = "wordgoodgoodgoodbestword", words = ["word","good","best","good"]
 * 输出: [8]
 * 输入:  s = "aaaaaaaa", words = ["aa","aa","aa"]
 * 输出: [0,1,2]
 */

public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s,words));
    }

    //参考题解后明白可以使用HashMap 来存储words key = word value = num
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        int strLength = s.length();
        int wordSize = words.length;
        if(strLength==0 || wordSize==0){
            return res;
        }
        int wordLength = words[0].length();

        //words转换为HashMap
        for (String word : words) {
            //Map中没有存储该单词
            Integer value = wordsMap.get(word);
            if (value == null) {
                wordsMap.put(word, 1);
            } else {
                wordsMap.put(word, value + 1);
            }
        }

        for (int i = 0; i < wordLength; i++) {
            //定义str对应单词的HashMap
            Map<String, Integer> strMap = new HashMap<>();
            int nums = 0;
            int j = i;
            while (j < strLength) {
                //判断以j开头的subStr是否满足条件
                //记录StrMap中数量
                while (nums < wordSize) {
                    int start = j + nums * wordLength;
                    if(start > strLength - wordLength){
                        j+=wordLength;
                        break;
                       // return res;
                    }
                    String subStr = s.substring(start, start + wordLength);
                    Integer valueInWords = wordsMap.get(subStr);
                    //存在不再wordsMap的字符，直接跳出
                    if (valueInWords == null) {
                        nums = 0;
                        j = start + wordLength;
                        strMap.clear();
                        break;
                    }
                    //判断单词是否在strMap
                    Integer valueInStr = strMap.get(subStr);
                    nums++;
                    //单词不在StrMap
                    if (valueInStr == null) {
                        strMap.put(subStr, 1);
                        continue;
                    }
                    //单词在subStr数量大于words
                    strMap.put(subStr, valueInStr + 1);
                    if (strMap.get(subStr) > valueInWords) {
                        //从j开始删去前面的单词直到符合条件
                        int removeNums = 0;
                        while (strMap.get(subStr) > valueInWords) {
                            String removeStr = s.substring(j + removeNums * wordLength, j + (removeNums + 1) * wordLength);
                            int removeStrValue = strMap.get(removeStr);
                            strMap.put(removeStr, removeStrValue - 1);
                            removeNums++;
                            nums--;
                        }
                        j = j + removeNums * wordLength;
                        break;
                    }
                }
                if(nums == wordSize){
                    res.add(j);
                    nums --;
                    String removeStr = s.substring(j, j + wordLength);
                    int removeStrValue = strMap.get(removeStr);
                    strMap.put(removeStr,removeStrValue-1);
                    j += wordLength;
                }
            }
        }
        return res;
    }
}
