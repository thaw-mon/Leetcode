package September.day06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @题目 ： 226. Invert Binary Tree
 * @Data 19/9/09
 * @题目描述： Invert a binary tree.
 * @题目地址： 链接：https://leetcode-cn.com/problems/invert-binary-tree/
 * @示例1: ######
 * Input:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * Output:
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * @示例2: ###
 * @示例3: ###
 */

public class InvertBinaryTree {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        new InvertBinaryTree().invertTree(root);
        System.out.println(root);
    }

    //很简单的递归思路
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        invertTree(root.left);
        invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    //另一种迭代方法
//        作者：LeetCode
//    链接：https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }



}
