package Year2020.September.day06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Demo01 {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
     *
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;

        root = balanceTree(root, new HashMap<>());
        return root;
    }

    private TreeNode balanceTree(TreeNode root, Map<TreeNode, Integer> height) {
        if (root == null) return null;
        //1.平衡子树
        root.left = balanceTree(root.left, height);
        root.right = balanceTree(root.right, height);
        //2.平衡当前树
        int left = height.getOrDefault(root.left, 0);
        int right = height.getOrDefault(root.right, 0);
        if (Math.abs(left - right) <= 1) {
            //当前树为平衡二叉树
            height.put(root, Math.max(left, right) + 1);
            return root;
        }
        //进行旋转操作(四种基本操作)
        if (left > right) {
            TreeNode p = root.left;
            if (height.getOrDefault(p.left, 0) >= height.getOrDefault(p.right, 0)) {
                //右旋操作
                root = rightRotate(root, height);
            } else {
                root = leftRightRotate(root, height);
            }
//            System.out.println("pause");
        } else {
            TreeNode p = root.right;
            if (height.getOrDefault(p.right, 0) >= height.getOrDefault(p.left, 0)) {
                root = leftRotate(root, height);
            } else {
                root = rightLeftRotate(root, height);
            }
//            System.out.println("pause");
        }
        //left = height.getOrDefault(root.left, 0);
        //right = height.getOrDefault(root.right, 0);
        //height.put(root, Math.max(left, right) + 1);
        return root;
    }


    //右子树大于左子树，且右子树的右子树大于左子树
    private TreeNode leftRotate(TreeNode root, Map<TreeNode, Integer> height) {
        TreeNode p = root;
        root = p.right;
        p.right = root.left;
        int leftLen = height.getOrDefault(p.left, 0);
        int rightLen = height.getOrDefault(p.right, 0);
        //ADD 防止p子树不为AVL
        if (Math.abs(leftLen - rightLen) <= 1) {
            height.put(p, Math.max(leftLen, rightLen) + 1);
        } else {
            p = balanceTree(p, height);
        }
        root.left = p;
        leftLen = height.getOrDefault(root.left, 0);
        rightLen = height.getOrDefault(root.right, 0);
        height.put(root, Math.max(leftLen, rightLen) + 1);
        return root;

    }

    //左子树大于右子树,且左子树的左子树大于右子树
    private TreeNode rightRotate(TreeNode root, Map<TreeNode, Integer> height) {
        TreeNode p = root;
        root = p.left;
        p.left = root.right;
        int leftLen = height.getOrDefault(p.left, 0);
        int rightLen = height.getOrDefault(p.right, 0);
        //ADD 防止p子树不为AVL
        if (Math.abs(leftLen - rightLen) <= 1) {
            height.put(p, Math.max(leftLen, rightLen) + 1);
        } else {
            p = balanceTree(p, height);
            leftLen = height.getOrDefault(p.left, 0);
            rightLen = height.getOrDefault(p.right, 0);
            height.put(p, Math.max(leftLen, rightLen) + 1);
        }
        root.right = p;
        leftLen = height.getOrDefault(root.left, 0);
        rightLen = height.getOrDefault(root.right, 0);
        height.put(root, Math.max(leftLen, rightLen) + 1);
        return root;
    }

    //TODO add 双旋操作
    //左子树大于右子树，且左子树的右子树大于左子树
    private TreeNode leftRightRotate(TreeNode root, Map<TreeNode, Integer> height) {
        //1.现对当前节点的最节点进行左旋操作
        root.left = leftRotate(root.left, height);
        //2.然后对当前节点进行右旋操作
        root = rightRotate(root, height);
        return root;
    }


    private TreeNode rightLeftRotate(TreeNode root, Map<TreeNode, Integer> height) {
        //
        root.right = rightRotate(root.right, height);
        root = leftRotate(root, height);
        return root;
    }


    //[1,null,15,14,17,7,null,null,null,2,12,null,3,9,null,null,null,null,11]
    //TODO 部分结果还是有问题，手撕AVL 失败了
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        TreeNode root = new TreeNode(0);
        TreeNode p = new TreeNode(15);
        root.right = p;
        p = root.right;
        p.left = new TreeNode(14);
        p.right = new TreeNode(17);
        p = p.left;
        p.left = new TreeNode(7);
        p = p.left;
        p.left = new TreeNode(2);
        p.right = new TreeNode(12);
        System.out.println(demo01.balanceBST(root));
    }
}
