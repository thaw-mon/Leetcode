package Year2020.October.day04;

public class Demo02 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode preHead = new ListNode(0);
        preHead.next = pHead;
        ListNode pre = preHead;
        ListNode p = pHead;
        ListNode next;
        while (p != null) {
            next = p.next;
            boolean flag = false;
            //重复节点，删除next节点
            while (next != null && p.val == next.val) {
                p.next = next.next;
                next = p.next;
                flag = true;
            }
            //重复节点，删除p节点
            if(flag) {
                pre.next = p.next;
            }else {
                pre = p;
            }
            p = p.next;
        }
        return preHead.next;
    }
}
