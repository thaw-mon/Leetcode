package June.day06;

/**
 * @Data 19/6/5
 * @题目描述： 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @示例： 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */

public class RemoveNthNodeFromEndOfList {

    //双指针一边遍历
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode p = head;
        //1. p走到第n个节点 此时head节点就是相对的倒数第n个节点的前一个
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        //释放头节点
        if(p==null){
            head = pre.next;
            return head;

        }
        //2. p走到最后一个节点 ，pre指向要删除的节点的前一个节点
        while (p.next !=null){
            p = p.next;
            pre = pre.next;
        }
        ListNode q = pre.next;
        pre.next = q.next;
        //释放内存
//        clean(q);
        return head;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
    //思路是一样的，但是这里通过创建一个哑节点dummy简化了极端情形
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
