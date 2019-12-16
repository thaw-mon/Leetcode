package August.day11;

import java.util.Stack;

/**
 * @题目 ：173. Binary Search Tree Iterator
 * @Data: 19/8/18
 * @题目描述： Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * @题目地址： 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * @示例1: ######
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * @示例2: ###
 * @示例3: ###
 **/

//由于BST的特性，所以只需要中序遍历 + 栈保存结果就ok了
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (stack.isEmpty())
            return -1;
        TreeNode res = stack.pop();
        int val = res.val;
        //中序遍历右节点存在
        res = res.right;
        while (res != null) {
            stack.push(res);
            res = res.left;
        }
        return val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {

        return !stack.isEmpty();
    }
}
