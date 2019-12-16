package August.day15;

/**
 * @题目 ：203. Remove Linked List Elements
 * @Data 19/8/30
 * @题目描述： Remove all elements from a linked list of integers that have value val.
 * @题目地址： 链接：https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @示例1: ######
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * @示例2: ###
 * @示例3: ###
 */

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode p = preHead;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else
                p = p.next;
        }
        return preHead.next;
    }
}
