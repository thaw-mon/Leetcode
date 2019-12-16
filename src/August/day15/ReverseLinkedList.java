package August.day15;

/**
 * @题目 ：206. Reverse Linked List
 * @Data 19/8/30
 * @题目描述： Reverse a singly linked list.
 * @题目地址： 链接：https://leetcode-cn.com/problems/reverse-linked-list/
 * @示例1: ######
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * @示例2: ###
 * @示例3: ###
 */

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode p = head;
        if (p == null) return null;
        while (p.next != null) {
            ListNode node = p.next;
            p.next = p.next.next;
            node.next = preHead.next;
            preHead.next = node;
        }
        return preHead.next;
    }

    //递归写法
//     作者：LeetCode
//    链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
