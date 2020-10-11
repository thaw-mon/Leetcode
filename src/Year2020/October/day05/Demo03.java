package Year2020.October.day05;

public class Demo03 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     * 采取中序遍历法
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k <= 0 || pRoot == null) return null;
        return inOrder(pRoot, new int[]{k});
    }

    private TreeNode inOrder(TreeNode root, int[] k) {
        TreeNode ret = null;
        if (root.left != null)
            ret = inOrder(root.left, k);
        if (ret != null) return ret;
        k[0]--;
        if (k[0] == 0) {
            ret = root;
            return ret;
        }
        if (root.right != null) ret = inOrder(root.right, k);

        return ret;
    }

    public static void main(String[] args) {
        new Demo03().test();
    }

    public void test() {
        // 2 4 5 10 15 18 19 20 25
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(18);
        TreeNode p = root.left;
        p.left = new TreeNode(2);
        p.left.right = new TreeNode(4);
        p = root.right;
        p.left = new TreeNode(15);
        p.right = new TreeNode(25);
        p.right.left = new TreeNode(20);
        p.right.left.left = new TreeNode(19);

        TreeNode ret = KthNode(null, 10);
        if (ret == null) System.out.println("no answer");
        else System.out.println(ret.val);
    }
}
