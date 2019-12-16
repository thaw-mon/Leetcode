package September.day13;

import java.util.*;

/**
 * @题目 ： 273. Integer to English Words
 * @Data 19/9/20
 * @题目描述： Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
 * @题目地址： 链接：https://leetcode-cn.com/problems/integer-to-english-words
 * @示例1: ######
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * @示例2: ###
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * @示例3: ###
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */

public class IntegerToEnglishWords {

    public static void main(String[] args) {
        int num = 120541;
        System.out.println(new IntegerToEnglishWords().numberToWords(num));
    }

    public String numberToWords(int num) {

        if(num ==0) return "Zero";

        Map<Integer, String> numMap = new LinkedHashMap<>();
        numMap.put(1000000000, "Billion");
        numMap.put(1000000, "Million");
        numMap.put(1000, "Thousand");

        List<String> res = new ArrayList<>();
        for (int key : numMap.keySet()) {
            if (num >= key) {
                res.addAll(helper(num / key));
                res.add(numMap.get(key));
                num %= key;
            }
        }
        if (num > 0)
            res.addAll(helper(num));
        StringBuilder ans = new StringBuilder(res.get(0));
        for (int i = 1; i < res.size(); i++) {
            ans.append(" ").append(res.get(i));
        }

        return ans.toString();
    }

    //处理三位以下的数字
    private List<String> helper(int num) {

        List<String> res = new ArrayList<>();

        String[] n1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] n2 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] n3 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        // Hundred Thousand Million Billion
        if (num >= 100) {
            res.add(n1[num / 100]);
            res.add("Hundred");
            num %= 100;
        }
        if (num >= 20) {
            res.add(n3[num / 10]);
            num %= 10;
        }
        if (num >= 10) {
            res.add(n2[num % 10]);
            num = 0;
        }
        if (num > 0) {
            res.add(n1[num]);
        }

        return res;
    }

}
