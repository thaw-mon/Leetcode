package August.day03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @题目 ：141. 环形链表
 * @Data: 19/8/08
 * @题目描述： 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * @题目地址： https://leetcode-cn.com/problems/linked-list-cycle/
 * @示例1: ######
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * @示例2: ###
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * @示例3: ###
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 **/

public class LinkedListCycle {

    //常见的快慢指针法
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && slow != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }

        return false;
    }

    //2. hash表策略 ：检查一个结点此前是否被访问过来判断链表是否为环形链表。
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/huan-xing-lian-biao-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }




    //  Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
