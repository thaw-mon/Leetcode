package Year2019.July.day06;

/**
 * @题目 ：82. 删除排序链表中的重复元素 II
 * @题目描述： 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * @Date:19/7/8
 * @示例 1: 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * @示例 2: 输入: 1->1->1->2->3
 * 输出: 2->3
 **/

public class RemoveDuplicatesFromSortedListII {


    //注意链表为空的长度为1的判断
    public ListNode deleteDuplicates(ListNode head) {
        //空链表或长度为1的链表
        if (head == null || head.next==null) return head;
        //创建辅助节点
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        //s为非重复链表
        ListNode s = preHead;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            while (q != null && p.val == q.val) {
                q = q.next;
            }
            // p为非重复数字
            if (p.next == q) {
                s.next = p;
                s = s.next;
            }
            p = q;
        }
        s.next = null;
        return preHead.next;
    }
}
