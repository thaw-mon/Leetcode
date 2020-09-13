package Year2020.March.day10;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {


    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     * 要求返回这个链表的 深拷贝。
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        //对于存在random_index如何进行深拷贝
        //1.首先通过next进行拷贝
        Node ret = new Node(0);
        List<Node> nodeList = new ArrayList<>(); //记录节点索引
        Node p = head, q = ret;
        while (p != null) {
            Node node = new Node(p.val);
            nodeList.add(node);
            q.next = node;
            q = q.next;
            p = p.next;
        }
        //2.记录每个节点random_index的位置
        List<Integer> random_index = new ArrayList<>();
        p = head;
        int currentIndex = 0; //记录当前节点所在位置
        int len = nodeList.size(); //记录节点的长度
        while (p != null) {
            q = p.random;
            if (q == null) {
                random_index.add(-1); //
            } else {
                int step = 0;
                while (q != null && q != p) {
                    q = q.next;
                    step++;
                }
                if (q == p) {
                    random_index.add(currentIndex - step);
                } else {
                    random_index.add(len - step);
                }
            }
            currentIndex++;
            p = p.next;
        }
        //根据random_index构建random
        p = ret.next;
        currentIndex = 0; //重置索引
        while (p != null) {
            int index = random_index.get(currentIndex);
            if(index >= 0)
                p.random = nodeList.get(index);
            p = p.next;
            currentIndex++;
        }
        return ret.next;
    }
}
