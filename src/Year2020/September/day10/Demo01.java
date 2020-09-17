package Year2020.September.day10;

import java.util.Stack;

public class Demo01 {

     class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * 思路1 ：变量一遍获取总长度n，然后顺序获取第n-i个节点
     * 思路2 ：使用栈保存之前变量的节点，遍历完成后进行出栈k次操作
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        int n = 0;
        //1.全部节点入栈
        while (p != null) {
            stack.push(p);
            p = p.next;
            n++;
        }
        if (k > n || k <= 0) return null;
        //然后出栈k个
        ListNode ret = null;
        for (int i = 0; i < k; i++) {
            ret = stack.pop();
        }
        return ret;
    }


}
