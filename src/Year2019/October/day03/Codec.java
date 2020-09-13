package Year2019.October.day03;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @题目 ： 297. Serialize and Deserialize Binary Tree
 * @Data 19/10/06
 * @题目描述： Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * @题目地址： 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * @示例1: ######
 * You may serialize the following tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * @示例2: ###
 * @示例3: ###
 */


public class Codec {

    public static void main(String[] args) {
        String s = "1,2,3,null,null,4,5,";
        System.out.println(new Codec().serialize(new Codec().deserialize(s)));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //进行层次遍历
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root == null) {
                    sb.append("null").append(",");
                } else {
                    sb.append(root.val).append(",");
                    if (root.left != null || root.right != null)
                        flag = true;
                    queue.add(root.left);
                    queue.add(root.right);
                }
            }
            //说明下一层全部为null节点
            if (!flag)
                break;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] strArray = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        TreeNode p = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()) {
            if (index + 1 == strArray.length)
                break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                //p为null节点跳过
                if (p == null)
                    continue;
                TreeNode left = null;
                TreeNode right = null;
                if (!strArray[++index].equals("null")) {
                    left = new TreeNode(Integer.parseInt(strArray[index]));
                    p.left = left;
                }
                if (!strArray[++index].equals("null")) {
                    right = new TreeNode(Integer.parseInt(strArray[index]));
                    p.right = right;
                }

                queue.add(left);
                queue.add(right);
            }

        }

        return root;
    }
}
