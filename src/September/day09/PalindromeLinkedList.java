package September.day09;

/**
 * @题目 ： 234. Palindrome Linked List
 * @Data 19/9/16
 * @题目描述： Given a singly linked list, determine if it is a palindrome.
 * @题目地址： 链接：https://leetcode-cn.com/problems/palindrome-linked-list/
 * @示例1: ######
 * Input: 1->2
 * Output: false
 * @示例2: ###
 * Input: 1->2->2->1
 * Output: true
 * @示例3: ###
 */

public class PalindromeLinkedList {
    //判断链表是否位回文序列
    //思路1:采用头插法，创建一个逆序链表，进行对比
    //思路2:采用快慢指针法,同时修改慢指针的指向。
    // 当快指针到达尾部时，慢指针恰好到达中部，慢指针从两边再次遍历一遍。
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //快慢指针法
        ListNode slow = head, fast = head;
        ListNode right = null, left = null;
        while (fast != null && fast.next != null) {
            right = slow;
            slow = slow.next;
            fast = fast.next.next;
            //将slow的前一个节点进行转向
            right.next = left;
            left = right;
        }
        //链表长度为偶数
        if (fast == null) {
            right = slow;
        } else {
            //链表长度为奇数
            right = slow.next;
        }
        while (left != null && right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
