package June.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：60. 第k个排列
 * @题目描述： 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"  "132"   "213"   "231"   "312"   "321"
 * 给定 n 和 k，返回第 k 个排列。 k从1开始计数
 * @Date:19/6/30
 * @示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * @示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 **/

public class KPermutationSequence {

    public static void main(String[] args) {
        int n = 1;
        int k = 1;
        System.out.println(new KPermutationSequence().getPermutation(n, k));
    }

    //显而易见，暴力法可以做但是没有必要
    //n 1开头序列1 --- (n-1)!  2开头 (n-1)!+1 --- (n-1)!*2 .....
    //递归求解每一个开头
    public String getPermutation(int n, int k) {
        //计算费波纳数
        int[] fab = new int[n];
        fab[0] = 1;
        for (int i = 1; i < n; i++) {
            fab[i] = fab[i - 1] * i;
        }
        //升序保存未使用的数字
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(i + 1);
        }
        int num, k1 = k - 1;
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            num = k1 / fab[n - i];
            k1 = k1 % fab[n - i];
            //从小到大选择第num个未使用的值
            s.append(ans.get(num));
            //已使用的数字要去除
            ans.remove(num);
            if (k1 == 0) {
                break;
            }
        }
        for (Integer i : ans){
            s.append(i);
        }
        return s.toString();
    }
}
