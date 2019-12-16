package July.day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @题目 ：125. 验证回文串
 * @Data: 19/7/30
 * @题目描述： 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * @示例1: ######
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * @示例2: ###
 * 输入: "race a car"
 * 输出: false
 **/

public class ValidPalindrome {

    public static void main(String[] args){
        String s = ",,,,,";
        System.out.print(new ValidPalindrome().isPalindrome(s));
    }

    //由于存在大量的String char的转换，导致时间和空间效率极低
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            //i为无效字符
            while (i < n && !isValidChar(s.charAt(i))) {
                i++;
            }
            //j为无效字符
            while (j >= 0 && !isValidChar(s.charAt(j))) {
                j--;
            }
            if (i >= j) break;
            if (!isEqual(s.charAt(i),s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isValidChar(char c) {
        String regex = "^[A-Za-z0-9]+$";
        return String.valueOf(c).matches(regex);
    }

    private boolean isEqual(char c1, char c2){
        return String.valueOf(c1).toLowerCase().equals(String.valueOf(c2).toLowerCase());
    }

    //采用库函数写法
//    作者：Ac_pipe
//    链接：https://leetcode-cn.com/problems/two-sum/solution/shuang-zhi-zhen-fa-by-ac_pipe/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean isPalindrome2(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }


}
