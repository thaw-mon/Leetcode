package Year2020.March.day13;

import java.util.ArrayList;
import java.util.List;

public class Demo03 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        //DFS写法
        List<TreeNode> ret = DFS(1, n);
        return ret;
    }

    public List<TreeNode> DFS(int start, int end) {
        if (start > end)
            return new ArrayList<>();
        List<TreeNode> ret = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = DFS(start, i - 1);
            List<TreeNode> right = DFS(i + 1, end);
            //存在子树为null的情形
            if(left.isEmpty() || right.isEmpty()){
                if(left.isEmpty()){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(i);
                        root.right = r;
                        ret.add(root);
                    }
                }
                if(right.isEmpty()){
                    for(TreeNode l : left){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        ret.add(root);
                    }
                }
                //左右子树都为空
                if(left.isEmpty() && right.isEmpty()){
                    TreeNode root = new TreeNode(i);
                    ret.add(root);
                }
            }else {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        ret.add(root);
                    }
                }
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        int n = 3;
        List<TreeNode> ans = demo03.generateTrees(n);
        System.out.println(ans.size());
    }
}
