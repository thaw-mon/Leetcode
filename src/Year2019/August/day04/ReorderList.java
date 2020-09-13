package Year2019.August.day04;

/**
 * @题目 ：143. 重排链表
 * @Data: 19/8/09
 * @题目描述： 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @题目地址： https://leetcode-cn.com/problems/reorder-list/
 * @示例1: ######
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * @示例2: ###
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 **/

public class ReorderList {
    // n = 6  1 2 3 4 5 6 ==> 1 6 2 5 3 4
    // n = 7  1 2 3 4 5 6 7  ==> 1 7 2 6 3 5 4

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(5);
        ListNode p5 = new ListNode(6);
        ListNode p6 = new ListNode(7);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = null;

        new ReorderList().reorderList(head);
    }

    public void reorderList(ListNode head) {
        //1.快慢指针找到中间点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //1.2 将链表分为两段
        if (slow == null || slow.next == null)
            return;
        ListNode p = slow.next;
        slow.next = null;
        //2. 对后半段进行翻转
        p = reverse(p);
        //2.2 将后半段插入前半段
        GeneratorList(head, p);

    }

    //将链表进行翻转
    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        //指向p的前一个节点
        ListNode pre = head;
        ListNode p = pre.next;
        while (p != null) {
            ListNode tmp = preHead.next;
            preHead.next = p;
            pre.next = p.next;
            p.next = tmp;
            p = pre.next;
        }
        return preHead.next;
    }

    //按规则合并两个list
    private void GeneratorList(ListNode head, ListNode p) {
        while (p != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = p.next;
            head.next = p;
            p.next = tmp1;
            head = tmp1;
            p = tmp2;
        }
    }


}
