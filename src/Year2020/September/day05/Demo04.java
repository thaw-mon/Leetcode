package Year2020.September.day05;

import java.util.Arrays;
import java.util.List;

public class Demo04 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return DP(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode DP(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        //1.获取pre首字符
        if (preLeft > preRight) return null;
        TreeNode root = new TreeNode(pre[preLeft]);
        //从in中找到 root.val;
        int inIndex = inLeft;
        for (; inIndex <= inRight; inIndex++) {
            if (root.val == in[inIndex]) break;
        }
        int leftLen = inIndex - inLeft;
        //2-1 构造左子树
        root.left = DP(pre, in, preLeft + 1, preLeft + leftLen, inLeft, inIndex - 1);
        //2-2 构造右子树
        root.right = DP(pre, in, preLeft + leftLen + 1, preRight, inIndex + 1, inRight);

        return root;
    }
    //main
}
