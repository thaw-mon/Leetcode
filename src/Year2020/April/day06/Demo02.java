package Year2020.April.day06;

public class Demo02 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
     * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
     *
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true; //找到了路径
        if (root == null) return false; //没有有效路径

        boolean ret = false;
        //基本思想root DFS遍历
        if (root.val == head.val)
            ret = helper(head, root);
        if (ret) return true;
        ret = isSubPath(head, root.left) || isSubPath(head, root.right);
        return ret;

    }

    //判定当前节点开始是否存在连续path 使得 head == root
    private boolean helper(ListNode head, TreeNode root) {
        if (head == null) return true; //找到了路径
        if (root == null) return false; //没有有效路径

        if (root.val == head.val) return helper(head.next, root.left) || helper(head.next, root.right);

        return false;
    }
}
