package August.day05;

/**
 * @题目 ：148. 排序链表
 * @Data: 19/8/10
 * @题目描述： 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * @题目地址： https://leetcode-cn.com/problems/sort-list/
 * @示例1: ######
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * @示例2: ###
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 **/

public class SortList {

    //想要达到nlogn的时间复杂度，常见的方法是归并排序法
    //由于是链表的形式，所以需要使用快慢指针找到其mid

    //本来以为在找中间节点时进行预处理（Qsort）会快一点，结果反而超时了
    //如果要使用类似于Qsort方法，由于时链表形式，需要返回头部和尾部，
    // 否则每一次merge都要再遍历一遍left,浪费了很多时间
    public ListNode sortList(ListNode head) {
        //空或者一个节点，直接返回
        if (head == null || head.next == null)
            return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val < head.val) {
                ListNode tmp = p.next;
                p.next = tmp.next;
                //采用头插法插入mid之前
                ListNode p1 = preHead.next;
                preHead.next = tmp;
                tmp.next = p1;
            }else {
                p = p.next;
            }

        }
        //拆分为两条链表
        ListNode r = head.next;
        head.next = null;

        //分别进行排序
        ListNode left = sortList(preHead.next);
        ListNode right = sortList(r);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode l = left;
        ListNode r = right;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        if (l == null)
            p.next = r;
        if (r == null)
            p.next = l;

        return res.next;
    }

    //作者：jyd
    //    链接：https://leetcode-cn.com/problems/two-sum/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //直接使用快慢指针找mid 然后归并算法
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList2(head);
        ListNode right = sortList2(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }




}
