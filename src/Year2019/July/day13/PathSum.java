package Year2019.July.day13;

import java.util.LinkedList;

/**
 * @题目 ：112. 路径总和
 * @题目描述： 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @示例 2: ###
 **/

public class PathSum {
    //很简单的一个深度遍历
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode node, int sum, int current) {
        current += node.val;
        //当前节点为叶子节点
        if (node.left == null && node.right == null)
            return current == sum;
        if (node.left == null)
            return helper(node.right, sum, current);
        if (node.right == null)
            return helper(node.left, sum, current);

        return helper(node.left, sum, current) || helper(node.right, sum, current);
    }

    //思路一样的简洁写法
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/lu-jing-zong-he-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum2(root.left, sum) || hasPathSum2(root.right, sum);
    }

    //迭代写法
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/lu-jing-zong-he-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null)
            return false;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int curr_sum;
        while ( !node_stack.isEmpty() ) {
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            if ((node.right == null) && (node.left == null) && (curr_sum == 0))
                return true;

            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }




}
