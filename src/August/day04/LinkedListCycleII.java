package August.day04;

/**
 * @题目 ：142. 环形链表 II
 * @Data: 19/8/08
 * @题目描述： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * @说明： 不允许修改给定的链表。
 * @题目地址： https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @示例1: ######
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * @示例2: ###
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * @示例3: ###
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 **/

public class LinkedListCycleII {

    //常见的快慢指针法
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        int step = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            step++;
            //存在闭合环
            if (fast == slow) {
                return findCyclePoint(head,fast);
            }
        }
        return null;
    }


    //原理 设到环起点的长度为a， 环长度为c， 相遇点到环起点长度为b
    //可以知道 慢者相遇走了a+b,快者走了2(a+b),同时快者再环里面走了k圈
    // 2(a+b) = a + kc + b  ==> a = kc-b
    //因此 当两者以相同速率一个从head出发，一个从相遇点p(p = a + b)出发。
    // 当走了a步后，head来到了起始点 (p+a) mod c = p-b = a
    // 即二者在起点a相遇
    private ListNode findCyclePoint(ListNode head, ListNode p){
        while (head != p){
            head = head.next;
            p = p.next;
        }
        return p;
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
