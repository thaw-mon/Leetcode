package December.day07;

import java.util.Stack;

/**
 * @题目 ：430. Flatten a Multilevel Doubly Linked List
 * @Data 19/12/16
 * @题目描述： You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 * @题目链接： 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * @示例1: ######
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * @示例2: ######
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * @示例3: ###
 * Input: head = []
 * Output: []
 */

public class FlattenMultilevelDoublyLinkedList {

    // Definition for a Node.
     class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

    //把多向链表扁平化(变成一维双链表):顺序是从child到next
    public Node flatten(Node head) {
        if (head == null) return head;
        //使用堆栈保存递归序列
        Node current = null;
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            if (current == null) {
                current = p;
            } else {
                current.next = p;
                p.prev = current;
            }

            //如果节点没有右节点会导致提前退出
            while (current.next != null || current.child != null) {
                System.out.println("current node : " + current.val);
                if(current.prev != null)
                    System.out.println("current pre node : " + current.prev.val);
                if(current.next != null)
                    System.out.println("current node : " + current.next.val);

                //存在子节点：进入子循环
                if (current.child != null) {
                    if(current.next != null)
                        stack.add(current.next);
                    current.next = current.child;
                    current.child.prev = current;
                    current.child = null;
                }
                current = current.next;
            }

        }
        return head;
    }
}
