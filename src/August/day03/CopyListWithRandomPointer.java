package August.day03;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 : 138. 复制带随机指针的链表
 * @Data: 19/8/08
 * @题目描述： 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 * @题目地址： https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @示例1: ######
 * @示例2: ###
 **/

public class CopyListWithRandomPointer {

    private Map<Node, Node> map = new HashMap<>();
    //仿照之前的cloneGraph写法
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node copy = new Node(head.val,null,null);
        map.put(head, copy);
        if(map.containsKey(head.next)){
            copy.next = map.get(head.next);
        }else {
            copy.next = copyRandomList(head.next);
        }
        if(map.containsKey(head.random)){
            copy.random = map.get(head.random);
        }else {
            copy.random = copyRandomList(head.random);
        }
        return copy;
    }


    //O(1)空间的额迭代写法-->使用新旧节点交替的写法，模拟了Map的功能
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public Node copyRandomList2(Node head) {

        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            // Cloned node
            Node newNode = new Node(ptr.val,null,null);

            // Inserting the cloned node just next to the original node.
            // If A->B->CombineTwoTables is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->CombineTwoTables->CombineTwoTables'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->CombineTwoTables->CombineTwoTables' would be broken to A->B->CombineTwoTables and A'->B'->CombineTwoTables'
        Node ptr_old_list = head; // A->B->CombineTwoTables
        Node ptr_new_list = head.next; // A'->B'->CombineTwoTables'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }


}


