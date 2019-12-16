package November.day09;

import java.util.Random;

/**
 * @题目 ： 382. Linked List Random Node
 * @Data 19/11/25
 * @题目描述： Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 * @题目链接： 链接：https://leetcode-cn.com/problems/linked-list-random-node
 * @示例1: ######
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 * @示例2: ######
 * @示例3: ###
 */


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    private ListNode node;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        node = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int size = 0;
        //1.两次遍历节点
        ListNode p = node;
        while (p != null) {
            p = p.next;
            size++;
        }
        p = node;
        int num = (int) (size * Math.random());
        for (int i = 0; i < num; i++) {
            p = p.next;
        }
        return p.val;
    }

//    作者：li-zi-he
//    链接：https://leetcode-cn.com/problems/linked-list-random-node/solution/zhong-ju-si-wei-by-li-zi-he/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //蓄水池法
    int getRandom2() {
        int i=2;
        Random rand = new Random();
        ListNode cur = node.next;
        int val = node.val;
        while(cur != null) {
            if(rand.nextInt(i++) == 0) val = cur.val; //第 i 节点以 1/i 概率替换当前值
            cur = cur.next;
        }
        return val;
    }



}
