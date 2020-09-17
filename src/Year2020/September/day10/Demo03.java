package Year2020.September.day10;

public class Demo03 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head, tail;
        head = tail = null;
        while (list1 != null && list2 != null) {
            //获取二者的较小值
            ListNode p = null;
            if (list1.val < list2.val) {
                p = list1;
                list1 = list1.next;
            } else {
                p = list2;
                list2 = list2.next;
            }
            //把节点p插入head
            if (head == null) {
                head = p;
                tail = p;
            } else {
                tail.next = p;
                tail = p;
            }
        }
        if (list1 != null) {
            if (head == null) {
                head = list1;
            } else{
                tail.next = list1;
            }
        }
        if (list2 != null) {
            if (head == null) {
                head = list2;
            } else{
                tail.next = list2;

            }
        }

        return head;
    }
}
