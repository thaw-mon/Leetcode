package July.day13;

import java.util.Stack;

/**
 * @题目 ：114. 二叉树展开为链表
 * @题目描述： 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * @示例 2: ###
 **/

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args){
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        TreeNode p = root.left;
        p.left = new TreeNode(3);
        p.right = new TreeNode(4);
        p = root.right;
        p.left = new TreeNode(6);
        p.right = new TreeNode(7);

        new FlattenBinaryTreeToLinkedList().flatten(root);
    }

    //类似于先序遍历的线索二叉树
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            //保存右子树
            while (root != null) {
                if (root.right != null)
                    stack.push(root.right);
                root.right = root.left;
                root.left = null;
                preNode = root;
                root = root.right;
            }
            if (preNode != null && !stack.isEmpty()) {
                preNode.right = stack.peek();
            }
        }
    }
}
