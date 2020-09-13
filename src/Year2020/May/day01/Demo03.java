package Year2020.May.day01;

public class Demo03 {


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 最大树定义：一个树，其中每个节点的值都大于其子树中的任何其他值。
     * 最后的中序遍历结果要是一致的
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        //把值为val的节点插入root中 使得中序遍历(L root R)结果一致
        if (root == null) return new TreeNode(val);
        if (val > root.val) { //插入为左子树
            TreeNode ret = new TreeNode(val);
            ret.left = root;
            return ret;
        }
        //优先插入右子树
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
