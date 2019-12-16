package November.day03;

import java.util.HashSet;
import java.util.Set;

/**
 * @题目 ： 345. Reverse Vowels of a String
 * @Data 19/11/10
 * @题目描述： Write a function that takes a string as input and reverse only the vowels of a string.
 * @题目链接： 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * @示例1: ######
 * Input: "hello"
 * Output: "holle"
 * @示例2: ######
 * Input: "leetcode"
 * Output: "leotcede"
 * @示例3: ###
 */
public class ReverseVowelsOfString {
    //反转元音字母：注意大小写都算
    public String reverseVowels(String s) {
        Set<Character> dict = new HashSet<>();
        char[] vowels = {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};
        for (char vowel : vowels) {
            dict.add(vowel);
        }
        int left = 0, right = s.length()-1;
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        while (left < right){
            while (left < right && !dict.contains(s.charAt(left))){
                sbLeft.append(s.charAt(left));
                left++;
            }
            while (left < right && !dict.contains(s.charAt(right))){
                sbRight.append(s.charAt(right));
                right--;
            }
            if(left==right){
                break;
            }
            //交换left right
            sbLeft.append(s.charAt(right--));
            sbRight.append(s.charAt(left++));

        }
        if(left==right)
            sbLeft.append(s.charAt(left));

        return sbLeft.append(sbRight.reverse()).toString();
    }
}
