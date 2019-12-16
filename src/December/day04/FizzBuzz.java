package December.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：412. Fizz Buzz
 * @Data 19/12/09
 * @题目描述： Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * @题目链接： 链接：https://leetcode-cn.com/problems/fizz-buzz
 * @示例1: ######
 * n = 15,
 * <p>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * @示例2: ######
 * @示例3: ###
 */

public class FizzBuzz {
    //3的倍数：Fizz 5的倍数：Buzz 3和5的倍数FizzBuzz
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String sb = "";
            if (i % 3 == 0) sb +="Fizz";

            if (i % 5 == 0) sb +="Buzz";
            if (sb.length() == 0) sb += i;
            res.add(sb);
        }
        return res;
    }
}
