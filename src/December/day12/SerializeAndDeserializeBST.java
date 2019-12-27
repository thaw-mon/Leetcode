package December.day12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @题目 ：449. Serialize and Deserialize BST
 * @Data 19/12/24
 * @题目描述：
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * <p>
 * @题目链接： 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * @示例1: ######
 * @示例2: ######
 * @示例3: ###
 */

public class SerializeAndDeserializeBST {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    //不限制序列化的方法 node = null 显示 # 采用BFS序列化
    //这个方法也可以，但是没有充分使用 二叉搜索树的性质（可以使用前序遍历或后序的策略进行记录结果）
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        queue.add(root);
        //BFS
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                root = queue.poll();
                if (root == null) {
                    sb.append("# ");
                } else {
                    //
                    sb.append(root.val).append(" ");
                    queue.add(root.left);
                    queue.add(root.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    //eg 1 2 3 4 # 5 6 # #
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        //
        String[] array = data.split(" "); //分割为数组类型
        //判断i = 0的情形
        Queue<TreeNode> queue = new LinkedList<>();
        if (array.length == 0 || array[0].equals("#")) {
            return root;
        } else {
            root = new TreeNode(Integer.parseInt(array[0]));
        }
        queue.add(root);
        int index = 1;
        //按层次遍历
        while (!queue.isEmpty() && index < array.length) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if(array[index].equals("#")){
                    temp.left = null;
                }else {
                    temp.left = new TreeNode(Integer.parseInt(array[index]));
                    queue.add(temp.left);
                }
                index++;
                if(array[index].equals("#")){
                    temp.right = null;
                }else {
                    temp.right = new TreeNode(Integer.parseInt(array[index]));
                    queue.add(temp.right);
                }
                index++;
            }
        }

        return root;
    }
}
