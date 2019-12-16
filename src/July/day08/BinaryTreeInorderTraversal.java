package July.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @题目 ：94. 二叉树的中序遍历
 * @题目描述： 给定一个二叉树，返回它的中序 遍历。
 * @Date: 19/7/10
 * @示例 1: 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * @示例 2: ####
 **/
public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    //递归写法 中序遍历 左根右
    private void inorder(TreeNode root, List<Integer> res) {
        if(root==null)
            return;
        if (root.left != null)
            inorder(root.left, res);
        res.add(root.val);
        if (root.right != null)
            inorder(root.right, res);
    }

    //迭代写法
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    //使用线索二叉树
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List < Integer > inorderTraversal3(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }


}



