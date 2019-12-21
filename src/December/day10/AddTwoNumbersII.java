package December.day10;

import java.util.List;
import java.util.Stack;

/**
 * @题目 ：445. Add Two Numbers II
 * @Data 19/12/21
 * @题目描述： You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * @题目链接： 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * @示例1: ######
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * @示例2: ######
 * @示例3: ###
 */

public class AddTwoNumbersII {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //注意几个问题： 1.进位 2.不同数字长度不一致
    //way1 : 根据提示 把链表节点进行反转
    //way2 ：使用堆栈记录链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.add(l1);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.add(l2);
                l2 = l2.next;
            }
        }
        ListNode res = new ListNode(0); //建立一个头节点：使用头插法插入其余节点
        int val = 0, carry = 0; //记录当前值和进位
        while (!s1.isEmpty() || !s2.isEmpty()) {
            val = s1.isEmpty() ? 0 : s1.pop().val;
            val += s2.isEmpty() ? 0 : s2.pop().val;
            val += carry;
            carry = 0;
            if (val >= 10) {
                val %= 10;
                carry = 1;
            }
            ListNode node = new ListNode(val);
            node.next = res.next;
            res.next = node;
        }
        if(carry > 0){
            ListNode node = new ListNode(carry);
            node.next = res.next;
            res.next = node;
        }
        return res.next;
    }


    //解法2 ：获取链表的长度，然后使用0补全，最后进行递归
}
