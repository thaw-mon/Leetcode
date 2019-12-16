package October.day10;

/**
 * @题目 ： 328. Odd Even Linked List
 * @Data 19/10/19
 * @题目描述： Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * @题目链接： 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * @示例1: ######
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * @示例2: ######
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * @示例3: ###
 */


public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        //定义头指针
        if (head == null) return head;
        //定义奇数、偶数指针
        ListNode odd = head;
        ListNode even = head.next;
        //定义偶数头部指针（固定值）
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            //odd.next = even.next
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
            //奇数指针指向偶数指针的头部
            odd.next = evenHead;

        }
        return head;
    }
}
