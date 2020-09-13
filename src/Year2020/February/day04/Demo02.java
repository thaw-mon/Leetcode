package Year2020.February.day04;

public class Demo02 {
    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @param head 链表
     * @param k    : 节点移动次数
     * @return 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        //1.获取整个链表的长度以及k的位置
        int len = 1; //初始长度为1
        ListNode end = head; //指向链表的终点
        while (end.next != null) {
            len++;
            end = end.next;
        }
        k %= len; //长度取模
        if (k == 0) return head;
        //2.获取向右移动k次节点后的起点
        ListNode rHead = head, p = null; //p指向起点的前一个位置
        while (len - k > 0) {
            p = rHead;
            rHead = rHead.next;
            k++;
        }

        //3.断开链表重新连接,返回新的头节点
        p.next = null;
        end.next = head;

        return rHead;
    }
}
