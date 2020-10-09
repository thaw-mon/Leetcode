package Year2020.October.day04;

import java.util.ArrayList;
import java.util.Stack;

public class Demo05 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        //使用两个栈实现访问
        Stack<TreeNode> s1 = new Stack<>(); //left --> right
        Stack<TreeNode> s2 = new Stack<>();
        if (pRoot != null)
            s1.push(pRoot);
        while (!s1.isEmpty()) {
            ArrayList<Integer> value1 = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                value1.add(node.val);
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }
            ret.add(value1);
            ArrayList<Integer> value2 = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                value2.add(node.val);
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
            }
            if (!value2.isEmpty())
                ret.add(value2);
        }
        return ret;

    }
}
