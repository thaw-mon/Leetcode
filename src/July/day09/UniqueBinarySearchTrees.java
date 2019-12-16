package July.day09;

import java.util.*;

/**
 * @题目 ：96. 不同的二叉搜索树
 * @题目描述： 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @示例 1: 输入: 3
 * 输出:
 * 5
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * @示例 2: ####
 **/

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        int n = 20;
        Date date1 = new Date();
        System.out.println(new UniqueBinarySearchTrees().numTrees(n));
        Date date2 = new Date();
        System.out.println(date2.getTime() - date1.getTime());
        //不加map   11166
        //添加map   4
    }

    public int numTrees(int n) {
        if (n == 0)
            return 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 0);
        countMap.put(1, 1);
        return helper2(1, n,countMap);
    }

    //照抄前一题的解法，结果超时了 -->因为当n较大时,很多计数是重复的
    private int helper(int start, int end) {
        int res = 0;
        if (start > end) {
            return res;
        }
        for (int i = start; i <= end; i++) {
            int left = helper(start, i - 1);
            left = left == 0 ? 1 : left;
            int right = helper(i + 1, end);
            right = right == 0 ? 1 : right;
            res += left * right;
        }
        return res;
    }

    //添加记录信息-->通过了但是依然很慢
    private int helper2(int start, int end, Map<Integer, Integer> countMap) {
        int res = 0;
        if (start > end) {
            return res;
        }
        if (countMap.containsKey(end - start + 1))
            return countMap.get(end - start + 1);

        for (int i = start; i <= end; i++) {
            int left = helper2(start, i - 1, countMap);
            left = left == 0 ? 1 : left;
            int right = helper2(i + 1, end, countMap);
            right = right == 0 ? 1 : right;
            res += left * right;
        }
        countMap.put(end - start + 1, res);
        return res;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //通过规律解法
    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
