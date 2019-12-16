package July.day10;

import java.util.*;

/**
 * @题目 ：103. 二叉树的锯齿形层次遍历
 * @题目描述： 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * @示例 1: ###
 * @示例 2: ###
 **/

public class BinaryTreeZigzagLevelOrderTraversal {
    //这个就是层次遍历加上转向-->由于是先进后出，所以使用栈
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //flag true表示从左到右，false表示从右到左
        boolean flag = true;
        while (!stack.isEmpty()) {
            int n = stack.size();
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> tmp = new Stack<>();
            for (int i = 0; i < n; i++) {
                root = stack.pop();
                ans.add(root.val);
                if(flag){
                    if (root.left != null)
                        tmp.push(root.left);
                    if (root.right != null)
                        tmp.push(root.right);
                }else {
                    if (root.right != null)
                        tmp.push(root.right);
                    if (root.left != null)
                        tmp.push(root.left);

                }
            }
            flag = !flag;
            res.add(ans);
            stack = tmp;
        }
        return res;
    }
}
