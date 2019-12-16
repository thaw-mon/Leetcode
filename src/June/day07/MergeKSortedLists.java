package June.day07;

/**
 * @Data 19/6/6
 * @题目描述： 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * @示例： 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 思路：和两个有序链表没多大区别
 */
public class MergeKSortedLists {

    //时间复杂O(N*K) 主要是比较环节可以优化到 logk
    //官方解答思路
    //1.比较环节采用优先队列 ==》 logk
    //2. 采用两两比较 链表合并策略 和分治的思想  ==>递归归并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode[] listNodes = lists;
        int[] values = new int[lists.length];
        int notNullSize =getNotNullSize(listNodes);
        for (int i = 0; i < listNodes.length; i++) {
            if (listNodes[i] != null) {
                values[i] = listNodes[i].val;
            } else {
                values[i] = Integer.MAX_VALUE;
            }
        }

        while (notNullSize > 0) {
            int key = getMinValueKey(values);
            //插入节点
            p.next = listNodes[key];
            p = p.next;
            //指向下一节点
            listNodes[key] = listNodes[key].next;
            //更新value值
//            values[key] = listNodes[key] == null ? Integer.MAX_VALUE : listNodes[key].val;
            if (listNodes[key] == null) {
                values[key] = Integer.MAX_VALUE;
                notNullSize--;
            } else {
                values[key] = listNodes[key].val;
            }
        }

        return head.next;
    }

    //只要一个非空 就返回false
    boolean isEmptyList(ListNode[] nodes) {
        boolean res = true;
        for (ListNode node : nodes) {
            if (node != null) {
                res = false;
                break;
            }
        }
        return res;
    }

    int getMinValueKey(int[] values) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < values.length; i++) {
            if (min > values[i]) {
                min = values[i];
                res = i;
            }
//            min = Math.min(min, values[i]);
        }
        return res;
    }

    int getNotNullSize(ListNode[] nodes){
        int res = 0;
        for (ListNode node : nodes) {
            if(node !=null){
                res++;
            }
        }
        return res;
    }

//    作者：user9827R
//    链接：https://leetcode-cn.com/problems/two-sum/solution/he-bing-k-ge-pai-xu-lian-biao-by-user9827r/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        // 归并
        return solve(lists, 0, lists.length-1);
    }

    private ListNode solve(ListNode[] arr, int left, int right){
        if(left == right)
            return arr[left];

        int mid = (left + right) >> 1;
        ListNode lNode = solve(arr, left, mid);
        ListNode rNode = solve(arr, mid+1, right);

        return merge(lNode, rNode);
    }

    private ListNode merge(ListNode node1, ListNode node2){
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;

        if(node1.val < node2.val){
            node1.next = merge(node1.next, node2);
            return node1;
        }else{
            node2.next = merge(node1, node2.next);
            return node2;
        }

    }

}
