package Year2020.January.day05;

/**
 * @题目 ：474. Ones and Zeroes
 * @Data 20/01/13
 * @题目描述： In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * <p>
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 * <p>
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * <p>
 * Note:
 * <p>
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 * @题目链接： 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * @示例1: ######
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * <p>
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 * @示例2: ######
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * <p>
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 * @示例3: ###
 */

public class OnesAndZeroes {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(new OnesAndZeroes().findMaxForm(strs, 5, 3));
    }

    class Node {
        //0-1数目
        private int zero;
        private int one;

        Node(int a, int b) {
            zero = a;
            one = b;
        }
    }

    //再次优化策略：优化strs[i]只是使用一次，因此构建node类是不必要的
    public int findMaxForm(String[] strs, int m, int n) {

        //把strs转换为0,1数值对
        Node[] nodes = new Node[strs.length];
        int i = 0;
        for (String str : strs) {
            int a = 0, b = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') a++;
                else b++;
            }
            nodes[i++] = new Node(a, b);
        }
        //动态规划思路 (0-1背包问题) dp[m][n] 使用m个0、n个1能装入的最大的strs
        //dp[k][i][j] =
        // 问题在于dp[i-k1][j-k2]和dp[k1][k2]必然会存在重复的strs,这个如何判断呢？
        // 每次增加一个strs，判断是否可以增加该strs
        int[][] dp = new int[m + 1][n + 1];  //可以优化为2维
        for (i = 0; i < strs.length; i++) {
            for (int j = m; j >= nodes[i].zero; j--) { //0
                //if (j < nodes[i].one) break;
                for (int k = n; k >= nodes[i].one; k--) { //1
                    //  if (k < nodes[i].zero) break;
                    dp[j][k] = Math.max(dp[j][k], dp[j - nodes[i].zero][k - nodes[i].one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
