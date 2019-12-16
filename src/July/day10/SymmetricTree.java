package July.day10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @题目 ：101. 对称二叉树
 * @题目描述： 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * @示例 1: ###
 * @示例 2: ###
 **/

public class SymmetricTree {
    //中序遍历的结果是对称的
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        //判断left是否和right对称
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;
        if (l.val != r.val)
            return false;
        return helper(l.left, r.right) && helper(r.left, l.right);
    }

//    迭代写法 ==>通常要使用堆栈或队列
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/dui-cheng-er-cha-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
