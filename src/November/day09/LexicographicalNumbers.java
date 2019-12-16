package November.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @题目 ： 386. Lexicographical Numbers
 * @Data 19/11/25
 * @题目描述： Given an integer n, return 1 - n in lexicographical order.
 * <p>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 * @题目链接： 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * @示例1: ######
 * @示例2: ######
 * @示例3: ###
 */

public class LexicographicalNumbers {

    public static void main(String[] args){
        System.out.println(new LexicographicalNumbers().lexicalOrder(12331));
    }
    List<Integer> res = new ArrayList<>();

    //返回1--n的字典序
    //dfs
    public List<Integer> lexicalOrder(int n) {
        if (n < 10) {
            for (int i = 1; i <= n; i++) {
                res.add(i);
            }
            return res;
        }
        helper(1, n);
        return res;
    }

    void helper(int value, int n) {
        if(value > n) return;
        for (int i = 0; i < 10 &&  value + i <= n; i++) {
            if (value == 1 && i == 9) break;
            res.add(value + i);
            helper((value + i) * 10, n);
        }
    }

}
