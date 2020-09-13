package Year2019.July.day09;

import java.util.Stack;

/**
 * @题目 ：99. 恢复二叉搜索树
 * @题目描述： 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * @示例 1: 输入: [1,3,null,null,2]
 * 输出: [3,1,null,null,2]
 * @示例 2: 输入：[3,1,4,null,null,2]
 * 输出: [2,1,4,null,null,3]
 **/

public class RecoverBinarySearchTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = null;
        TreeNode p = root.left;
        p.left = null;
        p.right = new TreeNode(2);
        new RecoverBinarySearchTree().recoverTree(root);
    }

    //中序遍历，正常应该是升序
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode recordNode = null;
        TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
        //中序遍历
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (recordNode != null && root.val > recordNode.val)
                break;
            if (root.val < preNode.val && recordNode==null) {
                //此时的preNode为错误节点1 记录下来
                recordNode = preNode;
            }
            preNode = root;

            root = root.right;
        }
        //交换两个节点
        if (recordNode != null) {
            int tmp = preNode.val;
            preNode.val = recordNode.val;
            recordNode.val = tmp;
        }
    }
    //大佬的O(1)空间遍历
//    作者：windliang
//    链接：https://leetcode-cn.com/problems/two-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-21/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public void recoverTree2(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode cur = root;
        TreeNode pre_new = null;
        while (cur != null) {
            // 情况 1
            if (cur.left == null) {
                /*******************************************************/
                if (pre_new != null && cur.val < pre_new.val) {
                    if (first == null) {
                        first = pre_new;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                pre_new = cur;
                /*******************************************************/
                cur = cur.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // 情况 2.1
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                // 情况 2.2
                if (pre.right == cur) {
                    pre.right = null; // 这里可以恢复为 null
                    /*******************************************************/
                    if (pre_new != null && cur.val < pre_new.val) {
                        if (first == null) {
                            first = pre_new;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    pre_new = cur;
                    /*******************************************************/
                    cur = cur.right;
                }
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}
