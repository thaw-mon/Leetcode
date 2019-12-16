package July.day06;

/**
 * @题目 ：83. 删除排序链表中的重复元素
 * @题目描述： 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @Date:19/7/8
 * @示例 1: 输入: 1->1->2
 * 输出: 1->2
 * @示例 2: 输入: 1->1->2->3->3
 * 输出: 1->2->3
 **/

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        //空链表的链表
        if (head == null) return head;
        //创建辅助节点
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        //s为非重复链表
        ListNode s = preHead;
        ListNode p = head;
        ListNode q = p;
        while (q != null) {
           if(p.val != q.val){
               p.next = q;
               p = p.next;
           }
           q = q.next;
        }
        p.next = null;
        return preHead.next;
    }
}
