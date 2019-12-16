package December.day02;


/**
 * @题目 ： 404. Sum of Left Leaves
 * @Data 19/12/03
 * @题目描述： Find the sum of all left leaves in a given binary tree.
 * @题目链接： 链接：https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @示例1: ######
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * @示例2: ######
 * @示例3: ###
 */

public class SumLeftLeaves {
    //计算左叶子节点的和
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) return 0;
        res = helper(root, false);
        return res;
    }

    private int helper(TreeNode root, boolean isLeft) {
        int res = 0;
        //为叶子节点
        if (root.left == null && root.right == null) {
            if (isLeft)
                res = root.val;
            return res;
        }
        //非叶子节点
        if (root.left != null) res += helper(root.left, true);
        if (root.right != null) res += helper(root.right, false);
        return res;
    }
}
