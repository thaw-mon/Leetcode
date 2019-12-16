package September.day10;

/**
 * @题目 ： 237. Delete Node in a Linked List
 * @Data 19/9/17
 * @题目描述：Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * @题目地址： 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 * @示例1: ######
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * @示例2: ###
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * @示例3: ###
 */

public class DeleteNode {

    //题目很简单，描述很坑爹
    //node是要删除的节点，于是用下一个节点值替代node,然后删除下一个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
