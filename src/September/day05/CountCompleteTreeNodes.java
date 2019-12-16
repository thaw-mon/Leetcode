package September.day05;

/**
 * @题目 ： 222. Count Complete Tree Nodes
 * @Data 19/9/07
 * @题目描述： Given a complete binary tree, count the number of nodes.
 * @Note: ###
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * @题目地址： 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * @示例1: ######
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 * @示例2: ###
 * @示例3: ###
 */

public class CountCompleteTreeNodes {
    //可以使用层次遍历或深度遍历法,
    // 但由于完全二叉树的特性，不需要完全遍历一遍，
    // 采用二分法 + 递归策略
    public int countNodes(TreeNode root) {
        //二分法查找叶子节点数目
        if (root == null) return 0;
        int left_height = 0;
        int right_height = 0;
        TreeNode lNode = root;
        TreeNode rNode = root;
        while (lNode != null) {
            lNode = lNode.left;
            left_height++;
        }
        while (rNode != null) {
            rNode = rNode.right;
            right_height++;
        }
        //满二叉树
        if (left_height == right_height) {
            return (int) Math.pow(2, left_height) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }


}
