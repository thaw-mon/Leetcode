package Year2020.September.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo6 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * 思路 : DFS
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        bfs(root, target, 0, new Stack<Integer>(), ret);
        return ret;
    }

    private void bfs(TreeNode root, int target, int currentVal, Stack<Integer> stack, ArrayList<ArrayList<Integer>> ans) {
        //当前节点为叶子节点
        currentVal += root.val;
        stack.push(root.val);
        if (root.left == null && root.right == null) {
            if (currentVal == target) {
                ans.add(new ArrayList<>(stack));
            }
            stack.pop();
            return;
        }

        //非叶子节点
        if (root.left != null)
            bfs(root.left, target, currentVal, stack, ans);
        if (root.right != null)
            bfs(root.right, target, currentVal, stack, ans);
        //当前节点pop
        stack.pop();
    }
}
