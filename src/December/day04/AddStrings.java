package December.day04;

/**
 * @题目 ：415. Add Strings
 * @Data 19/12/09
 * @题目描述： Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @题目链接： 链接：https://leetcode-cn.com/problems/add-strings
 * @示例1: ######
 * @示例2: ######
 * @示例3: ###
 */

public class AddStrings {
    //字符串值相加：不能使用库
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        int carryBit = 0; //表示进位
        StringBuffer sb = new StringBuffer();
        while (n1 >= 0 && n2 >= 0) {
            int temp = num1.charAt(n1--) - '0' + num2.charAt(n2--) - '0' + carryBit;
            carryBit = 0;
            if(temp >= 10){
                carryBit = 1;
                temp %= 10;
            }
            sb.insert(0,temp);
        }
        while (n1 >= 0){
            int temp = num1.charAt(n1--) - '0' + carryBit;
            carryBit = 0;
            if(temp >= 10){
                carryBit = 1;
                temp %= 10;
            }
            sb.insert(0,temp);
        }
        while (n2 >= 0){
            int temp = num2.charAt(n2--) - '0' + carryBit;
            carryBit = 0;
            if(temp >= 10){
                carryBit = 1;
                temp %= 10;
            }
            sb.insert(0,temp);
        }
        if(carryBit > 0)   sb.insert(0,carryBit);
        return sb.toString();
    }
}
