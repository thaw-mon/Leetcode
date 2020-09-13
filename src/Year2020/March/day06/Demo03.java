package Year2020.March.day06;

public class Demo03 {


    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，
     * 修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     *
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        //采取 right root left的遍历方式进行计数,并修改value
        BFS(root,0);
        return root;
    }

    public int BFS(TreeNode root, int value) {
        //空节点
        if (root == null) return value;

        int rValue = BFS(root.right,value);
        root.val += rValue;
        int lValue = BFS(root.left,root.val);

        return lValue;
    }
}
