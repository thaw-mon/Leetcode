package June.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：43. 字符串相乘
 * @题目描述： 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @Date:19/6/25
 * @示例 1: 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * @示例 2: 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * @说明： num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 */

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 ="897";
        String num2 ="2356";
        System.out.println(new MultiplyStrings().multiply(num1,num2));
    }

    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return res.append(0).toString();
        }

        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        int num1Length = num1Char.length;
        int num2Length = num2Char.length;
        List<StringBuilder> ansList = new ArrayList<>();
        for (int i = num1Length - 1; i >= 0; i--) {
            int numberi = num1Char[i] - '0';
            int carry = 0;
            StringBuilder ans = new StringBuilder();
            for (int k = i; k < num1Length - 1; k++) {
                ans.append(0);
            }
            for (int j = num2Length - 1; j >= 0; j--) {
                int numberj = num2Char[j] - '0';
                int product = numberi * numberj + carry;
                int remain = product % 10;
                carry = product / 10;
                ans.insert(0, remain);
            }
            if (carry != 0) {
                ans.insert(0, carry);
            }
            ansList.add(ans);
        }
        //对所有的ans进行累加
        res = addList(ansList);
        return res.toString();
    }

    private StringBuilder addList(List<StringBuilder> list) {
        StringBuilder ans = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            ans = addTwoString(ans,list.get(i));
        }
        return ans;
    }

    private StringBuilder addTwoString(StringBuilder s1, StringBuilder s2) {
        StringBuilder ans = new StringBuilder();
        int len1 = s1.length() - 1, len2 = s2.length() - 1;
        int carry = 0;
        while (len1 >=0 && len2 >=0){
            int num1 = s1.charAt(len1--) - '0';
            int num2 = s2.charAt(len2--) - '0';
            int plus = num1 + num2 + carry;
            carry = plus / 10;
            ans.insert(0,plus % 10);
        }
        while (len1 >=0){
            int num1 = s1.charAt(len1--) - '0' + carry;
            carry = num1 / 10;
            ans.insert(0,num1 % 10);
        }
        while (len2 >=0){
            int num2 = s2.charAt(len2--) - '0' + carry;
            carry = num2 / 10;
            ans.insert(0,num2 % 10);
        }
        if(carry !=0){
            ans.insert(0,carry);
        }
        return ans;
    }

}
