package Year2020.September.day10;

import java.util.LinkedList;
import java.util.Queue;

public class Demo04 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * 思路 : 从root1中找到和root2相同的起始节点,然后进行遍历判定
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //Question : 空树是空树的子结构吗？？
        if (root2 == null || root1 == null) return false; //约定空树不是子结构
        //1.对root1进行非递归的层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                //判定当前节点是否匹配root2
                if (compareTree(node, root2)) return true;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return false;
    }

    /**
     * 判定node2是否为node1的子结构
     * @param node1
     * @param node2
     * @return
     */
    private boolean compareTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null) return false;

        if (node1.val == node2.val) {
            return compareTree(node1.left, node2.left) && compareTree(node1.right, node2.right);
        } else {
            return false;
        }
    }
}
