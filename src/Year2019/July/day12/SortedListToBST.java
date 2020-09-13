package Year2019.July.day12;


/**
 * @题目 ：109.  有序链表转换二叉搜索树
 * @题目描述： 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 给定有序链表: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * @示例 2: ###
 **/

public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    //1. 快慢指针法-->时间换空间，找到中间值
    private TreeNode helper(ListNode head) {
        if (head == null)
            return null;
        ListNode fastNode = head, slowNode = head, preNode = null;
        while (fastNode != null && fastNode.next != null) {
            preNode = slowNode;
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        //分割链表
        if (preNode != null) {
            preNode.next = null;
        }
        TreeNode root = new TreeNode(slowNode.val);
        //防止节点一直在head死循环
        if (head == slowNode)
            return root;
        root.left = helper(head);
        root.right = helper(slowNode.next);
        return root;
    }


    public TreeNode sortedListToBST2(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        int[] nums = new int[n];
        n = 0;
        p = head;
        while (p != null) {
            nums[n++] = p.val;
            p = p.next;
        }

        return helper2(nums,0,n-1);
    }

    // 2. 空间换时间，把ListNode准换为nums
    private TreeNode helper2(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode lnode = helper2(nums, left, mid - 1);
        TreeNode rnode = helper2(nums, mid + 1, right);
        root.left = lnode;
        root.right = rnode;

        return root;
    }
}
