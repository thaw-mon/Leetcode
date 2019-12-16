package August.day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @题目 ：199. Binary Tree Right Side View
 * @Data 19/8/29
 * @题目描述： Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * @题目地址： 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * @示例1: ######
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * @示例2: ###
 * @示例3: ###
 */

public class BinaryTreeRightSideView {

    //本质上还是层次遍历,只是层次遍历时从左到右，而这里是从右到左,且只保存每一层的最后一个数字
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (i == 0)
                    res.add(root.val);
                if (root.right != null) queue.add(root.right);
                if (root.left != null) queue.add(root.left);
            }
        }
        return res;
    }
}
