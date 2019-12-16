package July.day14;

import java.util.LinkedList;
import java.util.List;

/**
 * @题目 ：117. 填充每个节点的下一个右侧节点指针 II
 * @Data: 19/7/17
 * @题目描述： 给定一个二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * @示例 1：
 * @示例 2: ###
 **/

public class PopulatingRightPointersNodeII {

    //类似于前一题，不过不是完美二叉树了
    public Node connect(Node root) {

        Node pre = null;
        Node head = null;
        Node p = root;
        while (p != null) {
            Node cur = p;
            //在cur层连接下一层的next节点
            while (cur != null) {
                if (cur.left != null) {
                    if (pre == null)
                        head = cur.left;
                    else
                        pre.next = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre == null)
                        head = cur.right;
                    else
                        pre.next = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            //进入cur层的下一层或退出
            pre = null;
            p = p == head ? null : head;
        }
        return root;
    }
}
