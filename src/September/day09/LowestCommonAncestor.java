package September.day09;

/**
 * @题目 ： 235. Lowest Common Ancestor of a Binary Search Tree
 * @Data 19/9/16
 * @题目描述： Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * @题目地址： 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * @示例1: ######
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * @示例2: ###
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * @示例3: ###
 */

public class LowestCommonAncestor {

    //这里没有预防 p q root为null的情形,实际测试用例中没有，所以默认不为空
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        // p < q
        TreeNode res = root;
        //如何p、q 分别在 res的一左一右，那么res则为最终的Ancestor
        while (p.val > res.val || q.val < res.val) {
            res = p.val > res.val ? res.right : res.left;
        }
        return res;
    }
}
