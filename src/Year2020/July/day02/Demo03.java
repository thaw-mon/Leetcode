package Year2020.July.day02;

/**
 * @Title : 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * @Date : 2020/07/05
 * @思路 ：DFS思想
 */
public class Demo03 {
    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int goodNodes(TreeNode root) {
        return DFS(root,root.val);
    }

    public int DFS(TreeNode root,int maxValue){
        //判断当前节点是否位null
        if(root == null) return 0;
        if(root.val > maxValue){
            maxValue = root.val;
        }
        int l = DFS(root.left,maxValue); //遍历左子树
        int r = DFS(root.right,maxValue); //遍历右子树
        //遍历当前节点
        return l + r + (maxValue > root.val ? 0:1);
    }
}
