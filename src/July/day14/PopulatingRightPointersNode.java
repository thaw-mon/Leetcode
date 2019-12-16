package July.day14;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @题目 ：116. 填充每个节点的下一个右侧节点指针
 * @Data: 19/7/17
 * @题目描述： 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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

public class PopulatingRightPointersNode {

    //本质上是层次遍历+保留上一个节点信息
    //要使用O(1)空间，不符合题意
    public Node connect(Node root) {
        if (root == null)
            return null;
        List<Node> list = new LinkedList<>();
        list.add(root);
        Node pre = null, p;
        int size;
        while (!list.isEmpty()) {
            size = list.size();
            for (int i = 0; i < size; i++) {
                p = list.remove(0);
                if (pre != null)
                    pre.next = p;
                pre = p;
                if (p.left != null) list.add(p.left);
                if (p.right != null) list.add(p.right);
            }
            pre = null;
        }
        return root;
    }

    //优化，使用O(1)空间
//      作者：powcai
//            链接：https://leetcode-cn.com/problems/two-sum/solution/di-gui-he-die-dai-by-powcai-4/
//            来源：力扣（LeetCode）
//            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //TODO 注意条件==> 给定一个完美二叉树
    public Node connect2(Node root) {
        if (root == null)
            return null;
        Node pre = root;
        while (pre != null) {
            Node cur = pre;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;

        }
        return root;
    }
}
