package Year2020.September.day16;

public class Demo02 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点。
     * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     * 公共节点定义有歧义：是val相等就是公共节点，还是直接比较 node
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        //1.暴力解法
        ListNode p1 = pHead1;
        while (p1 != null) {
            ListNode p2 = pHead2;
            boolean flag = false;
            while (p2 != null) {
                if (p1 == p2) {
                    flag = true;
                    break;
                }
                p2 = p2.next;
            }
            if (flag) break;
            p1 = p1.next;
        }
        return p1;
    }

    //ADD 根据题解的优化思路
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

}
