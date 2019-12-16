package June.day08;

/**
 * @Data 19/6/10
 * @题目描述： 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * @示例： 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * @说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode p = l1;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        ReverseNodesInKGroup r = new ReverseNodesInKGroup();
        r.reverseKGroup(l1, 2);


    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        if(k==1){
            return preHead.next;
        }
        ListNode pre = preHead;  //指向头部前一个节点
        ListNode p = pre.next; //指向头部第一个节点
        ListNode tail = head;  //指向尾部的最后一个节点
        boolean flag = true;
        while (flag) {
            // k-1 次循环
            for (int i = 1; i < k; i++) {
                if (tail == null || tail.next == null) {
                    flag = false;
                    break;
                }
                tail = tail.next;
            }
            if (!flag || tail==null)
                continue;
            //下一次循环的头节点
            p = tail.next;
            pre = reverseKnode(pre, tail, k);
            tail = p;
        }
        return preHead.next;
    }

    //将head的length长度节点交换
    public ListNode reverseKnode(ListNode preHead, ListNode tail, int length) {
        ListNode p = preHead.next;
        ListNode res = p;

        //循环更新length - 1次节点
        for (int i = 0; i < length - 1; i++) {
            ListNode tmp = tail.next;
            preHead.next = p.next;
            tail.next = p;
            p.next = tmp;

            //更新p,无需更新q
            p = preHead.next;
        }
        return res;
    }
    //大佬思路:
    //1. 采用栈的方式: 入栈和出栈完成了一次反转
    //2. 采用递归的方式

}
