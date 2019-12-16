package September.day09;

import java.util.*;

/**
 * @题目 ： 236. Lowest Common Ancestor of a Binary Tree
 * @Data 19/9/16
 * @题目描述： Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * @题目地址： 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * @示例1: ######
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * @示例2: ###
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * @示例3: ###
 */
public class LowestCommonAncestorII {

    //和上一题不同的是，只是二叉树而非二叉查找树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //1.找到两个节点的位置
        // 采用先序遍历,同时记录下路径
        Stack<TreeNode> path_p = new Stack<>(), path_q = new Stack<>();
        //没有找到节点p或q
        if (!getPath(root, p, path_p) || !getPath(root, q, path_q)) return null;
        int size = Math.min(path_p.size(),path_q.size());
        while (path_p.size() > size){
            path_p.pop();
        }
        while (path_q.size() > size){
            path_q.pop();
        }
        //2.比较两条路径前面重合的部分
        TreeNode res;
        while (!path_p.isEmpty()){
            res = path_p.pop();
            if(res == path_q.pop())
                return res;
        }
        return null;
    }

    //查找节点node,并返回其路径
    private boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> path) {
        if (root == null) return false;
        path.push(root);
        if (root == node) return true;

        if (getPath(root.left, node, path)) return true;
        if (getPath(root.right, node, path)) return true;

        path.pop();

        return false;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetcod/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }


}
