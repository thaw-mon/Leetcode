package August.day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @题目 ：132. 分割回文串 II
 * @Data: 19/8/01
 * @题目描述： 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 * @示例1: ######
 * 输入: "aab"
 * 输出: 1
 * @示例2: ###
 **/

public class PalindromePartitioningII {

    public static void main(String[] args) {
        String s = "aasajdsbb";
        System.out.println(new PalindromePartitioningII().minCut(s));
    }


    public int minCut(String s) {
        int res = 0;
        int n = s.length();
        if (n == 0) return res;
        boolean[][] dp = new boolean[n][n];
        //j表示间隔  i表示起始位置
        for (int j = 0; j < n; j++)
            for (int i = 0; i + j < n; i++) {
                //间隔为0 dp[i][i] 类型
                if (j == 0)
                    dp[i][i + j] = true;
                else if (j == 1)
                    dp[i][i + j] = s.charAt(i) == s.charAt(i + j);
                else
                    dp[i][i + j] = s.charAt(i) == s.charAt(i + j) && dp[i + 1][i + j - 1];

            }
        Map<Integer, Integer> map = new HashMap<>();
        res = getPalindromeNum(s, 0, n, dp, map);
        return res - 1;
    }

    //超时了,需要以空间换时间，使用map后顺利通过
    //right == n 不变
    //TODO 优化策略： 由于right是不变的可以使用动态规划取代map
    private int getPalindromeNum(String s, int left, int right, boolean[][] dp, Map<Integer, Integer> map) {
        int res = Integer.MAX_VALUE;
        if (left >= right)
            return 0;

        //判断字串是否为回文串
        if (dp[left][right - 1]) {
            map.put(left,1);
            return 1;
        }
        for (int i = left + 1; i < right; i++) {
            //左半部分属于回文序列
            if (dp[left][i - 1]) {
                int rightRes = map.getOrDefault(i,-1);
                //map中没有存储该值
                if(rightRes == -1)
                    rightRes = getPalindromeNum(s, i, right, dp, map);

                if (rightRes != 0 && rightRes + 1 < res)
                    res = rightRes + 1;
            }
        }
        map.put(left, res);
        return res;
    }

    //大佬的高效方法
//    作者：yu-xiang-bei-you
//    链接：https://leetcode-cn.com/problems/two-sum/solution/dong-tai-gui-hua-java-by-yu-xiang-bei-you/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    /**
     * 有一个更高效的方法
     * 遍历一遍给的串 以遍历点为中心找最大的回文串 更新dp
     * 回文串有两种方式left为中心的奇数型 以left，left+1为中心的偶数型
     * @param s
     * @return
     */
    public int minCut2(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < len; i++) {
            search(s, dp, i, i);
            search(s, dp, i, i + 1);
        }
        return dp[len - 1];
    }

    private void search(String s, int[] dp, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (left == 0) {
                //本身就是回文串
                dp[right] = 0;
            } else {
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }
            left--;
            right++;
        }
    }


}
