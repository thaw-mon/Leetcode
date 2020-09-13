package Year2019.August.day15;

import java.util.HashSet;
import java.util.Set;

/**
 * @题目 ：202. Happy Number
 * @Data 19/8/30
 * @题目描述： Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * @题目地址： 链接：https://leetcode-cn.com/problems/happy-number
 * @示例1: ######
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @示例2: ###
 * @示例3: ###
 */

public class HappyNumber {
    public static void main(String[] args){
        int n = 29;
        System.out.println(new HappyNumber().isHappy(n));
    }
    public boolean isHappy(int n) {
        int temp = 0;
        Set<Integer> record = new HashSet<>();
        record.add(n);
        while (n != 1) {
            while (n > 0) {
                temp += Math.pow((n % 10), 2.0);
                n /= 10;
            }
            n = temp;
            temp = 0;
            if (record.contains(n))
                return false;
            record.add(n);
        }
        return true;
    }

    //快慢跑解法
//      作者：rachy
//    链接：https://leetcode-cn.com/problems/happy-number/solution/shi-yong-kuai-man-zhi-zhen-si-xiang-zhao-chu-xun-h/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    private int bitSquareSum(int n) {
        int sum = 0;
        while(n > 0)
        {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy2(int n) {
        int slow = n, fast = bitSquareSum(n);
        while(slow != fast)
        {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        }
        return slow == 1;
    }


}
