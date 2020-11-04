package Year2020.November.day04;

import java.util.Scanner;

public class Demo01 {

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ListNode pHead = new ListNode(0);
            ListNode p = pHead;
            for (int i = 0; i < n; i++) {
                p.next = new ListNode(scanner.nextInt());
                p = p.next;
            }
            int k = scanner.nextInt();
            ListNode ret = FindKthToTail(pHead.next, k);
            if (ret != null) {
                System.out.println(ret.val);
            }else
                System.out.println(0);
        }
    }

    /**
     * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
     */
    public static ListNode FindKthToTail(ListNode pListHead, int k) {
        ListNode pHead = new ListNode(0);
        pHead.next = pListHead;
        ListNode ret = pHead;
        ListNode p = pHead;
        for (int i = 0; i < k; i++) {
            p = p.next;
            if (p == null) return null;
        }
        while (p != null) {
            p = p.next;
            ret = ret.next;
        }
        return ret;
    }
}
