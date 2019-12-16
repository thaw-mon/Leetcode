package September.day07;

import java.util.Stack;

/**
 * @题目 ： 230. Kth Smallest Element in a BST
 * @Data 19/9/11
 * @题目描述： Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * @题目地址： 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * @示例1: ######
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * @示例2: ###
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * @示例3: ###
 */

public class KthSmallestElementInBST {

    //
    public static void main(String[] args) {
        int k = 3;
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(new KthSmallestElementInBST().kthSmallest(root, k));
    }

    //中序遍历写法
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        int count = 0;
        while (root != null || !nodeStack.isEmpty()) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            count++;
            if (count == k)
                return root.val;
            //遍历右子树
            root = root.right;
        }
        return 0;
    }

}
