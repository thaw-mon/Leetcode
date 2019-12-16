package July.day07;

/**
 * @题目 ：86. 分隔链表
 * @题目描述： 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * @Date:19/7/9
 * @示例 1: 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * @示例 2: ####
 **/

public class PartitionList {

    //更简单的思路是采用两个链表，最后合并，这样比直接再一个链表中操作减少了条件判断
    public ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode le, pre, p;  //le指向最后一个小于x的节点，ge指向第一个大于等于x的节点
        le = preHead;
        pre = preHead;
        p = head;
        while (p != null) {
            if (p.val < x) {
                //符合条件的节点指针移动
                pre.next = p.next;
                p.next = le.next;
                le.next = p;
                //le指向最后一个小于x的节点
                le = p;
            }
            if(pre.next==p){
                pre = p;
                p = p.next;
            }else {
                p = pre.next;
            }
        }
        return preHead.next;
    }
}
