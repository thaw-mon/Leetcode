package Year2019.December.day02;

/**
 * @题目 ： 402. Remove K Digits
 * @Data 19/12/03
 * @题目描述： Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 *
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/remove-k-digits
 * @示例1: ######
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 * @示例2: ######
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 * @示例3: ###
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 */


public class RemoveKDigits {
    //移除字符串中的k位使得num最小
    //注意数字不包含前导0：如果存在则忽略 eg2
    //思路，从左到右，找第一个比后面大的字符，删除，清零，k次扫描。
    //也可以维护一个递增栈
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) idx = j;
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.toString();

    }
}
