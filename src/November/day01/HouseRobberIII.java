package November.day01;
/**
 * @题目 ： 336. Palindrome Pairs
 * @Data 19/11/06
 * @题目描述： The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/house-robber-iii
 * @示例1: ######
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * @示例2: ######
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
     * @示例3: ###
 */
public class HouseRobberIII {
    //划分为子问题：子树有两种可能：1 root节点被偷A 2 root节点没被偷B
    //对于上一级二叉树 A[i-1] = B1[i] + B2[i] + a[i] B[i] = max(A1[i],B1[i]) + max(A2[i],B2[i])
    //Question：如何让递归函数返回两个值？-->数组
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    private int[] helper(TreeNode root){
        int[] res = new int[2];
        if(root ==null) return res;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return res;
    }
}
