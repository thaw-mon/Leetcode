package June.day07;

/**
 * @Data 19/6/6
 * @题目描述： 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @示例：
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesInPairs {

    //蛮简单的，交换时注意指针的先后顺序
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        ListNode p = preHead;
        ListNode pre = p;
        p.next = head;
        p = p.next;
        while (p != null){
            ListNode q = p.next;
            if(q !=null){
                pre.next = p.next;
                p.next = q.next;
                q.next = p;
            }
            pre = p;
            p = p.next;
        }
        return preHead.next;
    }


}
