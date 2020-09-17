package Year2020.September.day10;

public class Demo02 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {

        ListNode pre = null, p = head;
        while (p != null) {
            ListNode tmp = p;
            p = p.next; //指向下一个节点
            //当前节点进行反转
            tmp.next = pre;
            pre = tmp;
        }
        return pre; //
    }

}
