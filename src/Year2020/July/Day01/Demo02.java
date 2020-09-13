package Year2020.July.Day01;

import java.util.Random;

/**
 * @Title : 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 */
//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Demo02 {
    class Solution {
        int len;
        ListNode node;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            node = head;
            int count = 0;
            while (head != null) {
                head = head.next;
                count++;
            }
            len = count;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            Random random = new Random();
            int k = len;
            ListNode p = node;
            while (random.nextInt(k--) > 0) {
                p = p.next;
            }
            return p.val;
        }
    }
}
