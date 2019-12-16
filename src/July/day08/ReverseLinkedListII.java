package July.day08;

/**
 * @题目 ：92. 反转链表 II
 * @题目描述： 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * @Date: 19/7/10
 * @示例 1: 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @示例 2: ####
 **/

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;  //指向m的前一个节点
        ListNode p = head;
        int count = 0;
        while (pre.next != null) {
            count++;
            if (count == m)
                break;
            pre = pre.next;
        }
        p = pre.next; //指向第m个节点
        while (count < n) {
            ListNode tmp = pre.next;
            pre.next = p.next;
            p.next = pre.next.next;
            pre.next.next = tmp;
            count++;
        }

        return preHead.next;
    }
}
