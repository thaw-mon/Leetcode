package December.day07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @题目 ：429. N-ary Tree Level Order Traversal
 * @Data 19/12/16
 * @题目描述： Given an n-ary tree, return the level order traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * @题目链接： 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * @示例1: ######
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * @示例2: ######
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * @示例3: ###
 */
public class NaryTreeLevelOrderTraversal {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    //对n叉树进行层次遍历：easy
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> levelData = new ArrayList<>(); //表示一层节点的数据
            while (n > 0) {
                Node temp = queue.poll();
                levelData.add(temp.val);
                for (Node node : temp.children) {
                    queue.add(node);
                }
                n--;
            }
            res.add(levelData);
        }
        return res;
    }
}
