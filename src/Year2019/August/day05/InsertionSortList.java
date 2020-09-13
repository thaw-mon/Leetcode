package Year2019.August.day05;

/**
 * @题目 ：147. 对链表进行插入排序
 * @Data: 19/8/10
 * @题目描述： 对链表进行插入排序。
 * 从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * @插入排序算法： ###
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * @题目地址： https://leetcode-cn.com/problems/insertion-sort-list/
 * @示例1: ######
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * @示例2: ###
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 **/

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode p = head.next;
        ListNode pre = head;
        ListNode p1 = head;
        //p前面的list都是排好序的了
        while (p != null) {
            //p处于末尾
            if (pre.val < p.val) {
                pre = p;
                p = p.next;
                continue;
            }
            pre.next = p.next;
            ListNode tmp = null;
            while (p1.val < p.val) {
                tmp = p1;
                p1 = p1.next;
            }
            //p插在 tmp和 p1之间
            //p为第一个节点
            if (p1 == head) {
                p.next = p1;
                head = p;

            } else {
                tmp.next = p;
                p.next = p1;
            }
            p = pre.next;
            p1 = head;
        }
        return head;
    }

}
