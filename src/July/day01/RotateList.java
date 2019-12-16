package July.day01;

/**
 * @题目 ：61. 旋转链表
 * @题目描述： 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 * @Date:19/7/1
 * @示例 1: 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * @示例 2: 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 **/

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int n = 1;
        ListNode p = head;
        //p指向最后一个数字 n为链表的长度
        while (p.next != null) {
            p = p.next;
            n++;
        }
        //定义要移动的长度
        int move = n - k % n;
        if(move==n){
            return head;
        }
        ListNode q = head;
        for (int i = 1; i < move; i++) {
            q = q.next;
        }
        ListNode res = q.next;
        p.next = head;
        q.next = null;

        return res;
    }
}
