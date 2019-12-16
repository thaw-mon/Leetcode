package November.day03;

/**
 * @题目 ： 344. Reverse String
 * @Data 19/11/10
 * @题目描述： GWrite a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/reverse-string
 * @示例1: ######
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * @示例2: ######
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * @示例3: ###
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0,right = len-1;
        char tmp;
        while (left < right){
            //swap left and right
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
