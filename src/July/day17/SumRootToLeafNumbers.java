package July.day17;

/**
 * @题目 ：129. 求根到叶子节点数字之和
 * @Data: 19/7/31
 * @题目描述： 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * @说明:  叶子节点是指没有子节点的节点。
 * @示例1: ######
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * @示例2: ###
 * 输入: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 **/

public class SumRootToLeafNumbers {
    //显而易见的深度优先遍历
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root != null)
            DFS(root, 0);
        return res;
    }

    private void DFS(TreeNode root, int val) {
        //为叶子节点终止递归
        if (root.left == null && root.right == null) {
            res += val * 10 + root.val;
            return;
        }
        if (root.left != null) DFS(root.left, val * 10 + root.val);
        if (root.right != null) DFS(root.right, val * 10 + root.val);
    }
}
