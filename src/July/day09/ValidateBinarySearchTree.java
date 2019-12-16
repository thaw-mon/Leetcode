package July.day09;

import java.util.Stack;

/**
 * @题目 ：98. 验证二叉搜索树
 * @题目描述： 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @示例 1: 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * @示例 2: 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 **/

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    //定义上下界，左右子树递归
//         作者：LeetCode
//        链接：https://leetcode-cn.com/problems/two-sum/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null)
            return true;
        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && upper <= val) return false;
        if (!helper(root.right, val, upper)) return false;
        if (!helper(root.left, lower, val)) return false;
        return true;

    }

    //中序遍历思路
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


}
