package Year2019.August.day07;

/**
 * @题目 ：160. 相交链表
 * @Data: 19/8/13
 * @题目描述： 编写一个程序，找到两个单链表相交的起始节点。
 * @注意： ####
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * @题目地址： https://leetcode-cn.com/problems/min-stack/
 * @示例1: ######
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * @示例2: ###
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * @示例3: ###
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 **/

public class IntersectionoTwoLinkedLists {
    //思路: 1. 把A变成环形 2. 从B开始用快慢指针法找到环形的起始点（结果） 3. 把A环打开
    //TODO 分析 ： 实际结果很慢，按道理不应该啊 大体应该和双制作差不多的，可能是因为把模块拆分，写了很多子函数的原因
//    作者：LeetCode
//链接：https://leetcode-cn.com/problems/two-sum/solution/xiang-jiao-lian-biao-by-leetcode/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    // TODO 优化方法 双指针法:
//    创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
//当 pApA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
//若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1. 把A变成环形
        ListNode tail = LinkedListToCycle(headA);
        //2. 从B开始用快慢指针法找到环形的起始点（结果）
        ListNode res = detectCycle(headB);
        //3. 把环状节点复原
        if (tail != null)
            tail.next = null;
        return res;
    }

    //功能:把链表尾部链接到头部形成环状,返回尾部节点
    private ListNode LinkedListToCycle(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        //循环遍历到尾部节点
        while (p.next != null)
            p = p.next;
        p.next = head;
        return p;
    }

    //下面的代码是从day04.LinkedListCycleII中直接复制的
    //常见的快慢指针法
    private ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        int step = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            step++;
            //存在闭合环
            if (fast == slow) {
                return findCyclePoint(head, fast);
            }
        }
        return null;
    }


    //原理 设到环起点的长度为a， 环长度为c， 相遇点到环起点长度为b
    //可以知道 慢者相遇走了a+b,快者走了2(a+b),同时快者再环里面走了k圈
    // 2(a+b) = a + kc + b  ==> a = kc-b
    //因此 当两者以相同速率一个从head出发，一个从相遇点p(p = a + b)出发。
    // 当走了a步后，head来到了起始点 (p+a) mod c = p-b = a
    // 即二者在起点a相遇
    private ListNode findCyclePoint(ListNode head, ListNode p) {
        while (head != p) {
            head = head.next;
            p = p.next;
        }
        return p;
    }
}
