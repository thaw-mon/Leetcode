package Year2019.October.day07;

/**
 * @题目 ： 318. Maximum Product of Word Lengths
 * @Data 19/10/14
 * @题目描述： Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 *
 * 题目地址： 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * @示例1: ######
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 *
 * @示例2: ######
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 *
 * @示例3: ###
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */

public class MaximumProductOfWordLengths {

    //TODO 优化策略：用位运算--> 每个word都可以使用26位bit数字表示对应字母是否出现
    // 某位置一方法 a|=1<<k;
    public int maxProduct(String[] words) {
        int maxLength = 0;
        int n = words.length;
        for(int i=0;i<n;i++){
            int l1 = words[i].length();
            int[] word = new int[26];
            for (char c : words[i].toCharArray()){
                word[c- 'a'] += 1;
            }
            for(int j=i+1;j<n;j++){

                int l2 = words[j].length();
                if(l1 * l2 <= maxLength)
                    continue;
                boolean flag = false;
                for(char c: words[j].toCharArray()){
                    if(word[c-'a']>0){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    maxLength = l1 * l2;
                }
//                if(!isContainSameChar(words[i],words[j]))
//                    maxLength = l1 * l2;
            }
        }
        return maxLength;
    }

    private boolean isContainSameChar(String s1, String s2){
        int[] word = new int[26];
        for (char c : s1.toCharArray()){
            word[c- 'a'] += 1;
        }
        for(char c: s2.toCharArray()){
            if(word[c-'a']>0)
                return true;
        }
        return false;
    }
}
