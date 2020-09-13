package Year2020.February.day04;

public class Demo03 {

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
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前
     * 你应当保留两个分区中每个节点的初始相对位置
     * @param head : 初始链表
     * @param x ： 分割阈值
     * @return 修改后的链表
     */
    public ListNode partition(ListNode head, int x) {
        //1.分成两个链表
        ListNode p = head;
        ListNode lessHead = new ListNode(0),moreHead = new ListNode(0);; //指向不同节点类型的尾部节点
        ListNode less = lessHead, more = moreHead; //指向最后一个节点
        //遍历head节点
        while (p != null){
            //小节点
            if(p.val < x){
                less.next = p;
                less = less.next;
            }
            else {
                more.next = p;
                more = more.next;
            }
            p = p.next;
        }
        //断链
        more.next = null;

        //重新连接
        less.next = moreHead.next;
        head = lessHead.next;
        return head;

    }
}
