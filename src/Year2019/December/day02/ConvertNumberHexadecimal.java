package Year2019.December.day02;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ： 405. Convert a Number to Hexadecimal
 * @Data 19/12/03
 * @题目描述： Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * @题目链接： 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * @示例1: ######
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * @示例2: ######
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 * @示例3: ###
 */

public class ConvertNumberHexadecimal {
    //把数字转化为16进制
    // Question:如何处理负数 使用按位运算符
    //需注意 0的特例
    //优化策略：1.map改为hash_bucket
    
    public String toHex(int num) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(10, 'a');
        map.put(11, 'b');
        map.put(12, 'c');
        map.put(13, 'd');
        map.put(14, 'e');
        map.put(15, 'f');
        StringBuilder sb = new StringBuilder();
        int temp = num;
        while (temp != 0) {
            //获取temp后四位
            int data = 0x0f & temp;
            temp >>>= 4; //这是算术右移运算符
            if (data < 10)
                sb.append(data);
            else
                sb.append(map.get(data));
        }
        //防止出现0返回null
        if (sb.length() == 0) sb.append(0);
        return sb.reverse().toString();
    }
}
